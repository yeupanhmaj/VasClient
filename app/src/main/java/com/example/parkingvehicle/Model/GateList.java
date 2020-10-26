package com.example.parkingvehicle.Model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GateList {
    @SerializedName("gateId")
    @Expose
    private String gateId;
    @SerializedName("gateName")
    @Expose
    private String gateName;

    public String getGateId() {
        return gateId;
    }

    public void setGateId(String gateId) {
        this.gateId = gateId;
    }

    public String getGateName() {
        return gateName;
    }

    public void setGateName(String gateName) {
        this.gateName = gateName;
    }
}
