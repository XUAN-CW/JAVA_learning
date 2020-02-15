package myTalk4;

/**
 * V4 - 跨主机传输
 */

import java.awt.FlowLayout; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JTextField; 
public class UdpTalkClient04 {
	public static void main(String[] args) {
		new MyFrame("客户端"); 
		} 
	}


class MyFrame extends JFrame implements ActionListener{ 
	JButton button=new JButton("点击我");
	JTextField text=new JTextField("点击发送测试数据             ");
	
	int count=0; 
	public MyFrame(String title) {
		setTitle(title); 
		setLayout(new FlowLayout()); 
		button.addActionListener(this);
		add(button);
		add(text); 
		setVisible(true); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,300,300,100);
		//pack();
	} 
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		
		String testData = "测试数据："+String.valueOf(count);
		 // 1、使用DatagramSocket  指定端口 创建发送端
		try {
			DatagramSocket client =new DatagramSocket(8888);
			//2、准备数据 一定转成字节数组
			//System.out.println("发送方启动中....."+count);
			
			byte[] datas = testData.getBytes();
			//3、 封装成DatagramPacket 包裹，需要指定目的地
//			10.34.16.173
//			10.34.2.175
//			127.0.0.1
			DatagramPacket packet =new DatagramPacket(datas,0,datas.length,new InetSocketAddress("127.0.0.1",6666));
			//4、发送包裹send​(DatagramPacket p) * 
			client.send(packet);
			// 5、释放资源
			client.close();
		} catch (SocketException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		text.setText(testData+"(已发送)"); 
		
		
		
	} 
}






