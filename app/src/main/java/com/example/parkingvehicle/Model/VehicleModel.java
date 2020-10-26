package com.example.parkingvehicle.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class VehicleModel implements Serializable {
    @SerializedName("VehicleId")
    public String VehicleId;
    @SerializedName("Type")
    public Integer Type;
    @SerializedName("TypeText")
    public String TypeText;
    @SerializedName("VehicleNumber")
    public String VehicleNumber ;
    @SerializedName("VehicleOwner")
    public String VehicleOwner;

    public String getVehicleId() {
        return VehicleId;
    }

    public void setVehicleId(String vehicleId) {
        VehicleId = vehicleId;
    }

    public Integer getType() {
        return Type;
    }

    public void setType(Integer type) {
        Type = type;
    }

    public String getTypeText() {
        return TypeText;
    }

    public void setTypeText(String typeText) {
        TypeText = typeText;
    }

    public String getVehicleNumber() {
        return VehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        VehicleNumber = vehicleNumber;
    }

    public String getVehicleOwner() {
        return VehicleOwner;
    }

    public void setVehicleOwner(String vehicleOwner) {
        VehicleOwner = vehicleOwner;
    }
}
