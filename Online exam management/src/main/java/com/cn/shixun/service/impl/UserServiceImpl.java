package com.cn.shixun.service.impl;
//这是UserService的实现类

import com.alibaba.fastjson.JSONObject;
import com.cn.shixun.common.JsGriData;
import com.cn.shixun.common.Message;
import com.cn.shixun.emtity.*;
import com.cn.shixun.mapper.UserMapper;
import com.cn.shixun.mapper.UserRoleMapper;
import com.cn.shixun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service   //SpringBoot使用的是注解体系 只有加了注解才能找到Service方法

public class UserServiceImpl implements UserService { //Userservice的实现类

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public String login(User user) {
        /*
         * 根据用户名和密码查询全体，返回一个user对象
         * 判断返回的user对象是不是null,如果不是null就是登陆成功
         * */
        User u = userMapper.login(user);
        //System.out.println(u); 还有错误 找不到数据库中的内容

        Message msg=new Message("999","登录失败!");
        if(u!=null){
            msg=new Message("200", "登陆成功");
        }
        return JSONObject.toJSONString(msg);
    }

    @Override
    public String add(User user) {
        userMapper.insertSelective(user);
        //还要注意  新增的user里面没有id值 在insertselective里面加两个属性即可返回主键
        userRoleMapper.insertSelective(new UserRole(user.getId(),user.getRoleId()));
        return JSONObject.toJSONString(new Message("200", "新增角色成功！"));

    }

    @Override
    public String list(JsGriData jsGriData) {
        jsGriData.setOffset(); // 计算偏移量
        List<Role> roles = userMapper.list(jsGriData); // 分页查询
        Long count = userMapper.count(jsGriData); // 总条数
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
            Message msg = new Message("999", "删除用户失败！");
            int i1 = userMapper.deleteByPrimaryKey(id);
            int i2 = userRoleMapper.deleteByUserId(id);
            if (i1 > 0 && i2 > 0) {
                msg.setInfo("200", "删除角色成功");
            }
            return JSONObject.toJSONString(msg);
        }

    @Override
    public String getById(Integer id) {
        User user=userMapper.selectByPrimaryKey(id);
        return  JSONObject.toJSONString(user);
    }
}

