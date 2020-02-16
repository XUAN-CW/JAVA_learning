package batchRename;


public class Main {
	public static void main(String[] args) {
		MyBatchRename nbr=new MyBatchRename("G:\\新建文件夹");
//		nbr.addX(33);
		nbr.delete("本");
		nbr.startOperate();
		
	}
}
