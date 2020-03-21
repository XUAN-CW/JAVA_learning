package batchRename;

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

public class BatchRename{
	interface rename {
		String renameRule(String oldName);
	}

	private String dir;// 此程序会递归遍历此目录下所有文件,记得修改为你电脑上的文件所在路径
	private rename r = (String oldName) -> null;
	private boolean canRename = false; // 为预览效果而设计

	public BatchRename(String path) {
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

	/**
	 * 将文件名中的某字符串提到前面
	 */
	public void bringTheStringForward(String str) {
		this.r = (String oldName) -> {
			return str + oldName.replaceFirst(str, "");
		};
	}
	
	/**
	 * 以数字为名的文件重命名后该数字加上 x 
	 * 例如 【1.txt】,x 为 2 ，则重命名后 【3.txt】
	 */
	public void addX(int x) {
		this.r = (String oldName) -> {
			String newName=oldName;
			Pattern p = Pattern.compile("\\d+");
			//创建Matcher对象
			Matcher m = p.matcher(oldName);
			if (m.find()) {//找到了数字
				/**
				 * 重命名的时候可能遇到这么一种情况：
				 * 【1.txt】重命名为 【3.txt】，原先又存在  【3.txt】，
				 * 这种情况下重命名会失败，所以我给新文件名加上 ABCDEFGHIJK （应该没有哪个文件包含有这个字符串吧）
				 * 之后删除 ABCDEFGHIJK 即可
				 */
				newName="ABCDEFGHIJK"+oldName.replaceFirst(m.group(0), String.valueOf(Integer.valueOf(m.group(0))+x));
			}
			return newName;
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
		else {
			System.out.println("操作取消");
		}
		input.close();
	}

	public String getDir() {
		return dir;
	}

	private void setDir(String dir) {
		this.dir = dir;
	}

}
