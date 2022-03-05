package com.cn.shixun.mapper;

import com.cn.shixun.emtity.Faculty;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FacultyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Faculty record);

    int insertSelective(Faculty record);

    Faculty selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Faculty record);

    int updateByPrimaryKey(Faculty record);

    List<Faculty> loadFaculty();
}