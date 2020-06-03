import java.io.File;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws Exception {
		GetFile getFile=new GetFile(new File("./"));
		File dir=new File("百度云可用");
		dir.mkdir();
		FileOperate fileOperate = new  FileOperate();
		for (File file : getFile.getFiles(getFile.selectNameContains("[百度云可用]"))){
			fileOperate.copy(file,dir.getAbsolutePath());
		}
	}
}
