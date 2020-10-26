package com.example.parkingvehicle.Model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * lớp SingleResponeMessage để lấy dữ liệu từ response message
 * với T là model
 *
 * @author  Hoang NM
 * @version 1.0
 * @since   2020-10-20
 */
public class Err {

    @SerializedName("msgCode")
    @Expose
    private Object msgCode;
    @SerializedName("msgString")
    @Expose
    private Object msgString;

    public Object getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(Object msgCode) {
        this.msgCode = msgCode;
    }

    public Object getMsgString() {
        return msgString;
    }

    public void setMsgString(Object msgString) {
        this.msgString = msgString;
    }

}