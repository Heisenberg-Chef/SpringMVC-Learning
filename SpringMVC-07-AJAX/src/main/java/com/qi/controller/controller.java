package com.qi.controller;

import com.qi.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class controller {

    @RequestMapping("/t1")
    @ResponseBody
    public String test()
    {
        return "hello";
    }

    @RequestMapping("/a1")
    @ResponseBody
    public void a1(String name, HttpServletResponse resp) throws IOException {
        System.out.println("a1:param ==> "+name);
        if("Heisenberg".equals(name))
        {
            resp.getWriter().println("yesyesyesyes.");
        }
        else
        {
            resp.getWriter().println("nononono.");
        }
    }

    @RequestMapping("/a2")
    @ResponseBody
    public List<User> a2()
    {
        List<User> userList = new ArrayList<>();
        userList.add(new User("1",1,"1"));
        userList.add(new User("2",2,"2"));
        userList.add(new User("3",3,"3"));
        return userList;
    }

    @RequestMapping("/at")
    public String at()
    {
        return "/AjaxTest";
    }
}
