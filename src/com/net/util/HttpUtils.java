package com.net.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

@SuppressWarnings("deprecation")
public class HttpUtils {
	public boolean returnHttpContent(){
		@SuppressWarnings("resource")
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet("http://m.weather.com.cn/data/101010100.html");
		try {
			HttpResponse httpResponse = httpClient.execute(httpget);
			HttpEntity entity = httpResponse.getEntity();
			System.out.println(EntityUtils.toString(entity));
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			httpClient.getConnectionManager().shutdown();
		}
		return true;
	}
	
	public boolean accountManage(){
		String address = "http://192.168.120.47:8086/WEB-CCAM/cxf/rest/ccam/findAssess";
	    OutputStreamWriter out = null;
	    BufferedReader reader = null;
	    String response="";
	    try {
	    	URL httpUrl = null;
			httpUrl = new URL(address);
			HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("connection", "keep-alive");
			conn.setUseCaches(false);//设置不要缓存
			conn.setInstanceFollowRedirects(true);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.connect();
			// Post请求
			out = new OutputStreamWriter(conn.getOutputStream());
			// 调额Demo
			StringBuffer sb = new StringBuffer("{\"list\":[");
			sb.append("{\"key\":\"bankid\",\"value\":\"6586\"},");
			sb.append("{\"key\":\"num\",\"value\":\"1\"},");
			sb.append("{\"key\":\"custnum\",\"value\":\"650101198604183434\"},");
			sb.append("{\"key\":\"limit_request_bef_days\",\"value\":\"30\"},");
			sb.append("{\"key\":\"templimit_request_bef_days\",\"value\":\"30\"},");
			sb.append("{\"key\":\"limit_adjust_bef_days\",\"value\":\"30\"},");
			sb.append("{\"key\":\"templimit_adjust_bef_days\",\"value\":\"30\"},");
			sb.append("{\"key\":\"flag\",\"value\":\"2\"},");
			sb.append("{\"key\":\"adjustType\",\"value\":\"2\"},");
			sb.append("{\"key\":\"AdjustReason\",\"value\":\"3\"},");
			sb.append("{\"key\":\"channel\",\"value\":\"AQ\"}");
			sb.append("]}");
			// 查询调额状态Demo
			StringBuffer sb2 = new StringBuffer("{\"list\":[");
			sb2.append("{\"key\":\"num\",\"value\":\"6\"},");
			sb2.append("{\"key\":\"bankid\",\"value\":\"6586\"},");
			sb2.append("{\"key\":\"card\",\"value\":\"6228091800002729\"},");
			sb2.append("{\"key\":\"adjustType\",\"value\":\"2\"},");
			sb2.append("{\"key\":\"channel\",\"value\":\"AQ\"}");
			sb.append("]}");
			out.write(sb.toString());
			out.flush(); 
			//读取响应
			reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			String lines;
			while ((lines = reader.readLine()) != null) {
				lines = new String(lines.getBytes(), "utf-8");
				response+=lines;
			}
			reader.close();
			// 断开连接
			conn.disconnect();
			System.out.println(response);
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！"+e);
			e.printStackTrace();
		}		
	    //使用finally块来关闭输出流、输入流
		finally{
			try{
				if(out!=null){
					out.close();
				}
				if(reader!=null){
					reader.close();
				}
			}
			catch(IOException ex){
				ex.printStackTrace();
			}
		}
		return true;
	}
}
