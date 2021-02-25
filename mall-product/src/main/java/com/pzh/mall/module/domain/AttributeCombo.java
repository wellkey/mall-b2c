package com.pzh.mall.module.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/11/23 10:53
 * @Version 1.0
 */
public class AttributeCombo implements Serializable {

    private static final long serialVersionUID = -6182077197942844948L;

    private Long attributeKeyId;

    private String attributeKeyValue;

    private List<AttributeValue> valueList;

    public Long getAttributeKeyId() {
        return attributeKeyId;
    }

    public void setAttributeKeyId(Long attributeKeyId) {
        this.attributeKeyId = attributeKeyId;
    }

    public String getAttributeKeyValue() {
        return attributeKeyValue;
    }

    public void setAttributeKeyValue(String attributeKeyValue) {
        this.attributeKeyValue = attributeKeyValue;
    }

    public List<AttributeValue> getValueList() {
        return valueList;
    }

    public void setValueList(List<AttributeValue> valueList) {
        this.valueList = valueList;
    }
}
