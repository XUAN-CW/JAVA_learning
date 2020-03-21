package batchRename;


public class Main {
	public static void main(String[] args) {
		MyBatchRename nbr=new MyBatchRename("E:\\web_learning\\HTML5\\");
//		nbr.addX(1);
		nbr.delete("ABCDEFGHIJK");
		nbr.startOperate();
		
	}
}
