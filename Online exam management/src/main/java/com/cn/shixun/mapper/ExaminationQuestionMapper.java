package com.cn.shixun.mapper;

import com.cn.shixun.emtity.ExaminationQuestion;

public interface ExaminationQuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExaminationQuestion record);

    int insertSelective(ExaminationQuestion record);

    ExaminationQuestion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExaminationQuestion record);

    int updateByPrimaryKey(ExaminationQuestion record);
}