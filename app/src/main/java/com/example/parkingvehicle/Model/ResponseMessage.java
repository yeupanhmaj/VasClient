package com.example.parkingvehicle.Model;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import javax.annotation.Nullable;


public class ResponseMessage implements Serializable {
    @SerializedName("IsSuccess")
    public boolean IsSuccess;
    @SerializedName("Message")
    public String Message;
    @SerializedName("Data")
    @Nullable
    public JsonElement Data;

    public boolean isSuccess() {
        return IsSuccess;
    }

    public void setSuccess(boolean success) {
        IsSuccess = success;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
