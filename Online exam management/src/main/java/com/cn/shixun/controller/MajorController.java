package com.cn.shixun.controller;

import com.cn.shixun.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("major")
public class MajorController {

    @Autowired
    MajorService majorService;

    @RequestMapping(value="loadPMenus1",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String loadPMenus1(Integer facultyId){
        //System.out.println(facultyId);
        String res=majorService.loadPMenus1(facultyId);
       // System.out.println(res);
        return res;
    }
}
