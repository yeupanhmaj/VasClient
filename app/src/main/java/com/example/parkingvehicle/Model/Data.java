package com.example.parkingvehicle.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Data implements Serializable {
    @SerializedName("UserModel")
    public UserModel UserModel;
    @SerializedName("GateList")
    public List<Gate> Gate;
    @SerializedName("VehicleModel")
    public VehicleModel VehicleModel;
    @SerializedName("RFID")
    public String RFID;
    @SerializedName("TenTaiXe")
    public String TenTaiXe;
    @SerializedName("BienSoXe")
    public String BienSoXe;
    @SerializedName("CMND")
    public String CMND;
    @SerializedName("SelectedGate")
    public String SelectedGate;
    @SerializedName("GiaoNhan")
    public String GiaoNhan;
    @SerializedName("Note")
    public String Note;
    @SerializedName("DeliveryType")
    public String DeliveryType;

    /** Khu vực của GetCheckingScrap2*/
    @SerializedName("ScaleTicket")
    public ScaleTicket ScaleTicket;
    @SerializedName("CheckingScrap")
    public CheckingScrap CheckingScrap;
    @SerializedName("ScaleTicketPODetailList")
    public ArrayList<ScaleTicketPODetailList> ScaleTicketPODetailList;
    @SerializedName("ProductList")
    public ArrayList<ProductList> ProductList;
    @SerializedName("History")
    public ArrayList<History> History;
    @SerializedName("IsEdit")
    public boolean IsEdit;
    @SerializedName("IsDaDuyet")
    public boolean IsDaDuyet;
    @SerializedName("IsDuyetPKL")
    public boolean IsDuyetPKL;

    /**Khu vực XeRaInfo*/
    @SerializedName("VehicleNumber")
    public String VehicleNumber;

    /**Khu vực Kiểm liệu khi tự động duyệt*/
    @SerializedName("PhanBoData")
    public ArrayList<ScaleTicketPODetailList> PhanBoData;
    @SerializedName("VehicleCode")
    public String VehicleCode;
    @SerializedName("NumberCong")
    public String NumberCong;
    @SerializedName("container1Code")
    public String container1Code;
    @SerializedName("container2Code")
    public String container2Code;
    @SerializedName("Is20Feet")
    public boolean Is20Feet;
    @SerializedName("TruKG")
    public int TruKg;

    /**Khu vực Kiểm liệu khi có duyệt*/

    public ArrayList<com.example.parkingvehicle.Model.ScaleTicketPODetailList> getPhanBoData() {
        return PhanBoData;
    }

    public void setPhanBoData(ArrayList<com.example.parkingvehicle.Model.ScaleTicketPODetailList> phanBoData) {
        PhanBoData = phanBoData;
    }

    public String getVehicleCode() {
        return VehicleCode;
    }

    public void setVehicleCode(String vehicleCode) {
        VehicleCode = vehicleCode;
    }

    public String getNumberCong() {
        return NumberCong;
    }

    public void setNumberCong(String numberCong) {
        NumberCong = numberCong;
    }

    public String getContainer1Code() {
        return container1Code;
    }

    public void setContainer1Code(String container1Code) {
        this.container1Code = container1Code;
    }

    public String getContainer2Code() {
        return container2Code;
    }

    public void setContainer2Code(String container2Code) {
        this.container2Code = container2Code;
    }

    public boolean isIs20Feet() {
        return Is20Feet;
    }

    public void setIs20Feet(boolean is20Feet) {
        Is20Feet = is20Feet;
    }

    public int getTruKG() {
        return TruKg;
    }

    public void setTruKG(int truKG) {
        TruKg = truKG;
    }

    public int getTruPhanTram() {
        return TruPhanTram;
    }

    public void setTruPhanTram(int truPhanTram) {
        TruPhanTram = truPhanTram;
    }

    @SerializedName("TruPhanTram")
    public int TruPhanTram;










    /**Properties*/

    public String getRFID() {
        return RFID;
    }

    public void setRFID(String RFID) {
        this.RFID = RFID;
    }

    public String getTenTaiXe() {
        return TenTaiXe;
    }

    public void setTenTaiXe(String tenTaiXe) {
        TenTaiXe = tenTaiXe;
    }

    public String getBienSoXe() {
        return BienSoXe;
    }

    public void setBienSoXe(String bienSoXe) {
        BienSoXe = bienSoXe;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getSelectedGate() {
        return SelectedGate;
    }

    public void setSelectedGate(String selectedGate) {
        SelectedGate = selectedGate;
    }

    public String getGiaoNhan() {
        return GiaoNhan;
    }

    public void setGiaoNhan(String giaoNhan) {
        GiaoNhan = giaoNhan;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public String getDeliveryType() {
        return DeliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        DeliveryType = deliveryType;
    }

    public com.example.parkingvehicle.Model.ScaleTicket getScaleTicket() {
        return ScaleTicket;
    }

    public void setScaleTicket(com.example.parkingvehicle.Model.ScaleTicket scaleTicket) {
        ScaleTicket = scaleTicket;
    }

    public com.example.parkingvehicle.Model.CheckingScrap getCheckingScrap() {
        return CheckingScrap;
    }

    public void setCheckingScrap(com.example.parkingvehicle.Model.CheckingScrap checkingScrap) {
        CheckingScrap = checkingScrap;
    }

    public List<com.example.parkingvehicle.Model.ScaleTicketPODetailList> getScaleTicketPODetailList() {
        return ScaleTicketPODetailList;
    }

    public void setScaleTicketPODetailList(ArrayList<com.example.parkingvehicle.Model.ScaleTicketPODetailList> scaleTicketPODetailList) {
        ScaleTicketPODetailList = scaleTicketPODetailList;
    }

    public List<com.example.parkingvehicle.Model.ProductList> getProductList() {
        return ProductList;
    }

    public void setProductList(ArrayList<com.example.parkingvehicle.Model.ProductList> productList) {
        ProductList = productList;
    }

    public List<com.example.parkingvehicle.Model.History> getHistory() {
        return History;
    }

    public void setHistory(ArrayList<com.example.parkingvehicle.Model.History> history) {
        History = history;
    }

    public boolean isEdit() {
        return IsEdit;
    }

    public void setEdit(boolean edit) {
        IsEdit = edit;
    }

    public boolean isDaDuyet() {
        return IsDaDuyet;
    }

    public void setDaDuyet(boolean daDuyet) {
        IsDaDuyet = daDuyet;
    }

    public boolean isDuyetPKL() {
        return IsDuyetPKL;
    }

    public void setDuyetPKL(boolean duyetPKL) {
        IsDuyetPKL = duyetPKL;
    }

    public String getVehicleNumber() {
        return VehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        VehicleNumber = vehicleNumber;
    }
}
