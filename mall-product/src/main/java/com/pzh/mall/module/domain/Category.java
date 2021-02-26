package com.pzh.mall.module.domain;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/10/21 15:23
 * @Version 1.0
 */
public class Category implements Serializable {
    private static final long serialVersionUID = -9096946273042637057L;

    private Long id;

    private String name;

    private Long parId;

    private Integer level;

    private String unit;

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

    public Long getParId() {
        return parId;
    }

    public void setParId(Long parId) {
        this.parId = parId;
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

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parId=" + parId +
                ", level=" + level +
                ", unit='" + unit + '\'' +
                '}';
    }
}
