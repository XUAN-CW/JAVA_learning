package redirectDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向的特点:redirect
 *     1. 地址栏发生变化
 *     2. 重定向可以访问其他站点(服务器)的资源
 *     3. 重定向是两次请求。不能使用request对象来共享数据
 */

@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("demo1........");
        //访问/responseDemo1，会自动跳转到/responseDemo2资源
       /* //1. 设置状态码为302
        response.setStatus(302);
        //2.设置响应头location
        response.setHeader("location","/day15/responseDemo2");*/

        request.setAttribute("msg","response");

        //动态获取虚拟目录
        String contextPath = request.getContextPath();
        //简单的重定向方法，一般用这个
        response.sendRedirect(contextPath+"/responseDemo2");
        //response.sendRedirect("http://www.itcast.cn");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
