package batchRename;


public class Main {
	public static void main(String[] args) {
		BatchRename br=new BatchRename("C:\\Users\\86188\\Desktop\\源码");
//		br.addX(39);
		
		br.delete("ABCDEFGHIJK");
		br.startOperate();
	
//		for (int i = 11; i <= 18; i++) {
//			BatchRename br=new BatchRename("C:\\Users\\86188\\Desktop\\源码\\day"+i+"\\source\\day"+i);
////			br.addX(200+(i-10)*20);
//			br.delete("ABCDEFGHIJK");
//			br.startOperate();
//		}
		
		
	}
}
