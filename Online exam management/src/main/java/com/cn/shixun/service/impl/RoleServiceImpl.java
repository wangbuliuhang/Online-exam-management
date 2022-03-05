package com.cn.shixun.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cn.shixun.common.JsGriData;
import com.cn.shixun.common.Message;
import com.cn.shixun.emtity.Faculty;
import com.cn.shixun.emtity.Menu;
import com.cn.shixun.emtity.Role;
import com.cn.shixun.emtity.RoleMenu;
import com.cn.shixun.mapper.FacultyMapper;
import com.cn.shixun.mapper.MenuMapper;
import com.cn.shixun.mapper.RoleMapper;
import com.cn.shixun.mapper.RoleMenuMapper;
import com.cn.shixun.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;

    @Autowired
    RoleMenuMapper roleMenuMapper;

    @Autowired
    MenuMapper menuMapper;


    @Override
    public String add(Role role) {
        /*
        要保存2个表的数据
        1、role
        2、role_menu
        需要全部保存成功，才算保存成功
        使用数据库事务实现操作的原子性
         */
        int i1 = roleMapper.insertSelective(role);

        String[] menuIds = role.getMenuIds().split(",");
        for (String menuId : menuIds) {
            roleMenuMapper.insertSelective(new RoleMenu(role.getId(), Integer.parseInt(menuId)));
        }

        return JSONObject.toJSONString(new Message("200", "新增角色成功！"));
    }

    @Override
    public String list(JsGriData jsGriData) {
        jsGriData.setOffset(); // 计算偏移量
        List<Role> roles = roleMapper.list(jsGriData); // 分页查询
        Long count = roleMapper.count(jsGriData); // 总条数
        /*
        组装返回的JSGrid的json
        {
        "data" : 数据集合,
        "itemsCount" : 总条数
        }
         */
        Map<String, Object> map = new HashMap<>();
        map.put("data", roles);
        map.put("itemsCount", count);
        return JSONObject.toJSONString(map);
    }

    @Override
    public String del(Integer id) {
        /*
        删除角色，并且删除角色菜单关联信息
        */
        Message msg = new Message("999", "删除角色失败！");
        int i1 = roleMapper.deleteByPrimaryKey(id);
        int i2 = roleMenuMapper.deleteByRoleId(id);
        if (i1 > 0 && i2 > 0) {
            msg.setInfo("200", "删除角色成功");
        }
        return JSONObject.toJSONString(msg);
    }

    @Override
    public String getById(Integer id) {
        Role role = roleMapper.selectByPrimaryKey(id);
        List<Menu> menus = menuMapper.getMenusByRoleId(id);
        role.setMenus(menus);
        return JSONObject.toJSONString(role);
    }

    @Override
    public String update(Role role) {
        /*
        * 更新role对象
        * 1.更新role本身
        * 2.根据roleID删除role_menu的数据
        * 3.重新添加role_menu表的数据
        * */
        roleMapper.updateByPrimaryKeySelective(role);
        roleMenuMapper.deleteByRoleId(role.getId());

        String[] menuIds = role.getMenuIds().split(",");
        for (String menuId : menuIds) {
            roleMenuMapper.insertSelective(new RoleMenu(role.getId(), Integer.parseInt(menuId)));
        }

        return JSONObject.toJSONString(new Message("200", "修改角色成功！"));

    }

    @Override
    public String loadAllRole() {

        List<Role> roles = roleMapper.loadAllRole();
        return JSONObject.toJSONString(roles);
    }


}
