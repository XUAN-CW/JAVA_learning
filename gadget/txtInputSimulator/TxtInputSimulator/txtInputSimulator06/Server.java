package txtInputSimulator06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 *
 */
public class Server {
	public static void main(String[] args) throws IOException {
		System.out.println("-----Server-----");
		// 1��ָ���˿� ʹ��ServerSocket����������
		ServerSocket server =new ServerSocket(8888);
		// 2������ʽ�ȴ����� accept
		while(true) {
				Socket  client =server.accept(); 
				System.out.println("һ���ͻ��˽���������");
				Channel c =new Channel(client);
				new Thread(c).start();	
			}
		}
		
	
		
}
