package myTalk4;
import java.net.InetAddress;
import java.net.InetSocketAddress;
/**
 * 封装端口 在InetADDress基础上加端口
 * @author SKH
 *
 */
public class InetSocketAddressDemo {
	public static void main(String[] args) {
		InetSocketAddress iSAddress=new InetSocketAddress("localhost",9999);
		System.out.println(iSAddress.getHostName());
        System.out.println(iSAddress.getPort());
        InetAddress addr=iSAddress.getAddress();//获得端口的ip；
        System.out.println(addr.getHostAddress());//返回ip；
        System.out.println(addr.getHostName());//输出端口名；
	}
}