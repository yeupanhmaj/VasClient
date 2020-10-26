package com.example.parkingvehicle.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ScaleTicket implements Serializable {
    @SerializedName("scaleTicketId")
    @Expose
    private String scaleTicketId;
    @SerializedName("scaleTicketCode")
    @Expose
    private String scaleTicketCode;
    @SerializedName("scaleTicketTypeCode")
    @Expose
    private String scaleTicketTypeCode;
    @SerializedName("vehicleTypeCode")
    @Expose
    private String vehicleTypeCode;
    @SerializedName("vehicleNumber")
    @Expose
    private String vehicleNumber;
    @SerializedName("bargeNumber")
    @Expose
    private String bargeNumber;
    @SerializedName("containerCount")
    @Expose
    private String containerCount;
    @SerializedName("trailersNumber")
    @Expose
    private String trailersNumber;
    @SerializedName("inHour")
    @Expose
    private String inHour;
    @SerializedName("outHour")
    @Expose
    private String outHour;
    @SerializedName("firstWeight")
    @Expose
    private Double firstWeight;
    @SerializedName("secondWeight")
    @Expose
    private Double secondWeight;
    @SerializedName("actualWeight")
    @Expose
    private Double actualWeight;
    @SerializedName("percentReduced")
    @Expose
    private Double percentReduced;
    @SerializedName("kgReduced")
    @Expose
    private Double kgReduced;
    @SerializedName("actualWeightAfterReduction")
    @Expose
    private Double actualWeightAfterReduction;
    @SerializedName("totalReduced")
    @Expose
    private Double totalReduced;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("isTest")
    @Expose
    private Boolean isTest;
    @SerializedName("softCode")
    @Expose
    private String softCode;
    @SerializedName("firstUserId")
    @Expose
    private String firstUserId;
    @SerializedName("secondUserId")
    @Expose
    private String secondUserId;
    @SerializedName("isSendToSAPCompleted")
    @Expose
    private Boolean isSendToSAPCompleted;
    @SerializedName("isInvalidSAP")
    @Expose
    private Boolean isInvalidSAP;
    @SerializedName("invalidSAPMessage")
    @Expose
    private String invalidSAPMessage;
    @SerializedName("isXeNoiBo")
    @Expose
    private Boolean isXeNoiBo;
    @SerializedName("isDeleted")
    @Expose
    private Boolean isDeleted;
    @SerializedName("isQuaTai")
    @Expose
    private Boolean isQuaTai;
    @SerializedName("statusIP")
    @Expose
    private Boolean statusIP;
    @SerializedName("isDonTrongMin")
    @Expose
    private Boolean isDonTrongMin;
    @SerializedName("isDonTrongMax")
    @Expose
    private Boolean isDonTrongMax;
    @SerializedName("isVuotTyLeOD")
    @Expose
    private Boolean isVuotTyLeOD;
    @SerializedName("cungDuongCode")
    @Expose
    private Integer cungDuongCode;
    @SerializedName("cungDuongName")
    @Expose
    private String cungDuongName;
    @SerializedName("vehicleOwner")
    @Expose
    private String vehicleOwner;
    @SerializedName("vehicleOwnerName")
    @Expose
    private String vehicleOwnerName;
    @SerializedName("is20Feet")
    @Expose
    private Boolean is20Feet;
    @SerializedName("is40Feet")
    @Expose
    private Boolean is40Feet;
    @SerializedName("soHieuCont1")
    @Expose
    private String soHieuCont1;
    @SerializedName("soHieuCont2")
    @Expose
    private String soHieuCont2;

    public String getScaleTicketId() {
        return scaleTicketId;
    }

    public void setScaleTicketId(String scaleTicketId) {
        this.scaleTicketId = scaleTicketId;
    }

    public String getScaleTicketCode() {
        return scaleTicketCode;
    }

    public void setScaleTicketCode(String scaleTicketCode) {
        this.scaleTicketCode = scaleTicketCode;
    }

    public String getScaleTicketTypeCode() {
        return scaleTicketTypeCode;
    }

    public void setScaleTicketTypeCode(String scaleTicketTypeCode) {
        this.scaleTicketTypeCode = scaleTicketTypeCode;
    }

    public String getVehicleTypeCode() {
        return vehicleTypeCode;
    }

    public void setVehicleTypeCode(String vehicleTypeCode) {
        this.vehicleTypeCode = vehicleTypeCode;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getBargeNumber() {
        return bargeNumber;
    }

    public void setBargeNumber(String bargeNumber) {
        this.bargeNumber = bargeNumber;
    }

    public String getContainerCount() {
        return containerCount;
    }

    public void setContainerCount(String containerCount) {
        this.containerCount = containerCount;
    }

    public String getTrailersNumber() {
        return trailersNumber;
    }

    public void setTrailersNumber(String trailersNumber) {
        this.trailersNumber = trailersNumber;
    }

    public String getInHour() {
        return inHour;
    }

    public void setInHour(String inHour) {
        this.inHour = inHour;
    }

    public String getOutHour() {
        return outHour;
    }

    public void setOutHour(String outHour) {
        this.outHour = outHour;
    }

    public Double getFirstWeight() {
        return firstWeight;
    }

    public void setFirstWeight(Double firstWeight) {
        this.firstWeight = firstWeight;
    }

    public Double getSecondWeight() {
        return secondWeight;
    }

    public void setSecondWeight(Double secondWeight) {
        this.secondWeight = secondWeight;
    }

    public Double getActualWeight() {
        return actualWeight;
    }

    public void setActualWeight(Double actualWeight) {
        this.actualWeight = actualWeight;
    }

    public Double getPercentReduced() {
        return percentReduced;
    }

    public void setPercentReduced(Double percentReduced) {
        this.percentReduced = percentReduced;
    }

    public Double getKgReduced() {
        return kgReduced;
    }

    public void setKgReduced(Double kgReduced) {
        this.kgReduced = kgReduced;
    }

    public Double getActualWeightAfterReduction() {
        return actualWeightAfterReduction;
    }

    public void setActualWeightAfterReduction(Double actualWeightAfterReduction) {
        this.actualWeightAfterReduction = actualWeightAfterReduction;
    }

    public Double getTotalReduced() {
        return totalReduced;
    }

    public void setTotalReduced(Double totalReduced) {
        this.totalReduced = totalReduced;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsTest() {
        return isTest;
    }

    public void setIsTest(Boolean isTest) {
        this.isTest = isTest;
    }

    public String getSoftCode() {
        return softCode;
    }

    public void setSoftCode(String softCode) {
        this.softCode = softCode;
    }

    public String getFirstUserId() {
        return firstUserId;
    }

    public void setFirstUserId(String firstUserId) {
        this.firstUserId = firstUserId;
    }

    public String getSecondUserId() {
        return secondUserId;
    }

    public void setSecondUserId(String secondUserId) {
        this.secondUserId = secondUserId;
    }

    public Boolean getIsSendToSAPCompleted() {
        return isSendToSAPCompleted;
    }

    public void setIsSendToSAPCompleted(Boolean isSendToSAPCompleted) {
        this.isSendToSAPCompleted = isSendToSAPCompleted;
    }

    public Boolean getIsInvalidSAP() {
        return isInvalidSAP;
    }

    public void setIsInvalidSAP(Boolean isInvalidSAP) {
        this.isInvalidSAP = isInvalidSAP;
    }

    public String getInvalidSAPMessage() {
        return invalidSAPMessage;
    }

    public void setInvalidSAPMessage(String invalidSAPMessage) {
        this.invalidSAPMessage = invalidSAPMessage;
    }

    public Boolean getIsXeNoiBo() {
        return isXeNoiBo;
    }

    public void setIsXeNoiBo(Boolean isXeNoiBo) {
        this.isXeNoiBo = isXeNoiBo;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Boolean getIsQuaTai() {
        return isQuaTai;
    }

    public void setIsQuaTai(Boolean isQuaTai) {
        this.isQuaTai = isQuaTai;
    }

    public Boolean getStatusIP() {
        return statusIP;
    }

    public void setStatusIP(Boolean statusIP) {
        this.statusIP = statusIP;
    }

    public Boolean getIsDonTrongMin() {
        return isDonTrongMin;
    }

    public void setIsDonTrongMin(Boolean isDonTrongMin) {
        this.isDonTrongMin = isDonTrongMin;
    }

    public Boolean getIsDonTrongMax() {
        return isDonTrongMax;
    }

    public void setIsDonTrongMax(Boolean isDonTrongMax) {
        this.isDonTrongMax = isDonTrongMax;
    }

    public Boolean getIsVuotTyLeOD() {
        return isVuotTyLeOD;
    }

    public void setIsVuotTyLeOD(Boolean isVuotTyLeOD) {
        this.isVuotTyLeOD = isVuotTyLeOD;
    }

    public Integer getCungDuongCode() {
        return cungDuongCode;
    }

    public void setCungDuongCode(Integer cungDuongCode) {
        this.cungDuongCode = cungDuongCode;
    }

    public String getCungDuongName() {
        return cungDuongName;
    }

    public void setCungDuongName(String cungDuongName) {
        this.cungDuongName = cungDuongName;
    }

    public String getVehicleOwner() {
        return vehicleOwner;
    }

    public void setVehicleOwner(String vehicleOwner) {
        this.vehicleOwner = vehicleOwner;
    }

    public String getVehicleOwnerName() {
        return vehicleOwnerName;
    }

    public void setVehicleOwnerName(String vehicleOwnerName) {
        this.vehicleOwnerName = vehicleOwnerName;
    }

    public Boolean getIs20Feet() {
        return is20Feet;
    }

    public void setIs20Feet(Boolean is20Feet) {
        this.is20Feet = is20Feet;
    }

    public Boolean getIs40Feet() {
        return is40Feet;
    }

    public void setIs40Feet(Boolean is40Feet) {
        this.is40Feet = is40Feet;
    }

    public String getSoHieuCont1() {
        return soHieuCont1;
    }

    public void setSoHieuCont1(String soHieuCont1) {
        this.soHieuCont1 = soHieuCont1;
    }

    public String getSoHieuCont2() {
        return soHieuCont2;
    }

    public void setSoHieuCont2(String soHieuCont2) {
        this.soHieuCont2 = soHieuCont2;
    }

}
