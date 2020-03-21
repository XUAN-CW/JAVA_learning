package batchRename_polymorphism;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 以数字为名的文件重命名后该数字加上 x 
 * 例如 【1.txt】,x 为 2 ，则重命名后 【3.txt】
 */
public class AddX implements RenameRule{
	int x;
	public AddX(int x) {
		setX(x);
	}
	
	@Override
	public String getNewName(String oldName) {
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
	}


	private void setX(int x) {
		this.x = x;
	}

	
}
