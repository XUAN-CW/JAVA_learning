package fileOperate;

import java.io.File;

public class Main{
	public static void main(String[] args) {
		GetFile g = new GetFile("G:\\md\\");
		g.selecteNameEquals("");
		for (File f : g.getFiles()) {
			System.out.println(String.format("%-40s", f.getName())+f.getAbsolutePath());
			ContentEditor editor=new ContentEditor(f);
			editor.editMD();
			editor.edit();
		}
		
		
	}
}
