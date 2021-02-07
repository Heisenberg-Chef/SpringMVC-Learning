package com.qi.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        // ModelAndView 模型和视图
        ModelAndView mv = new ModelAndView();

        // 封装对象,放在ModelAndView中
        mv.addObject("msg","HelloSpringMVC!");
        // 封装要跳转的视图,放在ModelAndView中
        mv.setViewName("hello"); // WEB-INF/jps/hello.jsp 根据设置,定向到该任务
        return mv;
    }
}
