package com.pzh.mall.module.domain;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/15 16:26
 * @Version 1.0
 */
public class Product implements Serializable {
    private static final long serialVersionUID = 4917842326479126732L;

    private Long id;

    private String name;

    private String pic;

    private Long brandId;

    private String brandName;

    private Long categoryId;

    private String categoryName;

    private String productNo;

    private String  attributeValue;

    private Double price;

    private String description;

    private Integer deleteStatus;

    private Integer verifyStatus;

    private Integer publishStatus;

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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Integer getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(Integer verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    public Integer getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pic='" + pic + '\'' +
                ", brandId=" + brandId +
                ", brandName='" + brandName + '\'' +
                ", categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", productNo='" + productNo + '\'' +
                ", attributeValue='" + attributeValue + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", deleteStatus=" + deleteStatus +
                ", verifyStatus=" + verifyStatus +
                ", publishStatus=" + publishStatus +
                ", sort=" + sort +
                '}';
    }
}
