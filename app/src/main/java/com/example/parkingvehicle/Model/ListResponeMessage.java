package com.example.parkingvehicle.Model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
public class ListResponeMessage<T> {
    @SerializedName("isSuccess")
    @Expose
    private Boolean isSuccess;
    @SerializedName("totalRecords")
    @Expose
    private Integer totalRecords;
    @SerializedName("data")
    @Expose
    private List<T> data = null;
    @SerializedName("err")
    @Expose
    private Err err;

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Err getErr() {
        return err;
    }

    public void setErr(Err err) {
        this.err = err;
    }

}
