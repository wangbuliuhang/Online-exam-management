package com.cn.shixun.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cn.shixun.emtity.Major;
import com.cn.shixun.mapper.ClassMapper;
import com.cn.shixun.mapper.MajorMapper;
import com.cn.shixun.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    ClassMapper classMapper;

    @Override
    public String loadPMenus2(Integer facultyId, Integer majorId) {
        List<Class> classes=classMapper.loadPMenus2(facultyId,majorId);
        return JSONObject.toJSONString(classes);
    }
}
