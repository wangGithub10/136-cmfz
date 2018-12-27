package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 吉祥妙音实体类
 */
public class Album implements Serializable {
    /**
     * 编号
     */
    private String id;
    /**
     * 标题
     */
    private String title;
    /**
     * 作者
     */
    private String author;
    /**
     * 播音
     */
    private String broadCast;
    /**
     * 集数
     */
    private String count;
    /**
     * 封面
     */
    private String corverImg;
    /**
     * 评分
     */
    private Double score;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 发布日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publicDate;
    /**
     * 内容简介
     */
    private String brife;
    /**
     * 专辑的所有章节
     */
    private List<Chapter> children;

    public Album() {
        super();
    }

    public Album(String id, String title, String author, String broadCast, String count, String corverImg, Double score, Integer status, Date publicDate, String brife, List<Chapter> children) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.broadCast = broadCast;
        this.count = count;
        this.corverImg = corverImg;
        this.score = score;
        this.status = status;
        this.publicDate = publicDate;
        this.brife = brife;
        this.children = children;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroadCast() {
        return broadCast;
    }

    public void setBroadCast(String broadCast) {
        this.broadCast = broadCast;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getCorverImg() {
        return corverImg;
    }

    public void setCorverImg(String corverImg) {
        this.corverImg = corverImg;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(Date publicDate) {
        this.publicDate = publicDate;
    }

    public String getBrife() {
        return brife;
    }

    public void setBrife(String brife) {
        this.brife = brife;
    }

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", broadCast='" + broadCast + '\'' +
                ", count='" + count + '\'' +
                ", corverImg='" + corverImg + '\'' +
                ", score=" + score +
                ", status=" + status +
                ", publicDate=" + publicDate +
                ", brife='" + brife + '\'' +
                ", children=" + children +
                '}';
    }
}
