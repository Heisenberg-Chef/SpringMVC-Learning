package com.qi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.qi.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class controller {
    @RequestMapping(value="/j1")
    @ResponseBody // 不会走视图解析器了,会直接返回一个字符串.
    public String json1()
    {
        // 创建一个类
        User user = new User("祁磊#1",99,"男");
        return user.toString();
    }

    @RequestMapping(value="/j2")
    @ResponseBody // 不会走视图解析器了,会直接返回一个字符串.
    public String json2() throws JsonProcessingException {
        // jackson
        ObjectMapper mapper = new ObjectMapper();
        // 创建一个类
        User user = new User("祁磊#1",99,"男");
        return mapper.writeValueAsString(user);
    }

    @RequestMapping("/j3")
    @ResponseBody
    public String json3() throws JsonProcessingException {
        // jackson
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        // 自定义日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(sdf);
        return mapper.writeValueAsString(new Date());
        /**
         * 纯java的方式也可以解决这个问题,多种解决方案,具体看个人习惯.
         */
    }
}
