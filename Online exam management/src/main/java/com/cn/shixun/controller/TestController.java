package com.cn.shixun.controller;

import com.cn.shixun.emtity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("test")
public class TestController {

    @RequestMapping("index")
    @ResponseBody // 返回一个值给浏览器
    public String index(){
        return "hello";
    }

    @RequestMapping("demo")
    @ResponseBody // 返回一个值给浏览器
    public String demo(String name, Integer age){
        System.out.println(name + " " + age);
        return name + " " + age;
    }

    // 注入一个request对象
    @Autowired
    HttpServletRequest request;

    @RequestMapping("demo1")
    @ResponseBody // 返回一个值给浏览器
    public String demo1(){
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println(name + " " + age);
        return name + " " + age;
    }

    @RequestMapping("demo2")
    @ResponseBody // 返回一个值给浏览器
    public String demo2(User user){
        System.out.println(user);
        return user.toString();
    }
}
