package com.example.parkingvehicle.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class History implements Serializable {
    @SerializedName("historyType")
    @Expose
    private String historyType;
    @SerializedName("createDate")
    @Expose
    private String createDate;
    @SerializedName("fullName")
    @Expose
    private String fullName;
    @SerializedName("historyNote")
    @Expose
    private String historyNote;

    public String getHistoryType() {
        return historyType;
    }

    public void setHistoryType(String historyType) {
        this.historyType = historyType;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getHistoryNote() {
        return historyNote;
    }

    public void setHistoryNote(String historyNote) {
        this.historyNote = historyNote;
    }

}