package com.cn.shixun.emtity;

public class RoleMenu {
    public RoleMenu(){

    }

    public RoleMenu(Integer roleId,Integer menuId){
        this.roleId=roleId;
        this.menuId=menuId;
    }
    //之前这里menuid写错了 手动改了
    private Integer roleId;

    private Integer menuId;


    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
}