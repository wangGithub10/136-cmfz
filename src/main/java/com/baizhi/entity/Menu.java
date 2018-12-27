package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 菜单实体类
 */
public class Menu implements Serializable {
    /**
     * 编号
     */
    private String id;
    /**
     * 标题
     */
    private String title;
    /**
     * 图片路径
     */
    private String iconCls;
    /**
     * 跳转地址
     */
    private String href;
    /**
     * 父级类别编号
     */
    private String parntId;
    /**
     * 排序用到
     */
    private String content;
    /**
     * 所有的一级标题的二级标题
     */
    private List<Menu> menus;

    public Menu() {
        super();
    }

    public Menu(String id, String title, String iconCls, String href, String parntId, String content, List<Menu> menus) {
        this.id = id;
        this.title = title;
        this.iconCls = iconCls;
        this.href = href;
        this.parntId = parntId;
        this.content = content;
        this.menus = menus;
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

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getParntId() {
        return parntId;
    }

    public void setParntId(String parntId) {
        this.parntId = parntId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", href='" + href + '\'' +
                ", parntId='" + parntId + '\'' +
                ", content='" + content + '\'' +
                ", menus=" + menus +
                '}';
    }
}
