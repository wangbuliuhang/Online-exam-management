package com.cn.shixun.mapper;

import com.cn.shixun.emtity.RoleMenu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMenuMapper {
    int insert(RoleMenu record);

    int insertSelective(RoleMenu record);

    int deleteByRoleId(Integer id);
}