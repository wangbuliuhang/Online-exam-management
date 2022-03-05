package com.cn.shixun.controller;

import com.cn.shixun.common.JsGriData;
import com.cn.shixun.emtity.Menu;
import com.cn.shixun.emtity.User;
import com.cn.shixun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired //注解，给UserService注入对象 说明是Service，在这里已经定义了对象
    UserService userService;

    //希望看到controller返回json字符,需要指定返回数据
    @RequestMapping(value="login",produces = "application/json; charset=utf-8")
    @ResponseBody
        public String login(User user){
            System.out.println(user.getUsername()+", "+user.getPassword());
            String res=userService.login(user); //直接使用注解完的对象
           // System.out.println(res);
            return res;
        }

    @RequestMapping(value="add",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String add(User user){
        String res=userService.add(user); //add没有可以工具点击反向接口创建
        //System.out.println(user);
        System.out.println(res);
        return res;
    }

    /**
     * 用户列表
     * @param
     * @return
     */
    @RequestMapping(value="list",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String list(JsGriData jsGriData){
        String res=userService.list(jsGriData); //add没有可以工具点击反向接口创建
        System.out.println(res);
        return res;

    }

    /**
     *
     * 删除用户
     * @return 是否删除成功
     */
    @RequestMapping(value="del",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String del(Integer id){
        String res=userService.del(id); //add没有可以工具点击反向接口创建
        System.out.println(res);
        return res;
    }

    @RequestMapping(value="getById",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getById(Integer id){
        String res=userService.getById(id); //add没有可以工具点击反向接口创建
        System.out.println(res);
        return res;
    }



}
