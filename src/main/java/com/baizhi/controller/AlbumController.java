package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.service.AlbumService;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.MultimediaInfo;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 吉祥妙音功能Controller控制器
 */
@Controller
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    /**
     * 查询专辑与专辑章节
     *
     * @return json字符串
     */
    @RequestMapping("/queryAll.do")
    @ResponseBody
    public List<Album> queryAll() {
        return albumService.queryAll();
    }

    /**
     * 查询一条专辑的详细信息
     *
     * @param id 编号
     * @return json字符串
     */
    @RequestMapping("/queryAlbum.do")
    @ResponseBody
    public Album queryAlbum(String id) {
        return albumService.queryAlbum(id);
    }

    /**
     * 添加一条专辑信息
     *
     * @param multipartFile 上传工具类
     * @param album         吉祥妙音实体类
     * @param session       session作用域
     * @return json字符串
     * @throws IOException
     */
    @RequestMapping("/insert.do")
    @ResponseBody
    public String insert(@RequestParam(value = "fileName") MultipartFile multipartFile, Album album, HttpSession session) throws IOException {
        String path = "/view/main/album";
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
        album.setId(UUID.randomUUID().toString().replace("-", ""));
        album.setCorverImg(path + "/" + multipartFile.getOriginalFilename());
        albumService.insert(album);
        return "ok";
    }

    /**
     * 添加一条专辑章节
     *
     * @param multipartFile 上传工具类
     * @param album_id      专辑编号
     * @param chapter       专辑章节实体类
     */
    @RequestMapping("/insert2.do")
    @ResponseBody
    public String insert2(@RequestParam(value = "fileName") MultipartFile multipartFile, String album_id, Chapter chapter, HttpSession session) throws IOException, EncoderException {
        String path = "/view/main/chapter";
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
        chapter.setId(UUID.randomUUID().toString().replace("-", ""));
        chapter.setAudioPath(path + "/" + multipartFile.getOriginalFilename());
        // 判断文件是否存在
        File file1 = new File(realPath + "/" + multipartFile.getOriginalFilename());
        if (file1.exists()) {
            // 获取音频大小
            chapter.setSize(String.format("%.2f", file1.length() / 1024.0 / 1024.0) + "MB");
            // 获取音频时长
            Encoder encoder = new Encoder();
            MultimediaInfo info = encoder.getInfo(file1);
            long los = info.getDuration();
            String ss = los / 60000 + "分" + (los / 1000 - los / 60000 * 60) + "秒";
            chapter.setLength(ss);
        }
        chapter.setCreateTime(new Date());
        chapter.setAlbum_id(album_id);
        albumService.insert2(chapter);
        return "ok";
    }

    /**
     * 下载音频文件
     *
     * @param session  session作用域
     * @param response response作用域
     * @param fileName 文件名称
     */
    @RequestMapping("/download.do")
    public void download(HttpSession session, HttpServletResponse response, String fileName) throws IOException {
        // 获取下载文件的位置
        String path = session.getServletContext().getRealPath(fileName);
        // 设置相应头,attachment:保存到客户端本地磁盘
        response.setHeader("content-disposition", "attachment;filename=" + fileName);
        // 完成下载
        IOUtils.copy(new FileInputStream(path), response.getOutputStream());
    }
}
