package com.cn.shixun.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cn.shixun.common.JsGriData;
import com.cn.shixun.common.Message;
import com.cn.shixun.emtity.Menu;
import com.cn.shixun.mapper.MenuMapper;
import com.cn.shixun.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {
    /**
     *加载一级菜单
     * @return 一级菜单列表的json子谷川
     */
    @Autowired
    MenuMapper menuMapper;




    @Override
    public String loadPMenus(){
        List<Menu> menus=menuMapper.loadPMenus();
        return JSONObject.toJSONString(menus);
    }

    @Override
    public String add(Menu menu) {
        int i=menuMapper.insertSelective(menu);
        Message msg = new Message("999", "新增菜单失败！");
        if(i>0){
            msg=new Message("200", "新增菜单成功！");
        }
        return  JSONObject.toJSONString(msg);
    }

    @Override
    public String list(JsGriData jsGriData) {
        jsGriData.setOffset(); // 计算偏移量
        List<Menu> menus = menuMapper.list(jsGriData); // 分页查询
        Long count = menuMapper.count(jsGriData); // 总条数
        /*
        组装返回的JSGrid的json
        {
        "data" : 数据集合,
        "itemsCount" : 总条数
        }
         */
        Map<String, Object> map = new HashMap<>();
        map.put("data", menus);
        map.put("itemsCount", count);
        //System.out.println(222);
        return JSONObject.toJSONString(map);
    }

    @Override
    public String del(Integer id) {
        Message msg = new Message("999", "删除菜单失败！");
        //1.判断这个菜单有没有下级菜单存在 由下级菜单不能直接删除
        Long count=menuMapper.countByParentId(id);
        if(count>0){//有子菜单,不能删除
            msg.setInfo("999","有子菜单，不能删除!");
            return JSONObject.toJSONString(msg);
        }

        //2.删除菜单
        int i=menuMapper.deleteByPrimaryKey(id);

        if(i>0){
            msg=new Message("200", "删除菜单成功！");
        }
        return  JSONObject.toJSONString(msg);
    }

    @Override
    public String getById(Integer id) {
        Menu menu=menuMapper.selectByPrimaryKey(id);
        return  JSONObject.toJSONString(menu);
    }

    @Override
    public String update(Menu menu) {
        int i=menuMapper.updateByPrimaryKeySelective(menu);
        Message msg = new Message("999", "修改菜单失败！");
        if(i>0){
            msg=new Message("200", "修改菜单成功！");
        }
        return  JSONObject.toJSONString(msg);
    }

    @Override
    public String zNodes() {
        List<Menu> zNodes=menuMapper.zNodes();
        return JSONObject.toJSONString(zNodes);
    }

}
