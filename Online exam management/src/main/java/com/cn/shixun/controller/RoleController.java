package com.cn.shixun.controller;

import com.cn.shixun.common.JsGriData;
import com.cn.shixun.emtity.Role;
import com.cn.shixun.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping(value="add",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String add(Role role){
        String res=roleService.add(role);
        //System.out.println(res);
        return res;
    }

    /**
     * 菜单列表
     * @param
     * @return
     */
    @RequestMapping(value="list",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String list(JsGriData jsGriData){
        String res=roleService.list(jsGriData); //add没有可以工具点击反向接口创建
        System.out.println(res);
        return res;

    }

    /**
     *
     * 删除角色
     * @return 是否删除成功
     */
    @RequestMapping(value="del",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String del(Integer id){
        String res=roleService.del(id); //add没有可以工具点击反向接口创建
        System.out.println(res);
        return res;
    }

    /**
     *
     * 查询角色
     * @return 是否删除成功
     */
    @RequestMapping(value = "getById", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getById(Integer id){
        String res = roleService.getById(id);
        System.out.println(res);
        return res;
    }

    @RequestMapping(value="update",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String update(Role role){
        String res=roleService.update(role);
        System.out.println(res);
        return res;
    }

    @RequestMapping(value = "loadAllRole", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String loadAllRole(){
        String res = roleService.loadAllRole();
       // System.out.println(res);
        return res;
    }

}
