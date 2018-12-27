package com.baizhi.controller;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 菜单功能Controller控制器
 */
@Controller
@RequestMapping("/menu")
public class MenuCotroller {
    @Autowired
    private MenuService menuService;

    /**
     * 查询所有菜单项
     *
     * @return json字符串
     */
    @RequestMapping("/queryAll.do")
    @ResponseBody
    public List<Menu> queryAll() {
        return menuService.queryAll();
    }
}
