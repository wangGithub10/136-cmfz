package com.baizhi.service;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 管理员功能Service接口
 */
public interface ManagerService {
    /**
     * 管理员登陆
     *
     * @param username 账户
     * @param password 密码
     * @return Manager
     */
    public Map queryManager(String username, String password, HttpSession session);

    /**
     * 修改密码
     *
     * @param id       编号
     * @param password 新密码
     */
    public void update(String id, String password);
}
