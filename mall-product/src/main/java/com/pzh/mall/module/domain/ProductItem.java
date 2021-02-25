package com.pzh.mall.module.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/11/22 14:18
 * @Version 1.0
 */
public class ProductItem implements Serializable {

    private static final long serialVersionUID = 7222858426954784443L;

    private String productNo;

    private Long productId;

    private String productSpecs;

    private String pic;

    private BigDecimal price;

    private Long stock;

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductSpecs() {
        return productSpecs;
    }

    public void setProductSpecs(String productSpecs) {
        this.productSpecs = productSpecs;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }
}
