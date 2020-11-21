package com.bruce.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName EncodingFilter
 * @Description 编码过滤器，注解方式的过滤器通过文件名的排序作为执行顺序，设置响应头，解决跨域
 * @Author Bruce
 * @Date 2020/11/21 7:11 下午
 */
@WebFilter(filterName = "EncodingFilter", urlPatterns = "/*")
public class EncodingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpRequest.setCharacterEncoding("utf-8");
        httpResponse.setCharacterEncoding("utf-8");
        httpResponse.setContentType("application/json;charset=UTF-8");
        //解决跨域
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.setHeader("Access-Control-Allow-Origin", httpRequest.getHeader("Origin"));
        httpResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, token");
        httpResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS");

        if (httpRequest.getMethod().equals("OPTIONS")) {
            httpResponse.setStatus(HttpServletResponse.SC_OK);
        }
        chain.doFilter(httpRequest, httpResponse);

    }

}
