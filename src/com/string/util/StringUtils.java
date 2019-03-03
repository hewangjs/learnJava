package com.string.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.print.attribute.standard.RequestingUserName;

import org.apache.axiom.om.util.Base64;

import com.thoughtworks.xstream.core.util.Base64Encoder;

import junit.runner.BaseTestRunner;


public class StringUtils {
	
	/**
	 * 读取resource文件夹下的文件
	 * */
	public boolean readString(String fileName) throws IOException {
		InputStream inputStream = null;
		inputStream = StringUtils.class.getClassLoader().getResourceAsStream(fileName);//inputStream读的
		InputStreamReader isr = new InputStreamReader(inputStream);
		BufferedReader br = new BufferedReader(isr);
		/**
		 * 为什么上面的打印，下面的就打印不出来了
		 * 3的运行，会运行2, 2会运行1，此处的运行指的字节流或字符流的读取
		 * 2的运行会运行1
		 * 所以说1运行了，字节流读完了，2就没法读，同样3就没法读
		 */
//		int b = -1;
//		while((b = inputStream.read()) != -1){//1. 一个字节一个字节读取，字节流
//			System.out.print(b + " ");
//		}
		
//		int c = -1;
//		while((c = isr.read()) != -1){//2. 一个字符一个字符读取，字符流，处理流
//			System.out.print((char) c);
//		}
		
		String line = null;
		StringBuilder sb = new StringBuilder();
		while((line = br.readLine()) != null){//3. 一行一行读取，缓冲流
			sb.append(" ").append(line);
		}
		System.out.println(sb.toString());
		br.close();
		isr.close();
		inputStream.close();
		return true;
	}
	
	/**
	 * 判断字符串是否为空
	 */
	public boolean isEmpty(String value) {
		return null == value || "".equals(value.trim());
	}
	
	/**
	 * 将一个字符串str转换成BASE64的编码
	 * @param String str
	 * @throws UnsupportedEncodingException 
	 * */
	public String stringToBase64(String str) throws UnsupportedEncodingException{
		String str1 = null;
		byte[] base64Byte = null;
		Base64Encoder encoder = new Base64Encoder();
		str1 = encoder.encode(str.getBytes("UTF-8")); //字符串转BASE64编码
		System.out.println(str1);
		base64Byte = encoder.decode(str1); //解码得到原字符串的字节数组
		for (int i = 0; i < base64Byte.length; i++) {
			System.out.print(base64Byte[i] + " ");//字节数组
		}
		String str3 = new String(base64Byte);
		System.out.println(str3);//原始字符串
		return str3;
	}
	/**
	 * 填充字符串
	 * @throws UnsupportedEncodingException 
	 */
	public String fillStr(String string, char filler, int totalLength, boolean atEnd) throws UnsupportedEncodingException{
		byte[] tempbyte = string.getBytes("GBK");
		int currentLength = tempbyte.length;
		int delta = totalLength - currentLength;
		for(int i = 0; i < delta; i++){
			if(atEnd){
				string += filler;
			}else{
				string = filler + string;
			}
		}
		return string;
	}
	
	/**
	 * 字符串转Base64编码
	 */
	public boolean convertStrToBase64Byte(String str){
		byte[] a = str.getBytes(); // a是ASCII编码字节数组
		for (int i = 0; i < a.length; i++) {
			byte b = a[i];
			System.out.print(b + " ");
		}
		String base64EncodeStr = Base64.encode(a); //获得字符串str的Base64编码
		System.out.println(base64EncodeStr);
		byte[] b = Base64.decode(base64EncodeStr); //Base64编码解码  b是ASCII编码字节数组
		for (int i = 0; i < b.length; i++) {
			byte c = b[i];
			System.out.print(c + " ");
		}
		System.out.println(new String(b));
		return true;
	}
	
	/**
	 * 字符串转换成byte数组的长度
	 * @throws UnsupportedEncodingException 
	 */
	
	public boolean strToByte(String value) throws UnsupportedEncodingException {
		byte [] b1 = value.getBytes("UTF-8");
		byte [] b2 = value.getBytes("GBK");
		System.out.println(b1.length);
		for (int i = 0; i < b1.length;i++) {
			System.out.print(b1[i] + " ");
		}
		System.out.println("");
		System.out.println(b2.length);
		for (int i = 0; i < b2.length;i++) {
			System.out.print(b2[i] + " ");
		}
		return true;
	}
	
	/**
	 * 使用特定的字符分割字符串，并存入到List中去
	 */
	public boolean splitString(String str) {
		String [] cardList = str.split("\\|");
		for (int i = 0; i < cardList.length; i++) {
			System.out.println(cardList[i]);
		}
		return true;
	}
}
