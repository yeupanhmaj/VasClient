package com.example.parkingvehicle.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ScaleTicketPODetailList implements Serializable {
    @SerializedName("scaleTicketPODetailId")
    @Expose
    private String scaleTicketPODetailId;
    @SerializedName("scaleTicketId")
    @Expose
    private String scaleTicketId;
    @SerializedName("poNumber")
    @Expose
    private Object poNumber;
    @SerializedName("poLine")
    @Expose
    private String poLine;
    @SerializedName("productCode")
    @Expose
    private String productCode;
    @SerializedName("productName")
    @Expose
    private String productName;
    @SerializedName("poQty")
    @Expose
    private Integer poQty;
    @SerializedName("unit")
    @Expose
    private Object unit;
    @SerializedName("soLuongDaNhap")
    @Expose
    private Integer soLuongDaNhap;
    @SerializedName("tyLeTrongLuong")
    @Expose
    private Double tyLeTrongLuong;
    @SerializedName("qty1")
    @Expose
    private Integer qty1;
    @SerializedName("tapChat")
    @Expose
    private Integer tapChat;
    @SerializedName("unit1")
    @Expose
    private Object unit1;
    @SerializedName("qty2")
    @Expose
    private Integer qty2;
    @SerializedName("unit2")
    @Expose
    private Object unit2;
    @SerializedName("isNoPO")
    @Expose
    private Boolean isNoPO;
    @SerializedName("isSendToSAPCompleted")
    @Expose
    private Boolean isSendToSAPCompleted;

    public String getScaleTicketPODetailId() {
        return scaleTicketPODetailId;
    }

    public void setScaleTicketPODetailId(String scaleTicketPODetailId) {
        this.scaleTicketPODetailId = scaleTicketPODetailId;
    }

    public String getScaleTicketId() {
        return scaleTicketId;
    }

    public void setScaleTicketId(String scaleTicketId) {
        this.scaleTicketId = scaleTicketId;
    }

    public Object getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(Object poNumber) {
        this.poNumber = poNumber;
    }

    public String getPoLine() {
        return poLine;
    }

    public void setPoLine(String poLine) {
        this.poLine = poLine;
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

    public Integer getPoQty() {
        return poQty;
    }

    public void setPoQty(Integer poQty) {
        this.poQty = poQty;
    }

    public Object getUnit() {
        return unit;
    }

    public void setUnit(Object unit) {
        this.unit = unit;
    }

    public Integer getSoLuongDaNhap() {
        return soLuongDaNhap;
    }

    public void setSoLuongDaNhap(Integer soLuongDaNhap) {
        this.soLuongDaNhap = soLuongDaNhap;
    }

    public Double getTyLeTrongLuong() {
        return tyLeTrongLuong;
    }

    public void setTyLeTrongLuong(Double tyLeTrongLuong) {
        this.tyLeTrongLuong = tyLeTrongLuong;
    }

    public Integer getQty1() {
        return qty1;
    }

    public void setQty1(Integer qty1) {
        this.qty1 = qty1;
    }

    public Integer getTapChat() {
        return tapChat;
    }

    public void setTapChat(Integer tapChat) {
        this.tapChat = tapChat;
    }

    public Object getUnit1() {
        return unit1;
    }

    public void setUnit1(Object unit1) {
        this.unit1 = unit1;
    }

    public Integer getQty2() {
        return qty2;
    }

    public void setQty2(Integer qty2) {
        this.qty2 = qty2;
    }

    public Object getUnit2() {
        return unit2;
    }

    public void setUnit2(Object unit2) {
        this.unit2 = unit2;
    }

    public Boolean getIsNoPO() {
        return isNoPO;
    }

    public void setIsNoPO(Boolean isNoPO) {
        this.isNoPO = isNoPO;
    }

    public Boolean getIsSendToSAPCompleted() {
        return isSendToSAPCompleted;
    }

    public void setIsSendToSAPCompleted(Boolean isSendToSAPCompleted) {
        this.isSendToSAPCompleted = isSendToSAPCompleted;
    }

}
