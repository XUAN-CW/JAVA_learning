import java.io.File;
import java.io.IOException;
/**
 *
 * 参考：
 *     https://www.cnblogs.com/sam-uncle/p/10908567.html
 * 遇到的问题
 *     记得添加更改 pom.xml ,引入依赖
 *     Error:java: 不再支持源选项 5。请使用 6 或更高版本：
 *         https://blog.csdn.net/qq_40960093/article/details/103230762?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.nonecase
 */
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class SimplyCrawlTheHTML {

    /**
     *
     * @param url
     * @return
     */
    public static String getHTML(String url){
        System.out.println("当前 url: "+url);
        String html=null;
        //1.生成httpclient，相当于该打开一个浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        //2.创建get请求，相当于在浏览器地址栏输入网址
        HttpGet request = new HttpGet(url);
        try {
            //3.执行get请求，相当于在输入地址栏后敲回车键
            response = httpClient.execute(request);
            //4.判断响应状态为200，进行处理
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                //5.获取响应内容
                HttpEntity httpEntity = response.getEntity();
                html = EntityUtils.toString(httpEntity, "utf-8");
//                System.out.println(html);
            } else {
                //如果返回状态不是200，比如404（页面不存在）等，根据情况做处理，这里略
                System.out.println("返回状态不是200");
//                System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6.关闭
            HttpClientUtils.closeQuietly(response);
            HttpClientUtils.closeQuietly(httpClient);
        }
        return html;
    }

    public static void main(String[] args) {
        String rootOfHTML="./allHTML";//HTML 根目录
        File allHTML=new File(rootOfHTML);
        if (!allHTML.exists()){
            allHTML.mkdir();
        }
        for (int i=30000;i>0;i--){
            String url="http://acgheaven.cc/archives/"+i;

            String currentChildDirectory=rootOfHTML+"/"+i/500;//每个子目录下最多有 500 个 HTML 文件
            String currentFile=currentChildDirectory+"/"+i+".html";
            File ccd = new File(currentChildDirectory);
            File cFile=new File(currentFile);

            if (!ccd.exists()){
                ccd.mkdir();
            }
            if (cFile.exists()){
                continue;
            }

            String html=getHTML(url);
//            System.out.println(html);
            if (null!=html){
                //去除不需要的页面
                if (html.contains("<title>绅士天堂-ACG绅士天堂</title>")){
                    continue;
                }
                System.out.println(html);
                SaveAndRead saveAndRead=new SaveAndRead();
                saveAndRead.save(cFile.getPath(), html);
                System.out.println("保存 "+url+" 到 "+currentFile);
            }
        }

    }
}