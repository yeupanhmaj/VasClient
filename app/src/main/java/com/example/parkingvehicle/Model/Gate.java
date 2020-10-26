package com.example.parkingvehicle.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Gate implements Serializable {

    @SerializedName("GateId")
    public String GateId;
    @SerializedName("GateName")
    public String GateName;

    public Gate(String gateId, String gateName) {
        GateId = gateId;
        GateName = gateName;
    }

    public Gate(String gateName) {
        GateName = gateName;
    }

    public String getGateId() {
        return GateId;
    }

    public void setGateId(String gateId) {
        GateId = gateId;
    }

    public String getGateName() {
        return GateName;
    }

    public void setGateName(String gateName) {
        GateName = gateName;
    }
}
