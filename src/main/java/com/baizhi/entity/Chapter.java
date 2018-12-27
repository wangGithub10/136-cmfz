package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 专辑章节实体类
 */
public class Chapter implements Serializable {
    /**
     * 编号
     */
    private String id;
    /**
     * 章节标题
     */
    private String title;
    /**
     * 章节文件路径
     */
    private String audioPath;
    /**
     * 文件大小
     */
    private String size;
    /**
     * 音频时长
     */
    private String length;
    /**
     * 音频集数
     */
    private String times;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 吉祥妙音编号
     */
    private String album_id;

    public Chapter() {
        super();
    }

    public Chapter(String id, String title, String audioPath, String size, String length, String times, Date createTime, String album_id) {
        this.id = id;
        this.title = title;
        this.audioPath = audioPath;
        this.size = size;
        this.length = length;
        this.times = times;
        this.createTime = createTime;
        this.album_id = album_id;
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

    public String getAudioPath() {
        return audioPath;
    }

    public void setAudioPath(String audioPath) {
        this.audioPath = audioPath;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(String album_id) {
        this.album_id = album_id;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", audioPath='" + audioPath + '\'' +
                ", size='" + size + '\'' +
                ", length='" + length + '\'' +
                ", times='" + times + '\'' +
                ", createTime=" + createTime +
                ", album_id='" + album_id + '\'' +
                '}';
    }
}
