package batchRename_polymorphism;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * 警告：谨慎使用！程序一旦运行，便不可撤回！注意路径的填写！
 * 遇到的问题：转义问题 <=> 解决方法：在字符前加 【\\】
 * 描述：批量重命名文件 
 * 来源：https://www.cnblogs.com/CodeKjm/p/9615815.html
 */

public class BatchRename_polymorphism{

	private String dir;// 此程序会递归遍历此目录下所有文件,记得修改为你电脑上的文件所在路径
	private boolean canRename = false; // 为预览效果而设计
	
	public BatchRename_polymorphism(String path) {
		setDir(path);
	}

	/**
	 * 递归遍历文件夹获取文件
	 */
	private void recursiveTraversalFolder(String currentDir,RenameRule r) {
		File folder = new File(currentDir);
		if (folder.exists()) {
			// 获取文件夹里所有文件
			File[] fileArr = folder.listFiles();
			if (null == fileArr || fileArr.length == 0) {
				System.out.println("文件夹是空的!");
				return;
			} else {
				for (File file : fileArr) {
					if (file.isDirectory()) {// 是文件夹，继续递归，如果需要重命名文件夹，这里可以做处理
						System.out.println("文件夹:" + file.getAbsolutePath() + "，继续递归！");
						recursiveTraversalFolder(file.getAbsolutePath(),r);
					} else {// 是文件，则重命名
						// 新文件 = 文件所在文件夹路径 + 新文件名
						File newFile = new File(file.getParentFile() + "/" + r.getNewName(file.getName()));
						if (canRename) {//这里为预览功能而设计
							file.renameTo(newFile);// 重命名
						}
						System.out.print(newFile.getName().equals(file.getName()) ? "" : "重命名后：" + newFile.getName() + "\n");
					}
				}
			}
		} else {
			System.out.println("文件不存在!");
		}
	}

	public void startOperate(RenameRule r) {
		System.out.println("----------预览----------");
		recursiveTraversalFolder(dir,r);
		System.out.println("确认此操作？程序一旦运行，便不可撤回!    y/n");
		Scanner input = new Scanner(System.in);
		String choise = input.next();
		input.close();
		if (choise.equals("y") || choise.equals("Y")) {
			this.canRename = true;
			System.out.println("----------执行----------");
			recursiveTraversalFolder(dir,r);
		}
		else {
			System.out.println("操作取消");
		}
		
	}

	private void setDir(String dir) {
		this.dir = dir;
	}

}
