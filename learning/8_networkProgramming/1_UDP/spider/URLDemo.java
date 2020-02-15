package spider;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * 网络爬虫的原理
 * 
 * @author 裴新 QQ:3401997271
 *
 */
public class URLDemo {

	public static void main(String[] args) throws Exception {
		//获取URL
		String GUET="http://172.16.64.236/student/public/login.asp";
		String jingdong="https://www.jd.com";
		URL url =new URL(GUET);
		//下载资源
		InputStream is = url.openStream();
		BufferedReader br =new BufferedReader(new InputStreamReader(is,"UTF-8"));
		String msg =null;
		while(null!=(msg=br.readLine())) {
			System.out.println(msg);
		}
		br.close();
	}

}
