package other;
import java.net.InetAddress;
import java.net.UnknownHostException;
public class InetAddressDemo {
	public static void main(String[] args) throws UnknownHostException {
		
		// 使用getLocalHost方法为InetAddress创建对象；
		InetAddress address=InetAddress.getLocalHost();//获得本机的InetAddress对象
		System.out.println("本机IP地址："+address.getHostAddress());//返回本机IP地址
		System.out.println(address.getHostName());//输出计算机名
		
		//根据域名得到InetAddress对象
        address=InetAddress.getByName("www.baidu.com");
        System.out.println(address.getHostAddress());//返回百度服务器的IP地址
		System.out.println(address.getHostName());//输出www.baidu.com；
		
		//根据ip得到InetAddress对象；
		address=InetAddress.getByName("111.13.100.91");
		System.out.println(address.getHostAddress());
		System.out.println(address.getHostName());//如果ip地址存在，并且DNS给你解析就会输出
		//www.baidu.com，不给你解析就会返回这个IP本身；
	}
}