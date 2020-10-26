package com.example.parkingvehicle.Model;

import com.google.gson.JsonElement;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import javax.annotation.Nullable;
/**
 * lớp SingleResponeMessage để lấy dữ liệu từ response message
 * với T là model
 *
 * @author  Hoang NM
 * @version 1.0
 * @since   2020-10-20
 */

public class SingleResponeMessage<T> implements Serializable {
    @SerializedName("isSuccess")
    @Expose
    private Boolean isSuccess;
    @SerializedName("item")
    @Expose
    private T item;
    @SerializedName("err")
    @Expose
    private Err err;

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public Err getErr() {
        return err;
    }

    public void setErr(Err err) {
        this.err = err;
    }

}
