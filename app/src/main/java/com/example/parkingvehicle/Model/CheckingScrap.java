package com.example.parkingvehicle.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class CheckingScrap implements Serializable {
    @SerializedName("checkingScrapId")
    @Expose
    private String checkingScrapId;
    @SerializedName("chekingScrapIdInt")
    @Expose
    private Integer chekingScrapIdInt;
    @SerializedName("scaleTicketId")
    @Expose
    private String scaleTicketId;
    @SerializedName("scaleTicketMobileId")
    @Expose
    private String scaleTicketMobileId;
    @SerializedName("rfid")
    @Expose
    private String rfid;
    @SerializedName("inHourGuard")
    @Expose
    private String inHourGuard;
    @SerializedName("outHourGuard")
    @Expose
    private String outHourGuard;
    @SerializedName("giaoNhan")
    @Expose
    private String giaoNhan;
    @SerializedName("vehicleNumber")
    @Expose
    private String vehicleNumber;
    @SerializedName("driverName")
    @Expose
    private Object driverName;
    @SerializedName("driverIdCard")
    @Expose
    private Object driverIdCard;
    @SerializedName("isVehicleNew")
    @Expose
    private Boolean isVehicleNew;
    @SerializedName("inGateId")
    @Expose
    private String inGateId;
    @SerializedName("outGateId")
    @Expose
    private Object outGateId;
    @SerializedName("receiveType")
    @Expose
    private Object receiveType;
    @SerializedName("user1Id")
    @Expose
    private String user1Id;
    @SerializedName("note1")
    @Expose
    private Object note1;
    @SerializedName("user2Id")
    @Expose
    private String user2Id;
    @SerializedName("user3Id")
    @Expose
    private String user3Id;
    @SerializedName("note3")
    @Expose
    private Object note3;
    @SerializedName("checkingTime")
    @Expose
    private String checkingTime;
    @SerializedName("user4Id")
    @Expose
    private String user4Id;
    @SerializedName("verifyTime")
    @Expose
    private String verifyTime;
    @SerializedName("user5Id")
    @Expose
    private String user5Id;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("actived")
    @Expose
    private Boolean actived;
    @SerializedName("isDone")
    @Expose
    private Boolean isDone;
    @SerializedName("step")
    @Expose
    private Integer step;
    @SerializedName("poMasterRegisterId")
    @Expose
    private Object poMasterRegisterId;
    @SerializedName("soMasterRegisterId")
    @Expose
    private Object soMasterRegisterId;
    @SerializedName("isLockCard")
    @Expose
    private Object isLockCard;
    @SerializedName("startCheckingTime")
    @Expose
    private Object startCheckingTime;

    public String getCheckingScrapId() {
        return checkingScrapId;
    }

    public void setCheckingScrapId(String checkingScrapId) {
        this.checkingScrapId = checkingScrapId;
    }

    public Integer getChekingScrapIdInt() {
        return chekingScrapIdInt;
    }

    public void setChekingScrapIdInt(Integer chekingScrapIdInt) {
        this.chekingScrapIdInt = chekingScrapIdInt;
    }

    public String getScaleTicketId() {
        return scaleTicketId;
    }

    public void setScaleTicketId(String scaleTicketId) {
        this.scaleTicketId = scaleTicketId;
    }

    public String getScaleTicketMobileId() {
        return scaleTicketMobileId;
    }

    public void setScaleTicketMobileId(String scaleTicketMobileId) {
        this.scaleTicketMobileId = scaleTicketMobileId;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public String getInHourGuard() {
        return inHourGuard;
    }

    public void setInHourGuard(String inHourGuard) {
        this.inHourGuard = inHourGuard;
    }

    public String getOutHourGuard() {
        return outHourGuard;
    }

    public void setOutHourGuard(String outHourGuard) {
        this.outHourGuard = outHourGuard;
    }

    public String getGiaoNhan() {
        return giaoNhan;
    }

    public void setGiaoNhan(String giaoNhan) {
        this.giaoNhan = giaoNhan;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public Object getDriverName() {
        return driverName;
    }

    public void setDriverName(Object driverName) {
        this.driverName = driverName;
    }

    public Object getDriverIdCard() {
        return driverIdCard;
    }

    public void setDriverIdCard(Object driverIdCard) {
        this.driverIdCard = driverIdCard;
    }

    public Boolean getIsVehicleNew() {
        return isVehicleNew;
    }

    public void setIsVehicleNew(Boolean isVehicleNew) {
        this.isVehicleNew = isVehicleNew;
    }

    public String getInGateId() {
        return inGateId;
    }

    public void setInGateId(String inGateId) {
        this.inGateId = inGateId;
    }

    public Object getOutGateId() {
        return outGateId;
    }

    public void setOutGateId(Object outGateId) {
        this.outGateId = outGateId;
    }

    public Object getReceiveType() {
        return receiveType;
    }

    public void setReceiveType(Object receiveType) {
        this.receiveType = receiveType;
    }

    public String getUser1Id() {
        return user1Id;
    }

    public void setUser1Id(String user1Id) {
        this.user1Id = user1Id;
    }

    public Object getNote1() {
        return note1;
    }

    public void setNote1(Object note1) {
        this.note1 = note1;
    }

    public String getUser2Id() {
        return user2Id;
    }

    public void setUser2Id(String user2Id) {
        this.user2Id = user2Id;
    }

    public String getUser3Id() {
        return user3Id;
    }

    public void setUser3Id(String user3Id) {
        this.user3Id = user3Id;
    }

    public Object getNote3() {
        return note3;
    }

    public void setNote3(Object note3) {
        this.note3 = note3;
    }

    public String getCheckingTime() {
        return checkingTime;
    }

    public void setCheckingTime(String checkingTime) {
        this.checkingTime = checkingTime;
    }

    public String getUser4Id() {
        return user4Id;
    }

    public void setUser4Id(String user4Id) {
        this.user4Id = user4Id;
    }

    public String getVerifyTime() {
        return verifyTime;
    }

    public void setVerifyTime(String verifyTime) {
        this.verifyTime = verifyTime;
    }

    public String getUser5Id() {
        return user5Id;
    }

    public void setUser5Id(String user5Id) {
        this.user5Id = user5Id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getActived() {
        return actived;
    }

    public void setActived(Boolean actived) {
        this.actived = actived;
    }

    public Boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Object getPoMasterRegisterId() {
        return poMasterRegisterId;
    }

    public void setPoMasterRegisterId(Object poMasterRegisterId) {
        this.poMasterRegisterId = poMasterRegisterId;
    }

    public Object getSoMasterRegisterId() {
        return soMasterRegisterId;
    }

    public void setSoMasterRegisterId(Object soMasterRegisterId) {
        this.soMasterRegisterId = soMasterRegisterId;
    }

    public Object getIsLockCard() {
        return isLockCard;
    }

    public void setIsLockCard(Object isLockCard) {
        this.isLockCard = isLockCard;
    }

    public Object getStartCheckingTime() {
        return startCheckingTime;
    }

    public void setStartCheckingTime(Object startCheckingTime) {
        this.startCheckingTime = startCheckingTime;
    }

}