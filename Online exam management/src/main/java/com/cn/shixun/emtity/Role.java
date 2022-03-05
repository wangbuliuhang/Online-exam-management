package com.cn.shixun.emtity;

import java.util.List;

public class Role {
    private Integer id;

    private String roleCode;

    private String roleName;

    private String MenuIds;

    private List<Menu> Menus;

    public List<Menu> getMenus() {
        return Menus;
    }

    public void setMenus(List<Menu> menus) {
        Menus = menus;
    }

    public String getMenuIds() {
        return MenuIds;
    }

    public void setMenuIds(String menuIds) {
        MenuIds = menuIds;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}