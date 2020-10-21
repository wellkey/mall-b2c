package com.pzh.mall.module.domain;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/10/21 15:32
 * @Version 1.0
 */
public class Attribute implements Serializable {
    private static final long serialVersionUID = 2186437324848557416L;

    @ApiModelProperty(value = "属性id")
    private Long id;

    @ApiModelProperty(value = "属性名")
    private String name;

    @ApiModelProperty(value = "属性列表")
    private List<String> attrList;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAttrList() {
        return attrList;
    }

    public void setAttrList(List<String> attrList) {
        this.attrList = attrList;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", attrList=" + attrList +
                ", sort=" + sort +
                '}';
    }
}
