package fileOperate;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;

import javax.sound.midi.Patch;

//import com.sun.tools.javac.util.List;

import fileOperate.Rename.RenameRule;

public class Main {
	
	
	public static void main(String[] args) throws IOException, InterruptedException {

		GetFile g = new GetFile("G:\\新建文件夹 (2)\\");
//		g.selecteByPostfix("mp4", "rmvb", "wmv", "avi", "mkv","bc!");
////		g.selecteByPostfix();
//
//		ArrayList<String> list = new ArrayList<String>();
//		
//		String division="   ";
//		
		for (File file : g.getFiles()) {
			Rename rename= new Rename(file);
			rename.startRename(rename.replace("11", "01"), true);
////			System.out.println(file.getName());
//			Rename rename=new Rename(file);
//			System.out.println(rename.removeCharAndContentInIt('[',']').rename(file.getName()));
////			File file2=new File("G:\\新建文件夹-01\\"+rename.removeCharAndContentInIt('[',']').rename(file.getName()));
////			file2.createNewFile();
//			
//			list.add(rename.removeCharAndContentInIt('[',']').rename(file.getName()).trim()+division+file.getAbsolutePath());
		}
//		
//        Collections.sort(list);//对list集合进行排序
//        
//        String last=list.get(0);
//        for (String current : list) {
//        	if (current.contains(".bc!")) {
////        		Thread.sleep(100);
//				String undone=current.substring(0,current.indexOf(division));
//				String lastFileName = last.substring(0, last.indexOf(division));
//				if (undone.equals(lastFileName+".bc!")) {
//					String cpath=current.split(division)[1];
//					String lpath=last.split(division)[1];
//					File bcFile=new File(cpath);
//					System.out.println(bcFile.getAbsolutePath()+"\n"+lpath+"\n");
//					
////					bcFile.delete();
//				}
//        	}
//			last=current;
//		}
		
//		ContentEditor contentEditor = new ContentEditor(new File("C:\\Users\\86188\\Desktop\\edit.txt"));
//		contentEditor.startEdit(
//				(String content)->{
//					String newContent=content.replaceAll("keywordstyle", "");
//					newContent=newContent.replaceAll("\\n\\d+", "\n");
//					newContent=newContent.substring(0, newContent.length()-1);
//					System.out.println(newContent);
//					return content;
//				}
//		);
		
		
		
		
		
		
		
		
		
		
		
		
        
	}
}
