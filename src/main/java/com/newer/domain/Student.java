package com.newer.domain;

import java.io.Serializable;
import java.util.List;

public class Student implements Serializable {
    private Integer stuId;
    private String StuName;

    private List<Addesss> addesss;

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return StuName;
    }

    public void setStuName(String stuName) {
        StuName = stuName;
    }

    public List<Addesss> getAddesss() {
        return addesss;
    }

    public void setAddesss(List<Addesss> addesss) {
        this.addesss = addesss;
    }
}
