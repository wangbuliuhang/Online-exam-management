package com.cn.shixun.mapper;

import com.cn.shixun.emtity.MajorSemesterSubject;

public interface MajorSemesterSubjectMapper {
    int deleteByPrimaryKey(Integer majorSemesterId);

    int insert(MajorSemesterSubject record);

    int insertSelective(MajorSemesterSubject record);

    MajorSemesterSubject selectByPrimaryKey(Integer majorSemesterId);

    int updateByPrimaryKeySelective(MajorSemesterSubject record);

    int updateByPrimaryKey(MajorSemesterSubject record);
}