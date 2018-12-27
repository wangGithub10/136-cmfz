package com.baizhi.test;

import com.baizhi.dao.MenuDao;
import com.baizhi.entity.Menu;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MenuDaoTest extends BaseTest {
    @Autowired
    private MenuDao menuDao;

    @Test
    public void queryAll() {
        List<Menu> menus = menuDao.queryAll();
        for (Menu menu : menus) {
            System.out.println("Menu=========" + menu);
            List<Menu> menus2 = menu.getMenus();
            for (Menu menu2 : menus2) {
                System.out.println("menu2===============" + menu2);
            }
        }
    }
}
