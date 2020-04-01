package fileOperate;

import java.io.File;

public class Main {
	public static void main(String[] args) {
		for (int i = 10; i <= 18; i++) {
			FileOperate fOperate = new FileOperate();
			File dir = new File("C:\\Users\\86188\\Desktop\\源码\\day"+i+"\\source\\day"+i);
			if (dir.exists()) {
				// 获取文件夹里所有文件
				File[] fileArr = dir.listFiles();
				for (File currFile : fileArr) {
					if (currFile.getName().contains("html")) {
						fOperate.newDir(currFile.getAbsolutePath().toString().replaceAll("\\.html", ""));
						fOperate.copyGeneralFile(currFile.getAbsolutePath().toString(),
								currFile.getAbsolutePath().toString().replaceAll("\\.html", ""));
					}
				}
			}
		}

	}
}
