package com.cn.shixun.service;

import com.cn.shixun.common.JsGriData;
import com.cn.shixun.emtity.Menu;

public interface MenuService {
    String loadPMenus();

    String add(Menu menu);

    String list(JsGriData jsGriData);

    String del(Integer id);

    String getById(Integer id);

    String update(Menu menu);

    String zNodes();
}
