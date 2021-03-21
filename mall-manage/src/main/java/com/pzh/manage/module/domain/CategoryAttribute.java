package com.pzh.manage.module.domain;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/11/17 10:23
 * @Version 1.0
 */
public class CategoryAttribute implements Serializable {

    private static final long serialVersionUID = -4415443679426565185L;

    private String categoryStr;

    private Long categoryId;

    private String attributeName;

    public String getCategoryStr() {
        return categoryStr;
    }

    public void setCategoryStr(String categoryStr) {
        this.categoryStr = categoryStr;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }
}
