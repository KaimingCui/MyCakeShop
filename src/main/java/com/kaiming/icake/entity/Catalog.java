package com.kaiming.icake.entity;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private Integer id;
    private String title;
    private Integer pid;
    private String info;

    private List<Catalog> children = new ArrayList<Catalog>();

    @Override
    public String toString() {
        return "Catalog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", pid=" + pid +
                ", info='" + info + '\'' +
                ", children=" + children +
                '}';
    }

    public List<Catalog> getChildren() {
        return children;
    }

    public void setChildren(List<Catalog> children) {
        this.children = children;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
