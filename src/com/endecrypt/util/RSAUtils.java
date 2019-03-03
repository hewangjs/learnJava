package com.endecrypt.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.apache.axiom.om.util.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.thoughtworks.xstream.core.util.Base64Encoder;

public class RSAUtils {
	
	/** 签名算法 */
	public static final String SIGN_ALGORITHMS = "SHA1WithRSA";
	
	/** 云分期签名密钥（公钥和私钥） */
	public static String CLOUD_RSA_PUBLIC_KEY; 
	public static String CLOUD_RSA_PRIVATE_KEY;
	
	/** 云分期参数加密密钥 */
	public static RSAPublicKey APP_RSA_PUBLIC_KEY;
	public static RSAPrivateKey APP_RSA_PRIVATE_KEY;
	
	/** 加密算法 */
	private static final String ALGORITHM = "RSA";
	public static BouncyCastleProvider BCP;
	
	public static void initKeys() {
		/** 读取手机银行公钥  */
		InputStream inputStream = null;
		inputStream = RSAUtils.class.getClassLoader().getResourceAsStream("wxssoPub.keystore");
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			while((line = reader.readLine()) != null){
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		CLOUD_RSA_PUBLIC_KEY = sb.toString(); // 公钥字符串 
		
		/** 读取手机银行私钥 */
		inputStream = RSAUtils.class.getClassLoader().getResourceAsStream("wxsspPri.keystore");
		reader = new BufferedReader(new InputStreamReader(inputStream));
		sb = new StringBuilder();
		line = null;
		try {
			while((line = reader.readLine()) != null){
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		CLOUD_RSA_PRIVATE_KEY = sb.toString(); // 私钥字符串
		
		BCP = new BouncyCastleProvider();
		X509Certificate pubCert = null;
		inputStream = null;
		CertificateFactory certificateFactory;
		Base64Encoder encoder = new Base64Encoder();
		try {
			certificateFactory = CertificateFactory.getInstance("X.509");
			inputStream = RSAUtils.class.getClassLoader().getResourceAsStream("mBankPub.cer");
			pubCert = (X509Certificate)certificateFactory.generateCertificate(inputStream);
			APP_RSA_PUBLIC_KEY = (RSAPublicKey) pubCert.getPublicKey(); //得到公钥
			inputStream = RSAUtils.class.getClassLoader().getResourceAsStream("mBankPri.key");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			StringBuilder sbBuilder = new StringBuilder();
			line = null;
			while((line = bufferedReader.readLine()) != null) {
				sbBuilder.append(line);
			}
			
			String privateKey = sbBuilder.toString();
			privateKey = privateKey.replace("-----BEGIN PRIVATE KEY-----", "").replace("-----END PRIVATE KEY-----", "");
			byte[] buffer = encoder.decode(privateKey);
			PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(buffer); 
			KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
			APP_RSA_PRIVATE_KEY = (RSAPrivateKey)keyFactory.generatePrivate(privateKeySpec); //得到私钥
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * RSA签名
	 * @param content 代签名数据
	 * @param privateKey 商户私钥
	 * @param encode 字符集编码
	 * @return 签名值
	 */
	public static String sign(String content, String encode){
		try {
			/** 使用Base64的编码key创建 一个PKCS8EncodedKeySpec */
			PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decode(CLOUD_RSA_PRIVATE_KEY.toString()));			
			KeyFactory keyf = KeyFactory.getInstance("RSA"); // 一个密钥工厂，使用RSA算法转换公私钥
			PrivateKey priKey = keyf.generatePrivate(priPKCS8);
			/** 生成指定摘要算法的Signature对象 */
			java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);
			
			signature.initSign(priKey); // 使用私钥初始化签名
			signature.update(content.getBytes(encode)); // 使用数据content更新将被签名或检验的数据
			byte[] signed = signature.sign(); // 返回更新的所有数据的签名字节
			return Base64.encode(signed); //返回签名的Base64编码
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 校验签名值
	 * @param content 待签名数据
	 * @param sign 签名值
	 * 整体思路
	 * 1. 使用相同的Hash算法（SIGN_ALGORITHMS），根据内容（content），生成一个数字签名
	 * 2. 使用公钥解密传送过来的数字签名sign
	 * 3. 比较步骤1与步骤2的数字签名是否相同
	 * 4. 相同则数据是完整的，没有被修改的，不相同数据(content)被修改了
	 */	
	public static boolean doCheck(String content, String sign) {
		try {
			KeyFactory keyFactory = KeyFactory.getInstance("RSA"); // 一个密钥工厂，使用RSA算法转换公私钥
			byte[] encodedKey = Base64.decode(CLOUD_RSA_PUBLIC_KEY);// 字符串解码得到字节数组
			/** new X509EncodedKeySpec(encodedKey) 使用已编码的key字节数组创建一个 X509EncodedKeySpec对象
			keyFactory.generatePublic() 使用提供的密钥规范生成公钥对象 */
			PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
			/** 生成指定摘要算法的Signature对象 */
			java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);
			signature.initVerify(pubKey); // 使用给定证书中的公钥初始化此对象以进行验证。
			signature.update(content.getBytes()); // 使用字节更新将被签名或检验的数据
			
			boolean bverify = signature.verify(Base64.decode(sign)); // 验证传入的签名 传入参数是将被校验的字节数组
			return bverify;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
