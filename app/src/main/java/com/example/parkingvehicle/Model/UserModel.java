package com.example.parkingvehicle.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserModel implements Serializable {
    @SerializedName("UserId")
    public String UserId;
    @SerializedName("FullName")
    public String FullName;
    @SerializedName("UserName")
    public String UserName;
    @SerializedName("PasswordEnscrypt")
    public String PasswordEnscrypt;
    @SerializedName("RoldCode")
    public String RoldCode;
    @SerializedName("CreatedTime")
    public String CreatedTime;
    @SerializedName("LastEditedTime")
    public String LastEditedTime;
    @SerializedName("DrawerToLoad")
    public String DrawerToLoad;
    @SerializedName("RoleName")
    public String RoleName;
    @SerializedName("Actived")
    public boolean Actived;



    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPasswordEnscrypt() {
        return PasswordEnscrypt;
    }

    public void setPasswordEnscrypt(String passwordEnscrypt) {
        PasswordEnscrypt = passwordEnscrypt;
    }

    public String getRoldCode() {
        return RoldCode;
    }

    public void setRoldCode(String roldCode) {
        RoldCode = roldCode;
    }

    public String getCreatedTime() {
        return CreatedTime;
    }

    public void setCreatedTime(String createdTime) {
        CreatedTime = createdTime;
    }

    public String getLastEditedTime() {
        return LastEditedTime;
    }

    public void setLastEditedTime(String lastEditedTime) {
        LastEditedTime = lastEditedTime;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String roleName) {
        RoleName = roleName;
    }

    public boolean isActived() {
        return Actived;
    }

    public void setActived(boolean actived) {
        Actived = actived;
    }

    public String getDrawerToLoad() {
        return DrawerToLoad;
    }

    public void setDrawerToLoad(String drawerToLoad) {
        DrawerToLoad = drawerToLoad;
    }
}



