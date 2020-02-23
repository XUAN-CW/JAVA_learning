package txtInputSimulator06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import sun.util.logging.resources.logging;

public class Channel implements Runnable, DataTransmission{
	//һ���ͻ�����һ��Channel
	private DataInputStream dis;
	private DataOutputStream dos;
	private Socket  client;			
	private String[] requestContent;
				
	public Channel(Socket  client) {
		this.client = client;
		try {
			dis = new DataInputStream(client.getInputStream());
			dos =new DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			System.out.println("---1------");
			release();					
		}			
	}
				
	public void send(String content){
		try {
			dos.writeUTF(content);
			dos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String receive() {
		String result="";
		try {
			result = dis.readUTF();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}			
	//�ͷ���Դ
	private void release() {
		//�˳�
		try {
			dis.close();
			dos.close();
			client.close();
			dis=null;
			dos=null;
			client=null;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	private void respond() {
		if (requestContent[0].equals(createAccount)) {
			createAccount(requestContent[1],requestContent[2]);
		}
		if (requestContent[0].equals(loggingFlag)) {
			logging(requestContent[1],requestContent[2]);
		}
		if (requestContent[0].equals(uploadFlag)) {
			download(requestContent[1]);
		}
		if (requestContent[0].equals(downloadFlag)) {
			this.upload(requestContent[1]);
		}
	}
	
				
	@Override
	public void run() {
		requestContent=receive().split(divider);
		System.out.print("�յ��ˣ�");
		for (int i = 0; i < requestContent.length; i++) {
			System.out.print(requestContent[i]+"  ");
			
		}
		respond();
	}
	
	public String[] findByAccount(String account) {
		
		//����
		StringBuffer outcome=null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/txtInputSimulator","root","XUAN1998");
			String sql = "SELECT * FROM txtInputSimulator"; 
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()){
				if (rs.getString(2).equals(account)) {//�ҵ���
					outcome=new StringBuffer("");
					java.sql.ResultSetMetaData rsmd =  rs.getMetaData();
					for (int i = 1; i <= rsmd.getColumnCount(); i++) {
						if (rs.getString(i)==null) {
							outcome.append(filler);
						}
						else {
							outcome.append(rs.getString(i));
						}
						outcome.append(divider);
					}
//					System.out.println(outcome+"11111");
					break;
				}
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
			//��ѭ��resultset-->statment-->connection�����Ĺر�˳��һ��Ҫ������trycatch�飬�ֿ�д��
			//��ѭ��resultset-->statment-->connection�����Ĺر�˳��һ��Ҫ������trycatch�飬�ֿ�д��
			//��ѭ��resultset-->statment-->connection�����Ĺر�˳��һ��Ҫ������trycatch�飬�ֿ�д��
			try {
				if(rs!=null){
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(ps!=null){
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return outcome==null?null:outcome.toString().split(divider);
	}

	@Override
	public boolean isAccountExists(String account) {
		return findByAccount(account)==null?false:true;
		
	}
			
	public String createAccount(String account, String password) {
		if (isAccountExists(account)) {
			send(createFailed);
		} else {
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				//����������
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/txtInputSimulator","root","XUAN1998");
				
				String sql = "insert into txtInputSimulator (account,pwd) values (?,?)";  //?ռλ��
				ps = conn.prepareStatement(sql);
				ps.setObject(1, account);
				ps.setObject(2, password);
				System.out.println("����һ�м�¼");
				int count = ps.executeUpdate();
				System.out.println(count);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					if(ps!=null){
						ps.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					if(conn!=null){
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			send(createSuccessfully);
		}
		return "������㷵��һ�㶫��";
	}
	
	@Override
	public String logging(String account,String password) {
		//����
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String outcome=accountDoesNotExist;
		
		try {
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/txtInputSimulator","root","XUAN1998");
			String sql = "select account,pwd from txtInputSimulator"; 
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString(1));
				if (rs.getString(1).equals(account)) {
					outcome=wrongPassword;
					if (rs.getString(2).equals(password)) {
						outcome=loginSuccessfully;
					}
					break;
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
			//��ѭ��resultset-->statment-->connection�����Ĺر�˳��һ��Ҫ������trycatch�飬�ֿ�д��
			//��ѭ��resultset-->statment-->connection�����Ĺر�˳��һ��Ҫ������trycatch�飬�ֿ�д��
			//��ѭ��resultset-->statment-->connection�����Ĺر�˳��һ��Ҫ������trycatch�飬�ֿ�д��
			try {
				if(rs!=null){
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(ps!=null){
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("����"+outcome);
		send(outcome);
		return "������㷵��һ�㶫��";
	}

	@Override
	public String upload(String account) {
		String txt=findByAccount(account)[3];
		if (txt.equals(filler)) {
			txt=filler+txtDivider+filler+txtDivider+filler+txtDivider+filler+txtDivider;
		}
		send(txt);
		return "������㷵��һ�㶫��";
	}

	@Override
	public String download(String account) {
//		System.err.println(requestContent[2]);
//		String sql="UPDATE dept SET txt='"+requestContent[2]+"' WHERE account="+account;
		//��������
		System.err.println(requestContent[2]);
		
		
		return null;
	}


}
