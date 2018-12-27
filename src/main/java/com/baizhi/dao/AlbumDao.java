package com.baizhi.dao;

import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;

import java.util.List;

/**
 * 吉祥妙音功能Dao接口你
 */
public interface AlbumDao {
    /**
     * 查询专辑与专辑章节
     *
     * @return List<Album>
     */
    public List<Album> queryAll();

    /**
     * 查询一条专辑的详细信息
     *
     * @param id 编号
     * @return Album
     */
    public Album queryAlbum(String id);

    /**
     * 添加一条专辑信息
     *
     * @param album 吉祥妙音实体类
     */
    public void insert(Album album);

    /**
     * 添加一条专辑章节信息
     *
     * @param chapter 专辑章节实体类
     */
    public void insert2(Chapter chapter);
}
