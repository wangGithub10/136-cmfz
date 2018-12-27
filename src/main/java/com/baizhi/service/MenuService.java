package com.baizhi.service;

import com.baizhi.entity.Menu;

import java.util.List;

/**
 * 菜单功能Service接口
 */
public interface MenuService {
    /**
     * 查询所有菜单项
     *
     * @return List<Menu>
     */
    public List<Menu> queryAll();
}
