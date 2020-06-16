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
        File mayuan = new File("C:\\Users\\86188\\Desktop\\马原\\马原.md");
        SaveAndRead saveAndRead=new SaveAndRead();
		String my=saveAndRead.read(mayuan.getAbsolutePath());
		my=my.replaceAll(" ","").
				replaceAll("　","").
				replaceAll("①"," ①").
				replaceAll("②"," ②").
				replaceAll("③"," ③").
				replaceAll("④"," ④").
				replaceAll("⑤"," ⑤");
//		System.out.println(my);

		Pattern pTitle = Pattern.compile("\\d{1,3}[.、．].+");
		//创建Matcher对象
		Matcher mTitle = pTitle.matcher(my);

		String nextTitle="";
		String currentTitle="";
		if (mTitle.find()){
			currentTitle=mTitle.group(0);
			while (mTitle.find()){
				nextTitle=mTitle.group(0);

		        int temp1=my.indexOf(currentTitle);
		        int temp2=my.indexOf(nextTitle);
		        String content=my.substring(temp1+currentTitle.length(),temp2);
		        content=content.
						replaceAll("A.","\nA.").
						replaceAll("B.","\nB.").
						replaceAll("C.","\nC.").
						replaceAll("D.","\nD.").
						replaceAll("\n\n\n","\n").
						replaceAll("\n\n","\n");

//				System.out.println(currentTitle+content);


				try{
					String[] ABCD=new String[4];
					Pattern p2 = Pattern.compile("[ABCD][.、． ].+");
					//创建Matcher对象
					Matcher m2 = p2.matcher(content);
					int temp=0;
					while (m2.find()){
							ABCD[temp++]=m2.group(0);
					}
					for (int i=currentTitle.length()-1;i>0;i--){
						char ans=currentTitle.charAt(i);
						if ('A'<=ans&&ans<='D'){
							System.out.println(currentTitle.replaceAll(" ","")
									+"\n"+ABCD[ans-'A'].replaceAll(" ","")+"\n");
							break;
						}
					}
				}catch (Exception e){
//					System.err.println(currentTitle+content);
				}
				currentTitle=nextTitle;
			}
		}
	}
}
