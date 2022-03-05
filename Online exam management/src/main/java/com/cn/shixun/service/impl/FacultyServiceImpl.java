package com.cn.shixun.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cn.shixun.emtity.Faculty;
import com.cn.shixun.mapper.FacultyMapper;
import com.cn.shixun.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    FacultyMapper facultyMapper;

    @Override
    public String loadFaculty() {
        List<Faculty> faculties=facultyMapper.loadFaculty();
        return JSONObject.toJSONString(faculties);
    }
}
