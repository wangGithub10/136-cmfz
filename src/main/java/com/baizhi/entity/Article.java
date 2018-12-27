package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 甘露妙宝实体类
 */
public class Article implements Serializable {
    /**
     * 编号
     */
    private String id;
    /**
     * 文章标题
     */
    private String title;
    /**
     * 文章插图
     */
    private String insertImg;
    /**
     * 文章内容
     */
    private String content;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 发布时间
     */
    private Date publishDate;
    /**
     * 上师编号
     */
    private String guru_id;

    public Article() {
        super();
    }

    public Article(String id, String title, String insertImg, String content, Integer status, Date createDate, Date publishDate, String guru_id) {
        this.id = id;
        this.title = title;
        this.insertImg = insertImg;
        this.content = content;
        this.status = status;
        this.createDate = createDate;
        this.publishDate = publishDate;
        this.guru_id = guru_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInsertImg() {
        return insertImg;
    }

    public void setInsertImg(String insertImg) {
        this.insertImg = insertImg;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getGuru_id() {
        return guru_id;
    }

    public void setGuru_id(String guru_id) {
        this.guru_id = guru_id;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", insertImg='" + insertImg + '\'' +
                ", content='" + content + '\'' +
                ", status=" + status +
                ", createDate=" + createDate +
                ", publishDate=" + publishDate +
                ", guru_id='" + guru_id + '\'' +
                '}';
    }
}
