package batchRename;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) {
//		MyBatchRename nbr=new MyBatchRename("E:\\core\\code\\python\\�½��ļ���\\mypro_obj\\");
//		nbr.addX(33);
//		nbr.delete("-oo");
//		nbr.startOperate();
		
		String num="545sdff46sfds�÷�df";
        char[] nu=num.toCharArray();
        //����һ���ַ�
        String nownum="";
        for (int i = 0; i < nu.length; i++) {
            if(Integer.valueOf(nu[i])>=48&&Integer.valueOf(nu[i])<=57)
            nownum=nownum+nu[i];
        }
		System.out.println(nownum);
	}
}
