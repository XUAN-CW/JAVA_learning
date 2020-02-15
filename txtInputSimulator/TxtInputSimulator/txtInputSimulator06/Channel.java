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
	//一个客户代表一个Channel
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
	//释放资源
	private void release() {
		//退出
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
		System.out.print("收到了：");
		for (int i = 0; i < requestContent.length; i++) {
			System.out.print(requestContent[i]+"  ");
			
		}
		respond();
	}
	
	public String[] findByAccount(String account) {
		
		//查找
		StringBuffer outcome=null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/txtInputSimulator","root","XUAN1998");
			String sql = "SELECT * FROM txtInputSimulator"; 
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()){
				if (rs.getString(2).equals(account)) {//找到了
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
			
			//遵循：resultset-->statment-->connection这样的关闭顺序！一定要将三个trycatch块，分开写！
			//遵循：resultset-->statment-->connection这样的关闭顺序！一定要将三个trycatch块，分开写！
			//遵循：resultset-->statment-->connection这样的关闭顺序！一定要将三个trycatch块，分开写！
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
				//加载驱动类
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/txtInputSimulator","root","XUAN1998");
				
				String sql = "insert into txtInputSimulator (account,pwd) values (?,?)";  //?占位符
				ps = conn.prepareStatement(sql);
				ps.setObject(1, account);
				ps.setObject(2, password);
				System.out.println("插入一行记录");
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
		return "这里随便返回一点东西";
	}
	
	@Override
	public String logging(String account,String password) {
		//查找
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String outcome=accountDoesNotExist;
		
		try {
			//加载驱动类
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
			
			//遵循：resultset-->statment-->connection这样的关闭顺序！一定要将三个trycatch块，分开写！
			//遵循：resultset-->statment-->connection这样的关闭顺序！一定要将三个trycatch块，分开写！
			//遵循：resultset-->statment-->connection这样的关闭顺序！一定要将三个trycatch块，分开写！
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
		System.out.println("发送"+outcome);
		send(outcome);
		return "这里随便返回一点东西";
	}

	@Override
	public String upload(String account) {
		String txt=findByAccount(account)[3];
		if (txt.equals(filler)) {
			txt=filler+txtDivider+filler+txtDivider+filler+txtDivider+filler+txtDivider;
		}
		send(txt);
		return "这里随便返回一点东西";
	}

	@Override
	public String download(String account) {
//		System.err.println(requestContent[2]);
//		String sql="UPDATE dept SET txt='"+requestContent[2]+"' WHERE account="+account;
		//更新内容
		System.err.println(requestContent[2]);
		
		
		return null;
	}


}
