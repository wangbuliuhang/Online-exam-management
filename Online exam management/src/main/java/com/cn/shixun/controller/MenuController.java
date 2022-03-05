package com.cn.shixun.controller;

import com.cn.shixun.common.JsGriData;
import com.cn.shixun.emtity.Menu;
import com.cn.shixun.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("menu")
public class MenuController {
    /**
     *加载一级菜单
     * @return 一级菜单列表的json子谷川
     */

    @Autowired
    MenuService menuService;

    @RequestMapping(value="loadPMenus",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String loadPMenus(){
        String res=menuService.loadPMenus();
        //System.out.println(res); //在控制台打印
        return res;
    }

    /**
     * 新增菜单
     * @return 新增是否成功信息
     */

    @RequestMapping(value="add",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String add(Menu menu){
        String res=menuService.add(menu); //add没有可以工具点击反向接口创建
        System.out.println(res);
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
        String res=menuService.list(jsGriData); //add没有可以工具点击反向接口创建
        System.out.println(res);
        return res;

    }

    /**
     *
     * 删除菜单
     * @return 是否删除成功
     */
    @RequestMapping(value="del",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String del(Integer id){
        String res=menuService.del(id); //add没有可以工具点击反向接口创建
        System.out.println(res);
        return res;
    }

    @RequestMapping(value="getById",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getById(Integer id){
        String res=menuService.getById(id); //add没有可以工具点击反向接口创建
        System.out.println(res);
        return res;
    }

    /**
     * 修改菜单
     * @return 新增是否成功信息
     */

    @RequestMapping(value="update",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String update(Menu menu){
        String res=menuService.update(menu); //add没有可以工具点击反向接口创建
        System.out.println(res);
        return res;
    }

    /**
     * 加载多有菜单
     * @return
     */
    @RequestMapping(value="zNodes",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String zNodes(){
        String res=menuService.zNodes(); //add没有可以工具点击反向接口创建
        System.out.println(res);
        return res;
    }
}
