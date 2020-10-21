package com.pzh.mall.module.domain;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/10/21 15:09
 * @Version 1.0
 */
public class Brand implements Serializable {
    private static final long serialVersionUID = 3761421851521171783L;

    @ApiModelProperty(value = "品牌id")
    private Long id;

    @ApiModelProperty(value = "品牌名")
    private String name;

    @ApiModelProperty(value = "品牌logo")
    private String logo;


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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                ", sort=" + sort +
                '}';
    }
}
