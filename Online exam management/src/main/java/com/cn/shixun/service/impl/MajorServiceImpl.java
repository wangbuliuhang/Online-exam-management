package com.cn.shixun.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cn.shixun.emtity.Faculty;
import com.cn.shixun.emtity.Major;
import com.cn.shixun.mapper.MajorMapper;
import com.cn.shixun.service.MajorService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorServiceImpl implements MajorService {

    @Autowired
    MajorMapper majorMapper;

    @Override
    public String loadPMenus1(Integer facultyId) {

        List<Major> majors=majorMapper.loadPMenus1(facultyId);
        return JSONObject.toJSONString(majors);

    }
}
