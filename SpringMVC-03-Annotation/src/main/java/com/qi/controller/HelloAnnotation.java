package com.qi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/hi")
public class HelloAnnotation {
    @RequestMapping("/hi")
    public String Hello(Model model)
    {   //  封装数据
        model.addAttribute("msg","Hello,SpringMVCAnnotation");
        return "hello";     // 这个字符串会被视图解析处理
    }
}

