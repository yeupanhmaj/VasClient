package com.example.parkingvehicle.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class KLCheckingScrap {
    @SerializedName("scaleTicket")
    @Expose
    private ScaleTicket scaleTicket;
    @SerializedName("scaleTicketPODetailList")
    @Expose
    private List<ScaleTicketPODetailList> scaleTicketPODetailList = null;
    @SerializedName("checkingScrap")
    @Expose
    private CheckingScrap checkingScrap;
    @SerializedName("vehicleModel")
    @Expose
    private Vehicle vehicleModel;
    @SerializedName("productList")
    @Expose
    private List<ProductList> productList = null;
    @SerializedName("isEdit")
    @Expose
    private Boolean isEdit;
    @SerializedName("history")
    @Expose
    private List<History> history = null;
    @SerializedName("isDaDuyet")
    @Expose
    private Boolean isDaDuyet;

    public ScaleTicket getScaleTicket() {
        return scaleTicket;
    }

    public void setScaleTicket(ScaleTicket scaleTicket) {
        this.scaleTicket = scaleTicket;
    }

    public List<ScaleTicketPODetailList> getScaleTicketPODetailList() {
        return scaleTicketPODetailList;
    }

    public void setScaleTicketPODetailList(List<ScaleTicketPODetailList> scaleTicketPODetailList) {
        this.scaleTicketPODetailList = scaleTicketPODetailList;
    }

    public CheckingScrap getCheckingScrap() {
        return checkingScrap;
    }

    public void setCheckingScrap(CheckingScrap checkingScrap) {
        this.checkingScrap = checkingScrap;
    }

    public Vehicle getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(Vehicle vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public List<ProductList> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductList> productList) {
        this.productList = productList;
    }

    public Boolean getIsEdit() {
        return isEdit;
    }

    public void setIsEdit(Boolean isEdit) {
        this.isEdit = isEdit;
    }

    public List<History> getHistory() {
        return history;
    }

    public void setHistory(List<History> history) {
        this.history = history;
    }

    public Boolean getIsDaDuyet() {
        return isDaDuyet;
    }

    public void setIsDaDuyet(Boolean isDaDuyet) {
        this.isDaDuyet = isDaDuyet;
    }

}