package batchRename;

import java.io.File;
import java.util.Scanner;


/**
 * 警告：谨慎使用！程序一旦运行，便不可撤回！注意路径的填写！
 * 遇到的问题：转义问题 <=> 解决方法：在字符前加 【\\】
 * 描述：批量重命名文件 
 * 来源：https://www.cnblogs.com/CodeKjm/p/9615815.html
 */

public class MyBatchRename{
	interface rename {
		String renameRule(String oldName);
	}

	private String dir;// 此程序会递归遍历此目录下所有文件,记得修改为你电脑上的文件所在路径
	private rename r = (String oldName) -> null;
	private boolean canRename = false; // 为预览效果而设计

	public MyBatchRename(String path) {
		setDir(path);
	}

	public void delete(String Deleted) {
		this.r = (String oldName) -> {
			return oldName.replaceAll(Deleted, "");// 新名字
		};
	}

	public void replace(String regex, String replacement) {
		this.r = (String oldName) -> {
			return oldName.replaceAll(regex, replacement);// 新名字
		};
	}

	/**
	 * 加前缀
	 */
	public void addPrefix(String prefix) {
		this.r = (String oldName) -> {
			return prefix + oldName;// 新名字
		};
	}
	
	/**
	 * 加后缀
	 */
	public void addPostfix (String postfix) {
		this.r = (String oldName) -> {
			return oldName+postfix;// 新名字
		};
	}
	
	/**
	 * 删除文件名的前 x 个字符，若文件名长度小于 x ，则保留原文件名
	 */
	public void DeleteCharacters(int x) {
		this.r = (String oldName) -> {
			return oldName.length()>x?oldName.substring(x):oldName;// 新名字
		};
	}

	public void bringTheStringForward(String str) {
		this.r = (String oldName) -> {
			StringBuffer newName = new StringBuffer("");
			String temp[] = oldName.split(str);
			if (oldName.contains(str)) {
				newName.append(str);
				for (int i = 0; i < temp.length; i++) {
					newName.append(temp[i]);
				}
				return newName.toString();// 新名字
			} else {
				return oldName;
			}
		};
	}
	
	/**
	 * 以数字为名的文件重命名后该数字加上 x 
	 * 例如 【1.txt】,x 为 2 ，则重命名后 【3.txt】
	 */
	public void addX(int x) {
		this.r = (String oldName) -> {
			String s[]=oldName.split("\\.");
			try {
				oldName=String.valueOf(Integer.valueOf(s[0])+x)+"."+s[1];
			} catch (Exception e) {
				System.out.println("文件名不是数字或文件无后缀，"+oldName+" 不能重命名");
			}
			return oldName;
		};
	}
	
	

	private String getNewName(File renamedFile) {
		return this.r.renameRule(renamedFile.getName());
	}

	/**
	 * 递归遍历文件夹获取文件
	 */
	private void recursiveTraversalFolder(String currentDir) {
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
						recursiveTraversalFolder(file.getAbsolutePath());
					} else {// 是文件，则重命名
						// 新文件 = 文件所在文件夹路径 + 新文件名
						File newFile = new File(file.getParentFile() + "/" + getNewName(file));
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

	public void startOperate() {
		System.out.println("----------预览----------");
		recursiveTraversalFolder(dir);
		System.out.println("确认此操作？程序一旦运行，便不可撤回!    y/n");
		Scanner input = new Scanner(System.in);
		if (input.nextLine().equals("y") || input.nextLine().equals("Y")) {
			this.canRename = true;
			System.out.println("----------执行----------");
			recursiveTraversalFolder(dir);
		}
	}

	public String getDir() {
		return dir;
	}

	private void setDir(String dir) {
		this.dir = dir;
	}

}
