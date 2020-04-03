package forwordAndShare;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 2. 请求转发：一种在服务器内部的资源跳转方式
 *     1. 步骤：
 *         1. 通过request对象获取请求转发器对象：RequestDispatcher getRequestDispatcher(String path)
 *         2. 使用RequestDispatcher对象来进行转发：forward(ServletRequest request, ServletResponse response)
 *     2. 特点：
 *         1. 浏览器地址栏路径不发生变化
 *         2. 只能转发到当前服务器内部资源中。
 *         3. 转发是一次请求
 */

@WebServlet("/d8")
public class RequestDemo8 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo8 被访问了");

        //转发到demo9资源
         /*
        java.lang.IllegalStateException: Cannot forward after response has been committed
        不能在上一个响应前提交，这个 demo 不会有响应，因此这个 demo 只能有一次转发
         */
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/d9");
//        requestDispatcher.forward(request,response);


        //存储数据到request域中
        request.setAttribute("msg","this msg share to requestDemo9");
        request.getRequestDispatcher("/d9").forward(request,response);
        //不在内部，转发失败
//        request.getRequestDispatcher("http://www.itcast.cn").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
}
