package com.cn.shixun.mapper;

import com.cn.shixun.emtity.QuestionTemplate;

public interface QuestionTemplateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QuestionTemplate record);

    int insertSelective(QuestionTemplate record);

    QuestionTemplate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QuestionTemplate record);

    int updateByPrimaryKey(QuestionTemplate record);
}