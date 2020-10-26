package com.example.parkingvehicle.Model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AcctionMessage {
    @SerializedName("isSuccess")
    @Expose
    private Boolean isSuccess;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("err")
    @Expose
    private Err err;

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Err getErr() {
        return err;
    }

    public void setErr(Err err) {
        this.err = err;
    }

}