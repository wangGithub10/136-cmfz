package com.baizhi.service;

import com.baizhi.entity.Banner;

import java.util.List;

/**
 * 轮播图Service接口
 */
public interface BannerService {
    /**
     * 查询所有轮播图片信息
     *
     * @return List<Banner>
     */
    public List<Banner> queryAll();

    /**
     * 添加一条轮播图片信息、
     *
     * @param banner 轮播图实体类
     */
    public void insert(Banner banner);

    /**
     * 删除一条轮播图片的信息
     *
     * @param id 轮播图编号
     */
    public void delete(String id);

    /**
     * 修改论播图的状态
     *
     * @param id     编号
     * @param status 状态
     */
    public void update(String id, Integer status);
}
