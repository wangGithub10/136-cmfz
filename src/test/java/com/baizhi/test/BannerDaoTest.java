package com.baizhi.test;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class BannerDaoTest extends BaseTest {
    @Autowired
    private BannerDao bannerDao;

    @Test
    public void quryAll() {
        List<Banner> queryAll = bannerDao.queryAll();
        for (Banner banner : queryAll) {
            System.out.println(banner);
        }
    }

    @Test
    public void insert() {
        Banner banner = new Banner("adniuaw23132asdas", "测试", "path", "测试", null, new Date());
        bannerDao.insert(banner);
    }

    @Test
    public void delete() {
        bannerDao.delete("asda");
    }

    @Test
    public void update() {
        bannerDao.update("d80a0d70a897438f87d2ceed6518e4fb",1);
    }
}
