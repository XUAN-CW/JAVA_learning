package sverletDemo;

import javax.servlet.*;
import java.io.IOException;
import java.net.StandardSocketOptions;

public class HelloServlet implements Servlet {
    /**
     * 初始化时调用
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init");
    }

    /**
     * 获取配置
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 被访问时调用
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("hello servlet");
    }

    /**
     * 获取 servlet 信息（作者、日期等）
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 服务器正常关闭时调用，非正常关闭不会调用
     * 一般用于释放资源
     */
    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}

//package servlet;
//
//public class helloServlet {
//    public static void main(String[] args) {
//        System.out.println(3333111);
//    }
//}
