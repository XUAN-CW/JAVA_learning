import java.io.File;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws Exception {
		GetFile getFile=new GetFile(new File("C:\\Users\\86188\\Desktop\\新建文件夹 (2)"));
		FileOperate fileOperate = new  FileOperate();
		for (File file : getFile.getFiles(getFile.selectNameContains("[百度云可用]"))){
			System.out.println(file.getName());
			fileOperate.copy(file.getAbsolutePath(),"C:\\Users\\86188\\Desktop\\新建文件夹 (2)\\新建文件夹");
		}
	}
}
