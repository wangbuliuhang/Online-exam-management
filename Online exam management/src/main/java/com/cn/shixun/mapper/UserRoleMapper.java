package com.cn.shixun.mapper;

import com.cn.shixun.emtity.UserRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);

    int deleteByUserId(Integer id);
}