package com.cn.shixun.service;

import com.cn.shixun.common.JsGriData;
import com.cn.shixun.emtity.Role;

public interface RoleService {
    String add(Role role);

    String list(JsGriData jsGriData);

    String del(Integer id);

    String getById(Integer id);

    String update(Role role);

    String loadAllRole();
}
