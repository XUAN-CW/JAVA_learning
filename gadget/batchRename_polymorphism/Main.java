package batchRename_polymorphism;


public class Main {
	public static void main(String[] args) {
//		BatchRename_polymorphism br=new BatchRename_polymorphism("G:\\新建文件夹-01\\");
//		br.addX(-1);
//		br.delete("ABCDEFGHIJK");
//		br.startOperate(new AddX(3));
		
		new BatchRename_polymorphism("G:\\新建文件夹-01\\").startOperate(new AddX(2));
	}
}
