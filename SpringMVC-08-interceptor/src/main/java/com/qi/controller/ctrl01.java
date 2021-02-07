package com.qi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ctrl01 {

    @GetMapping("/t1")
    public String test()
    {
        System.out.println("Controller 被执行了 ===> test()");
        return "OK";
    }
}
