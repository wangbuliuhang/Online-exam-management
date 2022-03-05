package com.cn.shixun.mapper;

import com.cn.shixun.emtity.QuestionOptions;

public interface QuestionOptionsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QuestionOptions record);

    int insertSelective(QuestionOptions record);

    QuestionOptions selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QuestionOptions record);

    int updateByPrimaryKey(QuestionOptions record);
}