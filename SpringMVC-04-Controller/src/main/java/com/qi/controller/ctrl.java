package com.qi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// restful
@Controller
//  实现这个接口的类就可以实控制器 , 这个注解则是包括了Controller接口的向综合注解.
public class ctrl {
//    @RequestMapping(value="/add/{a}/{b}",method = RequestMethod.GET)
    @GetMapping("/add/{a}/{b}")
//    @DeleteMapping
//    @PostMapping
//    @PutMapping
//    @RequestMapping
//    @PatchMapping
    public String c1(Model model, @PathVariable String a,@PathVariable String b)
    {
        // 原始风格 localhost:8080/add?a=1&b=2
        // restful localhost:8080/add/a/b

        String res = a+b;
        model.addAttribute("msg","GET结果为"+res);
        return "ctrl";
    }

    @PostMapping("/add/{b}/{a}")
    public String c2(Model model,@PathVariable String a,@PathVariable String b)
    {
        String res = a + b;
        model.addAttribute("msg","POST结果为"+res);
        return "ctrl";
    }
}
