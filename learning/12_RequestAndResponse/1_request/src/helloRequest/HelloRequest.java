package helloRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;


@WebServlet("/hr")
public class HelloRequest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        System.out.println("\033[0;7;4m" + "----------获取请求行数据----------" + "\033[0m");
        System.out.println("获取请求方式："+req.getMethod());
        System.out.println("获取虚拟目录："+req.getContextPath());
        System.out.println("获取Servlet路径："+req.getServletPath());
        System.out.println("获取get方式请求参数："+req.getQueryString());
        System.out.println("获取请求URI："+req.getRequestURI());
        System.out.println("获取请求URL："+req.getRequestURL());
        System.out.println("获取协议及版本："+req.getProtocol());
        System.out.println("获取客户机的IP地址："+req.getRemoteAddr());

        System.out.println("\033[0;7;4m"+"----------获取请求头数据----------" + "\033[0m");
        Enumeration<String> headerNames = req.getHeaderNames();//获取所有请求头名称
        //遍历
        while(headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            //根据名称获取请求头的值
            String value = req.getHeader(name);
            System.out.println(name+":"+value);
        }

        System.out.println("\033[0;7;4m"+"----------判断浏览器:user-agent----------" + "\033[0m");
        String agent = req.getHeader("user-agent");
        //判断agent的浏览器版本
        if(agent.contains("Chrome")){
            //谷歌
            System.out.println("谷歌来了...");
        }else if(agent.contains("Firefox")){
            //火狐
            System.out.println("火狐来了...");
        }

        System.out.println("\033[0;7;4m"+"----------鉴别来者:referer----------" + "\033[0m");
        String referer = req.getHeader("referer");
        System.out.println(req.getHeader("referer"));
        //防盗链
        if(referer != null ){
            if(referer.contains("login")){
                System.out.println("访问成功");
            }else{
                System.out.println("访问失败");
            }
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        System.out.println("HelloRequest:doPost");
    }


}
