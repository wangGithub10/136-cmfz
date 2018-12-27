package com.baizhi.dao;

import com.baizhi.entity.Menu;

import java.util.List;

/**
 * 菜单功能Dao接口
 */
public interface MenuDao {
    /**
     * 查询所有菜单项
     *
     * @return List<Menu>
     */
    public List<Menu> queryAll();
}
