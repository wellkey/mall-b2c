package com.pzh.mall.module.domain;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/10/21 15:23
 * @Version 1.0
 */
public class Category implements Serializable {
    private static final long serialVersionUID = -9096946273042637057L;

    @ApiModelProperty(value = "分类id")
    private Long id;

    @ApiModelProperty(value = "分类名")
    private String name;

    @ApiModelProperty(value = "分类层级")
    private Integer level;

    @ApiModelProperty(value = "单位名称")
    private String unit;

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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", unit='" + unit + '\'' +
                ", sort=" + sort +
                '}';
    }
}
