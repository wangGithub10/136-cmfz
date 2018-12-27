package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 轮播图Controller控制器
 */
@Controller
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    /**
     * 查询所有轮播图片信息
     *
     * @return json字符串
     */
    @RequestMapping("/queryAll.do")
    @ResponseBody
    public List<Banner> queryAll() {
        return bannerService.queryAll();
    }

    /**
     * 添加一条轮播图片信息
     *
     * @return json字符串
     */
    @RequestMapping("/insert.do")
    @ResponseBody
    public String insert(@RequestParam(value = "fileName") MultipartFile multipartFile, Banner banner, HttpSession session) throws IOException {
        String path = "/view/main/banner";
        // 根据相对路径获取相对路径
        String realPath = session.getServletContext().getRealPath(path);
        // 判断文件夹是否存在,进行创建文件夹
        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdir();
        }
        // 用工具类上传文件,参数是保存文件的目标:按照指定目标将上传文件保存
        multipartFile.transferTo(new File(realPath + "/" + multipartFile.getOriginalFilename()));
        // 填充实体类信息
        banner.setId(UUID.randomUUID().toString().replace("-", ""));
        banner.setImgPath(path + "/" + multipartFile.getOriginalFilename());
        banner.setCreateDate(new Date());
        bannerService.insert(banner);
        return "ok";
    }

    /**
     * 删除一条轮播图片信息
     *
     * @param id      轮播图编号
     * @param imgPath 图片相对路径
     * @param session session作用域
     * @return json字符串
     */
    @RequestMapping("/delete.do")
    @ResponseBody
    public Boolean delete(String id, String imgPath, HttpSession session) {
        // 根据相对路径获取绝对路径
        File file = new File(session.getServletContext().getRealPath(imgPath));
        // 判断是否删除成功
        if (file.delete()) {
            bannerService.delete(id);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 修改轮播图状态
     *
     * @param banner 轮播图实体类
     * @return json字符串
     */
    @RequestMapping("/update.do")
    @ResponseBody
    public void update(Banner banner) {
        bannerService.update(banner.getId(), banner.getStatus());
    }
}
