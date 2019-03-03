package com.net.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;

import org.hamcrest.core.Is;

public class SocketUtils {
	
	/**
	 *获取本机IP及Port
	 */
	public boolean getLocalIntAddress() throws IOException{
		InetAddress address = InetAddress.getLocalHost();
		String hostName = address.getHostName();
		String hostAddress = address.getHostAddress();
		//byte类型是有符号的整数，取值范围是[-128,127]，所以ip地址内部大于127的都会被打印成负值。
		byte[] addrs = address.getAddress();//获取字节数组形式的IP地址，以点分割的四部分
		System.out.println("计算机名" + hostName);
		System.out.println("IP地址" + hostAddress);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < addrs.length; i++) {
			//最高位是符号位，有符号数，从小扩展大时，需要用&0xff这样方式来确保是按补零扩展。
			int b = addrs[i]&0xff;//有符号byte转无符号int
			sb.append(b).append(" ");
		}
		System.out.println(sb.toString());
		return true;
	}
	
	/**
	 * 获取URL的信息
	 */
	public boolean getURLInfo() throws IOException{
		URL baidu = new URL("http://www.baidu.com");
		URL url = new URL(baidu, "/index.html?username=tom#test");
		String protocol = url.getProtocol();//获取协议
		String host = url.getHost();//获取主机
		int port = url.getPort();//如果没有指定端口号，根据协议不同使用默认的端口号。此时getPort()的返回值为-1
		String path = url.getPath();//获取文件路径
		String file = url.getFile();//文件名，包含文件路径+参数
		String ref = url.getRef();//相对路径，就是锚点，即#后面的内容
		String query = url.getQuery();//查询字符串，即参数
		System.out.print(protocol +" " + host +" " + port +" " + path +" " + file +" " + ref +" " + query);
		return true;
	}
	
	/**
	 * 使用URL读取网页内容
	 */
	public boolean getWebPageContent() throws IOException{
		URL url = new URL("http://www.baidu.com");
		InputStream inputStream = url.openStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
		String data = null;
		while((data = br.readLine())!=null){
			System.out.println(data);
		}
		return true;
	}
	
	/**
	 * 基于TCP协议的Scoket通信，服务端
	 * @throws IOException 
	 */
	public boolean createServerSocket() throws IOException{
		ServerSocket serverSocket = new ServerSocket(10086);////1024-65535的某个端口
		Socket socket = serverSocket.accept();
		InputStream inputStream = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
		String info = null;
		while((info = br.readLine()) != null){
			System.out.println("我是服务器，客户端说" + info);
		}
		socket.shutdownInput();
		OutputStream outputStream = socket.getOutputStream();
			PrintWriter pw =new PrintWriter(outputStream);
			pw.write("欢迎您！");
			pw.flush();
			pw.close();
			outputStream.close();
			br.close();
			socket.close();
			serverSocket.close();
		return true;
	}
	
	/**
	 * 基于TCP协议的Socket协议，客户端
	 * @throws IOException 
	 * @throws  
	 */
	public boolean createClientSocket() throws IOException{
		Socket socket = new Socket("localhost", 10086);
		OutputStream outputStream = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(outputStream);
		pw.write("我是客户端json");
		pw.flush();
		socket.shutdownOutput();
		InputStream inputStream = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
		String info = "";
		while((info = br.readLine()) != null){
			System.out.println("我是客户端，服务端说" + info);
		}
		br.close();
		inputStream.close();
		outputStream.close();
		socket.close();
		return true;
	}
}
