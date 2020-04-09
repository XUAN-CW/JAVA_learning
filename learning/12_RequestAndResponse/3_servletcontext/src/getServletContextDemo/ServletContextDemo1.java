package getServletContextDemo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 1. 概念：代表整个web应用，可以和程序的容器(服务器)来通信
 * 2. 获取：
 * 	1. 通过request对象获取
 * 		request.getServletContext();
 * 	2. 通过HttpServlet获取
 * 		this.getServletContext();
 * 3. 功能：
 * 	1. 获取MIME类型：
 * 		* MIME类型:在互联网通信过程中定义的一种文件数据类型
 * 			* 格式： 大类型/小类型   text/html		image/jpeg
 *
 * 		* 获取：String getMimeType(String file)
 * 	2. 域对象：共享数据
 * 		1. setAttribute(String name,Object value)
 * 		2. getAttribute(String name)
 * 		3. removeAttribute(String name)
 *
 * 		* ServletContext对象范围：所有用户所有请求的数据
 * 	3. 获取文件的真实(服务器)路径
 * 		1. 方法：String getRealPath(String path)
 * 			 String b = context.getRealPath("/b.txt");//web目录下资源访问
 * 	         System.out.println(b);
 *
 * 	        String c = context.getRealPath("/WEB-INF/c.txt");//WEB-INF目录下的资源访问
 * 	        System.out.println(c);
 *
 * 	        String a = context.getRealPath("/WEB-INF/classes/a.txt");//src目录下的资源访问
 * 	        System.out.println(a);
 */

@WebServlet("/servletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*

            ServletContext对象获取：
                1. 通过request对象获取
			        request.getServletContext();
                2. 通过HttpServlet获取
                    this.getServletContext();
         */
        
        //1. 通过request对象获取
        ServletContext context1 = request.getServletContext();
        //2. 通过HttpServlet获取
        ServletContext context2 = this.getServletContext();

        System.out.println(context1);
        System.out.println(context2);

        //两种方法获取到同一个对象
        System.out.println(context1 == context2);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
