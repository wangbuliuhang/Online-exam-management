package com.cn.shixun.mapper;

import com.cn.shixun.common.JsGriData;
import com.cn.shixun.emtity.Role;
import com.cn.shixun.emtity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User login(User user);

    Object getId();

    List<Role> list(JsGriData jsGriData);

    Long count(JsGriData jsGriData);
}