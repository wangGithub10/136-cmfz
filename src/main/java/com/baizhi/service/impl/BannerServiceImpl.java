package com.baizhi.service.impl;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 轮播图Service实现
 */
@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerDao bannerDao;

    /**
     * 查询所有轮播图片信息
     *
     * @return List<Banner>
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Banner> queryAll() {
        return bannerDao.queryAll();
    }

    /**
     * 添加一条轮播图片信息
     *
     * @param banner 轮播图实体类
     */
    @Override
    public void insert(Banner banner) {
        bannerDao.insert(banner);
    }

    /**
     * 删除一条轮播图片的信息
     *
     * @param id 轮播图编号
     */
    @Override
    public void delete(String id) {
        bannerDao.delete(id);
    }

    /**
     * 修改轮播图状态
     *
     * @param id     编号
     * @param status 状态
     */
    @Override
    public void update(String id, Integer status) {
        bannerDao.update(id, status);
    }
}
