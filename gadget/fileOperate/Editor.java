package fileOperate;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 对某个文本文件进行编辑
 * 
 * @author 86188
 *
 */

public class ContentEditor {

	File file;
	
	interface e {
		String edit(String content);
	}
	e ed = (String str) -> str;//默认不该

	public ContentEditor(File editedFile) {
		setFile(editedFile);
		
	}
	
	public void editMD() {
		
		ed = (String content) -> {
			String head = "---\r\n" + 
					"title: "
					+ file.getName()
					+ "\r\n" + 
					"date: 2019-"
					+String.format("%02d", 1+(int)(Math.random()*11))
					+ "-"
					+String.format("%02d", 1+(int)(Math.random()*27))
					+ " "
					+String.format("%02d", 8+(int)(Math.random()*14))
					+ ":"
					+ String.format("%02d", 2+(int)(Math.random()*55))
					+ ":"
					+ String.format("%02d", 2+(int)(Math.random()*55))
					+ "\r\n" + 
					"tags:\r\n" + 
					"---\r\n";
			for (int i = 0; i < content.length(); i++) {
				if ('\n'==content.toCharArray()[i]) {
					System.out.println(i);
					return head+content.substring(i, content.length());
				}
			}
			
			return head+content;
		};
	}
	
	

	private String read() {
		String content = "";
		/** 文件存在则直接读取，文件不存在则创建文件 */
		if (file.exists()) {// 文件存在
			/*** 增加缓存 - 读 **/
			FileInputStream fInputStream = null;
			BufferedInputStream buffInputStream = null; // 防止无法关闭，放在try/catch外面
			try {
				fInputStream = new FileInputStream(file);
				buffInputStream = new BufferedInputStream(fInputStream, 1024 * 10); // 不要太大，迅雷也就几十M
//				System.out.println(buffInputStream.available());	//inputStream.available()通过文件描述符获取文件的总大小
				byte[] bytes = new byte[buffInputStream.available()];
				buffInputStream.read(bytes);
//				System.out.println(new String(bytes));
				content = new String(bytes);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally { // 先关缓存流，再关文件流
				try {
					buffInputStream.close();
					fInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return content;
	}

	private void save(String content) {
		// 清空该文件
		if (file.exists()) {
			try {
				FileWriter fileWriter = new FileWriter(file);
				fileWriter.write("");
				fileWriter.flush();
				fileWriter.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		/*** 增加缓存 - 写 **/
		FileOutputStream fOutputStream = null;
		BufferedOutputStream buffOutputStream = null; // 防止无法关闭，放在try/catch外面
		try {
			fOutputStream = new FileOutputStream(file);
			buffOutputStream = new BufferedOutputStream(fOutputStream, 1024 * 10);// 不要太大，迅雷也就几十M
			buffOutputStream.write(content.getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				buffOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void edit() {
        String c = read();
		save(ed.edit(c));
	}


	private void setFile(File file) {
		this.file = file;
	}

	
}
