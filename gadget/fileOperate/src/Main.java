import saveAndRead.SaveAndRead;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 经验：
 * * 对文件和文件夹命名不能使用以下9个字符：
 *   / \ : * " < >  ？
 *   否则会导致 File.mkdir() 失败
 */

public class Main {
	public static void main(String[] args) throws Exception {
		GetFile getFile = new GetFile(new File("G:\\多媒体课件"));

		String[] n= {"第01讲-eNSP网络环境的部署实践",
				"第02讲-以太网基础",
				"第03讲-交换机组网",
				"第04讲-交换机组网实践与分析",
				"第05讲-虚拟局域网",
				"第06讲-路由器组建的局域网",
				"第07讲-三层交换机组网",
				"第08讲-划分子网与构建超网",
				"第09讲-使用DHCP管理IP地址",
				"第10讲-无线局域网基础",
				"第11讲-通过防火墙实现网络安全管理"};
		for (File f : getFile.getFiles(getFile.selectByPostfix(""))) {

			for (String s:n){
//				System.out.print(s.contains(f.getName().substring(0,2))?s+f.getName().substring(2):"");
				if (s.contains(f.getName().substring(0,2))){
					Rename rename  = new Rename(f);
					rename.startRename(rename.replace(f.getName(),s+f.getName().substring(2)),true);
				}
			}
//			Rename rename  = new Rename(f);
//			rename.startRename(rename.addPrefix(f.getParentFile().getName()+" - "),true);
//			System.out.println(f.getName().substring(0,2));


		}
	}
}
