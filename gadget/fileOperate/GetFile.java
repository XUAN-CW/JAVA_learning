package fileOperate;

import java.io.File;
import java.util.Stack;

public class GetFile {
	private String root;// 传入的目录为根目录
	/**
	 * 为什么要用栈存储？ 
	 * 为了防止文件夹因重命名而找不到路径
	 */
	private Stack<File> folder = new Stack<File>();// 根目录下的所有文件夹
	private Stack<File> files = new Stack<File>(); // 根目录下的所有文件

	interface selecte {
		boolean selecteRule(File f);
	}

	private selecte sr = (File f) -> true;// 默认全选

	public GetFile(String dir) {
		setRoot(dir);// 在一开始就设置好根目录
	}

	/**
	 * 根据后缀选择
	 * 
	 * @param postfix
	 */
	public void selecteByPostfix(String postfix) {
		//文件名还没有输入的后缀长，直接返回 false
		//文件名比输入的后缀长，截取文件名最右边与后缀长度相同的子串，进行比较
		sr = (File f) -> f.getName().length() > postfix.length()
				? f.getName().substring(f.getName().length() - postfix.length(), f.getName().length()).equals(postfix)
				: false;
	}
	
	public void selecteNameEquals(String str) {
		 sr = (File f) -> f.getName().equals(str);
	}

	private void recursiveTraversalFolder(String currentDir) {
		// 获取当前文件夹下所有 文件/文件夹
		File temp = new File(currentDir);
		if (temp.exists()) {
			File[] fileArr = temp.listFiles();
			if (null == fileArr || fileArr.length == 0) {
//				System.out.println("["+temp.getAbsolutePath()+"]"+" 为空!");
				return;
			} else {
				// 在操作当前目录下所有 文件/文件夹
				for (File file : fileArr) {
					if (file.isDirectory()) {
						if (sr.selecteRule(file)) {
							folder.push(file);// 符合条件的文件夹入栈
						}
						recursiveTraversalFolder(file.getAbsolutePath());// 是文件夹，继续往下递归
					} else {
						if (sr.selecteRule(file)) {
							files.push(file);// 符合条件的文件入栈
						}
					}
				}
			}
		} else {
			System.out.println("文件不存在!");
		}
	}

	private void setRoot(String root) {

		this.root = root;
	}

	public Stack<File> getFolder() {
		while (!folder.empty()) {
			folder.pop();
		}
		recursiveTraversalFolder(root);// 递归遍历根目录下的所有文件，获取 文件/文件夹
		return folder;
	}

	public Stack<File> getFiles() {
		while (!files.empty()) {
			files.pop();
		}
		recursiveTraversalFolder(root);// 递归遍历根目录下的所有文件，获取 文件/文件夹
		return files;
	}

}
