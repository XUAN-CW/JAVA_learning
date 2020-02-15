package other;
import java.net.InetAddress;
import java.net.InetSocketAddress;
/**
 * 封装端口 在InetADDress基础上加端口
 * @author SKH
 *
 */
public class InetSocketAddressDemo {
	public static void main(String[] args) {
		InetSocketAddress add=new InetSocketAddress("localhost",5555);
		System.out.println(add.getHostName());
        System.out.println(add.getPort());
        InetAddress addr=add.getAddress();//获得端口的ip；
        System.out.println(addr.getHostAddress());//返回ip；
        System.out.println(addr.getHostName());//输出端口名；
	}
}