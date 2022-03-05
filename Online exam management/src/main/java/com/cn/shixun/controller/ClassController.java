package com.cn.shixun.controller;

import com.cn.shixun.service.ClassService;
import com.cn.shixun.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("class")
public class ClassController {
    @Autowired
    ClassService classService;

    @RequestMapping(value="loadPMenus2",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String loadPMenus2(Integer facultyId,Integer majorId){
        //System.out.println(facultyId);
        //System.out.println(majorId);
        String res=classService.loadPMenus2(facultyId,majorId);
       // System.out.println(res);
        return res;
    }
}
