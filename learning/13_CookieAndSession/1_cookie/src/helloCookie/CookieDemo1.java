package helloCookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * cookie的细节
 * 	1. 一次可不可以发送多个cookie?
 * 		* 可以
 * 		* 可以创建多个Cookie对象，使用response调用多次addCookie方法发送cookie即可。
 * 	2. cookie在浏览器中保存多长时间？
 * 		1. 默认情况下，当浏览器关闭后，Cookie数据被销毁
 * 		2. 持久化存储：
 * 			* setMaxAge(int seconds)
 * 				1. 正数：将Cookie数据写到硬盘的文件中。持久化存储。并指定cookie存活时间，时间到后，cookie文件自动失效
 * 				2. 负数：默认值
 * 				3. 零：删除cookie信息
 * 	3. cookie能不能存中文？
 * 		* 在tomcat 8 之前 cookie中不能直接存储中文数据。
 * 			* 需要将中文数据转码---一般采用URL编码(%E3)
 * 		* 在tomcat 8 之后，cookie支持中文数据。特殊字符还是不支持，建议使用URL编码存储，URL解码解析
 * 	4. cookie共享问题？
 * 		1. 假设在一个tomcat服务器中，部署了多个web项目，那么在这些web项目中cookie能不能共享？
 * 			* 默认情况下cookie不能共享
 *
 * 			* setPath(String path):设置cookie的获取范围。默认情况下，设置当前的虚拟目录
 * 				* 如果要共享，则可以将path设置为"/"
 */


@WebServlet("/cookieDemo1")
public class CookieDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        java.lang.IllegalArgumentException: An invalid character [32] was present in the Cookie value
//        这句话的意思是
//        一个不识别的字符[32]出现在了cookie当中
//        由于tomcat的版本比较高，所以在addCookie时是不能使用空格的 而在ASCII码中32对应的就是空格。
//        只要把后台代码中的空格删掉就可以了。

        //1.创建Cookie对象
        Cookie c = new Cookie("msg","helloCookie");
        //2.发送Cookie
        response.addCookie(c);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
