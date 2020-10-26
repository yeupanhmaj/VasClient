package com.example.parkingvehicle.interfaces;

import com.example.parkingvehicle.Model.AcctionMessage;
import com.example.parkingvehicle.Model.CheckingScrap;
import com.example.parkingvehicle.Model.Data;
import com.example.parkingvehicle.Model.GateList;
import com.example.parkingvehicle.Model.KLCheckingScrap;
import com.example.parkingvehicle.Model.ListResponeMessage;
import com.example.parkingvehicle.Model.ResponseMessage;
import com.example.parkingvehicle.Model.SaveVehicle;
import com.example.parkingvehicle.Model.SingleResponeMessage;
import com.example.parkingvehicle.Model.User;
import com.example.parkingvehicle.Model.Vehicle;


import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIInterface {
    /**
     * Gọi API từ .net core
     *
     *
     * @author  Hoang NM
     * @version 1.0
     * @since   2020-10-20
     */
    @GET("api/user?")
    Call<SingleResponeMessage<User>> GetUser (@Header("key") String key,@Header("token") String token, @Query("id") String id, @Query("password") String password);
    @GET("api/vehicle?")
    Call<SingleResponeMessage<Vehicle>> GetVehicleInfo (@Header("key") String key, @Header("token") String token, @Query("vehicleNumber") String vehicleNumber);
    @GET("api/gatelist?")
    Call<ListResponeMessage<GateList>> GetGateList (@Header("key") String key, @Header("token") String token);
    /**
     * edit ngày 21/20/2020
    * */
    @POST("api/CheckingScrap?")
    Call<AcctionMessage> SaveVehicleIn (@Header("key") String key, @Header("token") String token, @Body SaveVehicle input, @Query("userID") String userID);
    @PUT("api/CheckingScrap/{rfid}?")
    Call<AcctionMessage> SaveVehicleOut (@Header("key") String key, @Header("token") String token,@Path(value = "rfid", encoded = true) String rfid,@Query("outGate") String outGate, @Query("userID") String userID);
    @GET("api/CheckingScrap/{rfid}")
    Call<SingleResponeMessage<CheckingScrap>> GetVehicleNumber (@Header("key") String key, @Header("token") String token, @Path(value = "rfid", encoded = true) String rfid);
    /**
     * edit ngày 21/20/2020
     * */
    @GET("api/CheckingScrap/kiemlieu/{rfid}")
    Call<SingleResponeMessage<KLCheckingScrap>> GetCheckingScrapKL (@Header("key") String key, @Header("token") String token, @Path(value = "rfid", encoded = true) String rfid);
}
