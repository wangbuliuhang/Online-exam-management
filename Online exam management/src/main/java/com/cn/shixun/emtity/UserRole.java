package com.cn.shixun.emtity;

public class UserRole {
    public UserRole(){

    }

    public UserRole(Integer userId,Integer roleId){
        this.roleId=roleId;
        this.userId=userId;
    }

    private Integer userId;

    private Integer roleId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer useId) {
        this.userId = useId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}