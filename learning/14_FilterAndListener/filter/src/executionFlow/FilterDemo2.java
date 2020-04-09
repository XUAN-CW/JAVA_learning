package executionFlow;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 过滤器执行流程
 * 		1. 执行过滤器
 * 		2. 执行放行后的资源
 * 		3. 回来执行过滤器放行代码下边的代码
 */
//@WebFilter("/*")
public class FilterDemo2 implements Filter {


    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //对request对象请求消息增强
        System.out.println("filterDemo2执行了....");

        //放行
        chain.doFilter(req, resp);
        //对response对象的响应消息增强
        System.out.println("filterDemo2回来了...");
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

}
