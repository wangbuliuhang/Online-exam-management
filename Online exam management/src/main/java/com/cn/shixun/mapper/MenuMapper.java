package com.cn.shixun.mapper;

import com.cn.shixun.common.JsGriData;
import com.cn.shixun.emtity.Menu;
import com.cn.shixun.emtity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);
    //PrimaryKey是主键

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> loadPMenus();

    List<Menu> list(JsGriData jsGriData);

    Long count(JsGriData jsGriData);

    Long countByParentId(Integer id);

    List<Menu> zNodes();

    List<Menu> getMenusByRoleId(Integer id);


}