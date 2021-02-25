package com.pzh.mall.module.domain;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/11/17 17:31
 * @Version 1.0
 */
public class AttributeValue {

    private Long id;

    private Long attributeId;

    private String attributeValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Long attributeId) {
        this.attributeId = attributeId;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }
}
