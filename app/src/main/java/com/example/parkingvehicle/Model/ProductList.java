package com.example.parkingvehicle.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProductList implements Serializable {
    @SerializedName("productId")
    @Expose
    private String productId;
    @SerializedName("productCode")
    @Expose
    private String productCode;
    @SerializedName("productName")
    @Expose
    private String productName;
    @SerializedName("unitCode")
    @Expose
    private Object unitCode;
    @SerializedName("minSingleWeight")
    @Expose
    private Integer minSingleWeight;
    @SerializedName("maxSingleWeight")
    @Expose
    private Integer maxSingleWeight;
    @SerializedName("isSAPData")
    @Expose
    private Boolean isSAPData;
    @SerializedName("createdTime")
    @Expose
    private String createdTime;
    @SerializedName("lastEditedTime")
    @Expose
    private String lastEditedTime;
    @SerializedName("actived")
    @Expose
    private Boolean actived;
    @SerializedName("isShowMobile")
    @Expose
    private Boolean isShowMobile;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Object getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(Object unitCode) {
        this.unitCode = unitCode;
    }

    public Integer getMinSingleWeight() {
        return minSingleWeight;
    }

    public void setMinSingleWeight(Integer minSingleWeight) {
        this.minSingleWeight = minSingleWeight;
    }

    public Integer getMaxSingleWeight() {
        return maxSingleWeight;
    }

    public void setMaxSingleWeight(Integer maxSingleWeight) {
        this.maxSingleWeight = maxSingleWeight;
    }

    public Boolean getIsSAPData() {
        return isSAPData;
    }

    public void setIsSAPData(Boolean isSAPData) {
        this.isSAPData = isSAPData;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getLastEditedTime() {
        return lastEditedTime;
    }

    public void setLastEditedTime(String lastEditedTime) {
        this.lastEditedTime = lastEditedTime;
    }

    public Boolean getActived() {
        return actived;
    }

    public void setActived(Boolean actived) {
        this.actived = actived;
    }

    public Boolean getIsShowMobile() {
        return isShowMobile;
    }

    public void setIsShowMobile(Boolean isShowMobile) {
        this.isShowMobile = isShowMobile;
    }

}