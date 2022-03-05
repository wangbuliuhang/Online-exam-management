package com.cn.shixun.controller;

import com.cn.shixun.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("faculty")
public class FacultyController {

    @Autowired
    FacultyService facultyService;

    @RequestMapping(value="loadFaculty",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String loadFaculty(){
        String res=facultyService.loadFaculty();
        //System.out.println(res);
        return res;
    }
}
