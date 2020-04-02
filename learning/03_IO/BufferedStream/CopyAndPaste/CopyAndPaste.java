package CopyAndPaste;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * 使用带缓冲的流增加读写效率 - 装饰器实例
 */
public class CopyAndPaste {
	/*** 文件路径 **/
	private static final String CopyFile = "src/test/test.wmv";
	private static final String PastePath = "src/test/已复制文件.wmv";
	
	public static void main(String[] args) throws IOException {
		
		/*** 使用缓冲流装饰系统的输入流对象 **/
		//对新手不友好，还抛出异常，就被取消了
//		BufferedInputStream inStream = new BufferedInputStream(System.in);
//		byte[] bytes = new byte[200];
//		System.out.println("请输入字符串：");
//		inStream.read(bytes);
//		System.out.println("用户输入的字符串是：" + new String(bytes));
		
		/*** 使用缓存流拷贝文件 **/
		long time = CopyFileByBufferedStream();
		System.out.println("拷贝用时：" + time + "毫秒");

//		//小作业：请各位小伙伴自行使用FileInputStream实现文件的复制
//		//通过复制所用的时间，对比使用缓存的好处
//		//通过设置不同的缓存大小，体会效率的区别
	}
	
	/**
	 * 使用缓存流拷贝文件
	 * @return 拷贝过程的用时（毫秒）
	 */
	private static long CopyFileByBufferedStream(){
		File file = new File(CopyFile);		//要复制的文件对象
		if(!file.exists()){
			System.out.println("文件不存在，复制失败！");
			return 0;
		}
		long starTime = System.currentTimeMillis();
		InputStream inStream = null;
		BufferedInputStream buffInStream = null;
		OutputStream outStream = null;
		BufferedOutputStream buffOutStream = null;
		int theSizeOfBuffer = 1024; 	//在这里修改缓存的大小，下面输入的时候用
		try {
			inStream = new FileInputStream(file);
			buffInStream = new BufferedInputStream(inStream,theSizeOfBuffer);
			outStream = new FileOutputStream(PastePath);
			buffOutStream = new BufferedOutputStream(outStream);
			int i = -1;//读取出的临时变量
			while((i = buffInStream.read()) != -1){	//写入到了缓存中
				buffOutStream.write(i);	//缓存中的内容写入到文件中
				//注意：读取一个字节，就写入到了缓存中！需要在最后，将缓存中的内容写入到文件中！.
				//即，需要清空缓冲区，将缓冲区的内容写到文件中 - flush()
			}
			System.out.println("文件复制成功！");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				//bOutStream.flush();
				buffOutStream.close();//可以直接调用close方法，内部已经帮我们自动调用了flush方法
				outStream.close();
				buffInStream.close();
				inStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		long endTime = System.currentTimeMillis();
		return endTime - starTime;
	}
	
	
	
	
	
}
