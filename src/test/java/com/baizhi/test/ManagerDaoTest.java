package com.baizhi.test;

import com.baizhi.dao.ManagerDao;
import com.baizhi.entity.Manager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ManagerDaoTest extends BaseTest {
    @Autowired
    private ManagerDao managerDao;

    @Test
    public void queryManager() {
        Manager manager = managerDao.queryManager("xiaohei");
        System.out.println(manager);
    }

    @Test
    public void update() {
        managerDao.update("102f54f67b4842229fd27d3b5f23014b", "123456");
    }
}
