package com.qi.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyInterceptor implements HandlerInterceptor {
    //  如果是登陆页面则放行,如果不是则ban
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("uri : "+request.getRequestURI());
        if(request.getRequestURI().contains("login"))
        {
            // 头一次进入登录页面.
            System.out.println("有login");
            return true;
        }
        // 如果用户已登陆也放行
        HttpSession session = request.getSession();
        if(session.getAttribute("user")!=null)
        {
            System.out.println("用户已经登陆");
            return true;
        }

        // 用户没有登陆跳转到登陆页面
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        System.out.println("不放行");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
