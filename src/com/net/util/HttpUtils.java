package com.net.util;

import java.io.IOException;

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
}
