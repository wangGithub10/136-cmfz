package com.baizhi.entity;

public class Emp {
    private Integer id;
    private String name;
    private String classz;

    public Emp() {
        super();
    }

    public Emp(Integer id, String name, String classz) {
        this.id = id;
        this.name = name;
        this.classz = classz;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassz() {
        return classz;
    }

    public void setClassz(String classz) {
        this.classz = classz;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classz='" + classz + '\'' +
                '}';
    }
}
