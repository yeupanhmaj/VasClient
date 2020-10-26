package com.example.parkingvehicle.ui;

import android.content.Context;
import android.content.SharedPreferences;

public class TranferData {

    private static TranferData tranferData;
    private SharedPreferences sharedPreferences;

    public static TranferData getInstance(Context context) {
        if (tranferData == null) {
            tranferData = new TranferData(context);
        }
        return tranferData;
    }

    private TranferData(Context context) {
        sharedPreferences = context.getSharedPreferences("Ref",Context.MODE_PRIVATE);
    }

    public void saveData(String key,String value) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor .putString(key, value);
        prefsEditor.apply();
        prefsEditor.commit();
    }

    public String getData(String key,String defValue) {
        if (sharedPreferences!= null) {
            return sharedPreferences.getString(key,defValue);
        }
        return "";
    }

}
