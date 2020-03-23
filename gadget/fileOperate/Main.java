package fileOperate;

import java.io.File;

public class Main {
    public static void main(String[] args) {
		FileOperate fOperate=new FileOperate();
		File dir = new File("F:\\尚硅谷前端学科全套教程\\2.前端学科--核心&高级\\尚硅谷JavaScript教程\\源码、课件、笔记、工具\\源码\\day05\\day05");
		if (dir.exists()) {
			// 获取文件夹里所有文件
			File[] fileArr = dir.listFiles();
			for (File currFile : fileArr) {
				if (currFile.getName().contains(".\\html")) {
					fOperate.newDir(currFile.getAbsolutePath().toString().replaceAll("\\.html", ""));
				    fOperate.copyGeneralFile(currFile.getAbsolutePath().toString(),currFile.getAbsolutePath().toString().replaceAll("\\.html", ""));
				}
			}
		}
		
	}
}
