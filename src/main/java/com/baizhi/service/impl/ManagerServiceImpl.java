package com.baizhi.service.impl;

import com.baizhi.dao.ManagerDao;
import com.baizhi.entity.Manager;
import com.baizhi.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 管理员功能Service实现
 */
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerDao managerDao;

    /**
     * 管理员登陆
     *
     * @param username 账户
     * @param password 密码
     * @return Manager
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Map queryManager(String username, String password, HttpSession session) {
        Manager manager = managerDao.queryManager(username);
        Map<String, Object> map = new HashMap<String, Object>();
        if (manager == null) {
            map.put("mess", "用户不存在~");
        } else {
            if (manager.getPassword().equals(password)) {
                map.put("mess", null);
                session.setAttribute("manager", manager);
            } else {
                map.put("mess", "密码错误~");
            }
        }
        return map;
    }

    /**
     * 修改密码
     *
     * @param id       编号
     * @param password 新密码
     */
    @Override
    public void update(String id, String password) {
        managerDao.update(id, password);
    }
}
