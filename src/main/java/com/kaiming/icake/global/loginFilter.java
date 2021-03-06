package com.kaiming.icake.global;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class loginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        Object object = request.getSession().getAttribute("ACCOUNT");
        if (object == null) {
            System.out.println("no account in Session");
            response.sendRedirect(request.getContextPath() + "/toLogin.do");
        }else{
            filterChain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
