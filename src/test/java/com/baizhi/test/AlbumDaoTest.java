package com.baizhi.test;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class AlbumDaoTest extends BaseTest {
    @Autowired
    private AlbumDao albumDao;

    @Test
    public void queryAll() {
        List<Album> queryAll = albumDao.queryAll();
        for (Album album : queryAll) {
            System.out.println(album);
            for (Chapter chapter : album.getChildren()) {
                System.out.println(chapter);
            }
        }
    }

    @Test
    public void insert(){
        Album album = new Album("asasddq","asd","asd","asd","asd","asd",10.0,0,new Date(),"asd",null);
        albumDao.insert(album);
    }
}
