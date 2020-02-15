package txtInputSimulator06;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import com.sun.nio.sctp.SendFailedNotification;

public class Client implements DataTransmission{
	private Socket client=null;
	private DataOutputStream dos=null;
	private DataInputStream dis=null;
	private String account="";
	private String password="";
	private String uploadtxt=null;
	


	public Client(){
		super();
	}
	
	public boolean connection () {
		boolean isConnection=true;
		try {
			client=new Socket("localhost",8888);
			dos=new DataOutputStream(client.getOutputStream());
			dis=new DataInputStream(client.getInputStream());
		} 
		catch (Exception e) {
			isConnection=false;
		}
		return isConnection;
	}
	
	//释放资源
	public void release() {
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
	
	public void saveAccountAndPassword() {
		SaveAndRead saveAndRead=new SaveAndRead();
		System.err.println(account+divider+password);
		saveAndRead.save("accountAndPassword.txt", account+divider+password);
	}
	
	public void readAccountAndPassword() {
		SaveAndRead saveAndRead=new SaveAndRead();
		String temp=saveAndRead.read("accountAndPassword.txt");
		String[] ap=temp.split(divider);
		System.out.println(temp);
		if (ap.length<2) {//文件不存在或文件为空
			account="";
			password="";
		}
		else {
			account=ap[0];
			password=ap[1];
		}
		
		System.out.println(account+password);
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
	
	
	
	
	

	@Override
	public boolean isAccountExists(String account) {
		return false;
	}

	@Override
	public String createAccount(String account, String password) {
		if (connection()) {
			send(createAccount+divider+account+divider+password);
			String outcome=receive();
			release();
			return outcome;
		}
		else {
			return connectionFail;
		}
		
	}
	
	@Override
	public String logging(String account,String password) {
		if (connection()) {
			send(loggingFlag+divider+account+divider+password);
			String outcome=receive();
			if (outcome.equals(loginSuccessfully)) {
				this.account=account;
				this.password=password;
			}
			release();
			return outcome;
		}
		else {
			return connectionFail;
		}
	}
	
	@Override
	public String upload(String account) {
		if (connection()) {
			send(uploadFlag+divider+account+divider+uploadtxt);
			release();
			return "已上传";
		} else {
			return connectionFail;
		}
	}

	@Override
	public String download(String account) {
		if (connection()) {
			send(downloadFlag+divider+account);
			String outcome=receive();
			release();
			return outcome;
		} else {
			return connectionFail;
		}
	}
	
	
	
	
	
	
	

	public Socket getClient() {
		return client;
	}

	public void setClient(Socket client) {
		this.client = client;
	}

	public DataOutputStream getDos() {
		return dos;
	}

	public void setDos(DataOutputStream dos) {
		this.dos = dos;
	}

	public DataInputStream getDis() {
		return dis;
	}

	public void setDis(DataInputStream dis) {
		this.dis = dis;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUploadtxt() {
		return uploadtxt;
	}

	public void setUploadtxt(String uploadtxt) {
		this.uploadtxt = uploadtxt;
	}

	

	
	
	
	
}
