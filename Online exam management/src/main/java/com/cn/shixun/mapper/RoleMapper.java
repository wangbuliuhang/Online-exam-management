package com.cn.shixun.mapper;

import com.cn.shixun.common.JsGriData;
import com.cn.shixun.emtity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> list(JsGriData jsGriData);

    Long count(JsGriData jsGriData);

    List<Role> loadAllRole();
}