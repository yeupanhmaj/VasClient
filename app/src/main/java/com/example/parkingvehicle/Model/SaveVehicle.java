package com.example.parkingvehicle.Model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SaveVehicle {
    @SerializedName("TenTaiXe")
    @Expose
    private String tenTaiXe;
    @SerializedName("BienSoXe")
    @Expose
    private String bienSoXe;
    @SerializedName("CMND")
    @Expose
    private String cMND;
    @SerializedName("SelectedGate")
    @Expose
    private String selectedGate;
    @SerializedName("RFID")
    @Expose
    private String rFID;
    @SerializedName("GiaoNhan")
    @Expose
    private String giaoNhan;
    @SerializedName("Note")
    @Expose
    private String note;
    @SerializedName("DeliveryType")
    @Expose
    private Integer deliveryType;

    public String getTenTaiXe() {
        return tenTaiXe;
    }

    public void setTenTaiXe(String tenTaiXe) {
        this.tenTaiXe = tenTaiXe;
    }

    public String getBienSoXe() {
        return bienSoXe;
    }

    public void setBienSoXe(String bienSoXe) {
        this.bienSoXe = bienSoXe;
    }

    public String getCMND() {
        return cMND;
    }

    public void setCMND(String cMND) {
        this.cMND = cMND;
    }

    public String getSelectedGate() {
        return selectedGate;
    }

    public void setSelectedGate(String selectedGate) {
        this.selectedGate = selectedGate;
    }

    public String getRFID() {
        return rFID;
    }

    public void setRFID(String rFID) {
        this.rFID = rFID;
    }

    public String getGiaoNhan() {
        return giaoNhan;
    }

    public void setGiaoNhan(String giaoNhan) {
        this.giaoNhan = giaoNhan;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(Integer deliveryType) {
        this.deliveryType = deliveryType;
    }

}
