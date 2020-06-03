import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileOperate {
    public void copy(File sourceFile,String destinationDir) {
        //获取源文件的名称
        String destination = destinationDir + File.separator + sourceFile.getName(); //目标地址

        try {
            //创建输入输出流对象
            FileInputStream fis = new FileInputStream(sourceFile);
            FileOutputStream fos = new FileOutputStream(destination);
            //创建搬运工具
            byte datas[] = new byte[1024 * 8];
            //创建长度
            int len = 0;
            //循环读取数据
            while ((len = fis.read(datas)) != -1) {
                fos.write(datas, 0, len);
            }
            //3.释放资源
            fis.close();
            fos.close();
            System.out.println(sourceFile+"→"+destinationDir);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
