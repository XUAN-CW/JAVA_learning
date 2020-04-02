package sendString;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 模拟登录 单向
 * 创建客户端
 * 1、建立连接: 使用Socket创建客户端 +服务的地址和端口
 * 2、操作: 输入输出流操作
 * 3、释放资源 
 * @author 裴新 QQ:3401997271
 *
 */
public class LoginClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("-----Client-----");
		//1、建立连接: 使用Socket创建客户端 +服务的地址和端口
		Socket client =new Socket("localhost",8888);
		//2、操作: 输入输出流操作
		DataOutputStream dos =new DataOutputStream(client.getOutputStream());
		dos.writeUTF("123");
		/**
	        * flush() 方法是清空,即清空缓冲区数据,就是说
	        * 你用读写流的时候,其实数据是先被读到了内存中,
	        * 然后用数据写到文件中,当你数据读完的时候不代表你的数据已经写完了,
	        * 因为还有一部分有可能留在内存这个缓冲区中.这时候如果你调用了
	        * close方法关闭了读写流,那么这部分数据就会丢失,
	        * 所以应该再关闭读写流之前先flush(),显得清空数据.
	        */
	       //刷新就是将内存(缓冲区)中的数据(是一个字节数组)强制写到磁盘/浏览器/控制台/文件
		dos.flush();
		//3、释放资源 
		dos.close();
		client.close();
	}

}
