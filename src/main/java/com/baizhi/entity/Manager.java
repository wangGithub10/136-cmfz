package com.baizhi.entity;

import java.io.Serializable;

/**
 * 管理员实体类
 */
public class Manager implements Serializable {
    /**
     * 编号
     */
    private String id;
    /**
     * 账户
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    public Manager() {
        super();
    }

    public Manager(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Manager{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
