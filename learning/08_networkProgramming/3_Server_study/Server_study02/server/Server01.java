package com.shsxt.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 目标: 使用ServerSocket建立与浏览器的连接，获取请求协议
 * 
 * @author 裴新 QQ:3401997271
 *
 */
public class Server01 {
	private ServerSocket serverSocket ;
	public static void main(String[] args) {
		Server01 server = new Server01();
		server.start();
	}
	//启动服务
	public void start() {
		try {
			serverSocket =  new ServerSocket(8888);
			 receive();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("服务器启动失败....");
		}
	}
	//接受连接处理
	public void receive() {
		try {
			/**
			 * GET
			 * ①打开浏览器，输入网址 http://localhost:8888/ 然后运行
			 * ②打开浏览器，输入网址 localhost:8888/login.html123456789 然后运行
			 * 对比上述两种情况（看第二行）
			 */
			
			/**
			 * POST
			 * ①打开准备好的 HTML 文件，输入用户名密码后点击登录，然后运行
			 * ②使用RESTer插件：
			 	- 使用 POST 方法
			 	- URL设为 http://localhost:8888/AnyCharacter
			 	- 在 BODY 写上内容
			 	- 点击右上角的 DEND 
			 	- 运行程序
			 * 看第二行、最后一行
			 */
			Socket client = serverSocket.accept();
			System.out.println("一个客户端建立了连接....");
			//获取请求协议
			InputStream is =client.getInputStream();
			byte[] datas = new byte[1024*1024];
			int len = is.read(datas);
			String requestInfo = new String(datas,0,len);
			System.out.println(requestInfo);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("客户端错误");
		}
	}
	//停止服务
	public void stop() {
		
	}
}
