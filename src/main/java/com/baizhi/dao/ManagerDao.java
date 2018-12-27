package com.baizhi.dao;

import com.baizhi.entity.Manager;
import org.apache.ibatis.annotations.Param;

/**
 * 管理员功能Dao接口
 */
public interface ManagerDao {
    /**
     * 管理员登陆
     *
     * @param username 账户
     * @return Manager
     */
    public Manager queryManager(String username);

    /**
     * 修改密码
     *
     * @param id       编号
     * @param password 新密码
     */
    public void update(@Param("id") String id, @Param("password") String password);
}
