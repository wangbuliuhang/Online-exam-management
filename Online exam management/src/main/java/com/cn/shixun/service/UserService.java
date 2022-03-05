package com.cn.shixun.service;

import com.cn.shixun.common.JsGriData;
import com.cn.shixun.emtity.User;

public interface UserService {
    public String login(User user);  //接受处理control发来的数据

    String add(User user);

    String list(JsGriData jsGriData);

    String del(Integer id);

    String getById(Integer id);
}
