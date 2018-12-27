package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.entity.Banner;
import com.baizhi.service.AlbumService;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * App接口
 */
@Controller
@RequestMapping("/cmfz")
public class CmfzInterface {
    @Autowired
    private BannerService bannerService;
    @Autowired
    private AlbumService albumService;

    /**
     * App首页数据填充
     *
     * @param uid     用户唯一标识
     * @param type    请求数据类型
     * @param subType 上师言教
     * @return json字符串
     */
    @RequestMapping("/homePage.do")
    @ResponseBody
    public Map homePage(String uid, String type, String subType) {
        Map<String, Object> map = new HashMap<String, Object>();
        //当为type的值all时，返回轮播图，专辑，上师文章
        if (type.equals("all")) {
            // 手动封装轮播图信息
            List<Banner> queryAll = bannerService.queryAll();
            Set<String> jsonBanner = new HashSet<String>();
            for (Banner banners : queryAll) {
                String banner = "{\"title\":" + banners.getTitle() + "," +
                        "\"imgPath\":" + banners.getImgPath() + "}";
                jsonBanner.add(banner);
            }
            //手动封装专辑
            List<Album> queryAll2 = albumService.queryAll();
            Set<String> jsonAlbum = new HashSet<String>();
            for (Album albums : queryAll2) {
                String album = "{\"title\":" + albums.getTitle() + "," +
                        "\"author\":" + albums.getAuthor() + "," +
                        "\"broadCast\":" + albums.getBroadCast() + "," +
                        "\"count\":" + albums.getCount() + "," +
                        "\"corverImg\":" + albums.getCorverImg() + "," +
                        "\"score\":" + albums.getScore() + "," +
                        "\"publicDate\":" + albums.getPublicDate() + "," +
                        "\"brife\":" + albums.getBrife() + "}";
                jsonAlbum.add(album);
            }
            // 把json字符串存入map集合
            map.put("header", jsonBanner);
            map.put("album", jsonAlbum);
        } else if (type.equals("wen")) { // 当type的值为wen时返回专辑相关的数据
            //手动封装专辑
            List<Album> queryAll = albumService.queryAll();
            Set<String> jsonAlbum = new HashSet<String>();
            for (Album albums : queryAll) {
                String album = "{\"title\":" + albums.getTitle() + "," +
                        "\"author\":" + albums.getAuthor() + "," +
                        "\"broadCast\":" + albums.getBroadCast() + "," +
                        "\"count\":" + albums.getCount() + "," +
                        "\"corverImg\":" + albums.getCorverImg() + "," +
                        "\"score\":" + albums.getScore() + "," +
                        "\"publicDate\":" + albums.getPublicDate() + "," +
                        "\"brife\":" + albums.getBrife() + "}";
                jsonAlbum.add(album);
            }
            // 把json字符串存入map集合
            map.put("album", jsonAlbum);
        } else if (type.equals("si")) {
            //返回上师文章的相关数据
            if (subType.equals("ssyj")) {
                //返回用户上师的文章相关数据
            }
            if (subType.equals("xmfy|")) {
                //返回除用户上师以外所有的文章相关数据
            }
        }
        return map;
    }
}
