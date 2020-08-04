package com.info.beans;

public class UserDao {

    private String name;

    public void setName(String name) {
        this.name = name;
    }
    public void  addUser(){
        System.out.println("添加用户"+this.name);
    }
}
