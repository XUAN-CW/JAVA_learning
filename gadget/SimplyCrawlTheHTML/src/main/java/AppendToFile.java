import java.io.FileWriter;
import java.io.IOException;

/**
 * 参考：https://blog.csdn.net/merry3602/article/details/7045515
 */

public class AppendToFile {

    /**
     * 追加文件：使用FileWriter
     */
    public static void appendContentToFile(String fileName, String content) {
        try {
            //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        String fileName = "./a3aaaa.txt";
//        String content = "new append!";
//        AppendToFile.appendContentToFile(fileName, "11111111");
//    }
}