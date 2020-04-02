package myTalk3;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpTalkServer03 {

    public static void main(String[] args) throws AWTException, IOException {
        JFrame jf = new JFrame("服务器");
        jf.setSize(300, 100);
        jf.setLocationRelativeTo(null);	//设置窗体的相对位置。null,代表没有相对的其他窗体
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();		//创建面板容器
        
        JTextField text=new JTextField("未收到测试数据             ");
        panel.add(text);
       
        jf.setContentPane(panel);
        jf.setVisible(true);
        jf.setLayout(null);
       
             // 1、使用DatagramSocket  指定端口 创建接收端
     	DatagramSocket server =new DatagramSocket(6666); 
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			// 2、准备容器 封装成DatagramPacket 包裹
			byte[] container =new byte[1024*60];
			DatagramPacket packet = new DatagramPacket(container,0,container.length);
			// 3、阻塞式接收包裹receive​(DatagramPacket p)
			server.receive(packet); //阻塞式
			// 4、分析数据
			//    byte[]  getData​()
			//                getLength​()
			 byte[]  datas =packet.getData();
			 int len = packet.getLength();
			 String data=new String(datas,0,len);
			 System.out.println(data);
			 text.setText(data+"(已收到)");
		}
		// 5、释放资源
		 server.close();
    }

}