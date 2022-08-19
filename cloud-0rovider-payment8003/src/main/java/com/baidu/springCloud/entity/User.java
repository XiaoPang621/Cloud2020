package com.baidu.springCloud.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @Description : User
 * @Author : WangYaFei
 * @Date: 2022-05-30 14:51
 */

public class User {
    @ExcelProperty("账号")
    private String username;
    @ExcelProperty("密码")
    private String password;

    public User() {

    }

    public User(String s, int i, String s1) {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username=" + username +
                ", password='" + password + '\'' +
                '}';
    }
}
