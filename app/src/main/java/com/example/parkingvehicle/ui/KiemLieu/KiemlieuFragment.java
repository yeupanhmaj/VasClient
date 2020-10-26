package com.example.parkingvehicle.ui.KiemLieu;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.parkingvehicle.Model.Data;
import com.example.parkingvehicle.Model.KLCheckingScrap;
import com.example.parkingvehicle.Model.ResponseMessage;
import com.example.parkingvehicle.Model.ScaleTicketPODetailList;
import com.example.parkingvehicle.Model.SingleResponeMessage;
import com.example.parkingvehicle.R;
import com.example.parkingvehicle.interfaces.APIClient;
import com.example.parkingvehicle.interfaces.APIInterface;
import com.example.parkingvehicle.ui.WareHouse;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KiemlieuFragment extends Fragment {
   private APIInterface apiInterface;
   private TextView tv_ThongBaoKiemLieu;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_kiemlieu_kiemlieu, container, false);
        String RFID = getActivity().getIntent().getStringExtra("RFIDKL");
        apiInterface = APIClient.getClient().create(APIInterface.class);
        tv_ThongBaoKiemLieu = root.findViewById(R.id.tv_ThongBaoKiemLieu);
        final String token = "45FCC8F419313AZ559E2DED09B9AF94";
        final String key = "19ac858c-6517-45ce-a22e-095aff5cffff";
        String UserId = WareHouse.UserId;
        if (RFID != null) {
            Call<SingleResponeMessage<KLCheckingScrap>> call3 = apiInterface.GetCheckingScrapKL(key , token, RFID);
            call3.enqueue(new Callback<SingleResponeMessage<KLCheckingScrap>>() {
                    @Override
                    public void onResponse(Call<SingleResponeMessage<KLCheckingScrap>> call, Response<SingleResponeMessage<KLCheckingScrap>> response) {
                        try {
                            Log.d("TAG", response.code() + "");
                            SingleResponeMessage<KLCheckingScrap> responseMessage = response.body();
                            if (!responseMessage.getIsSuccess()) {
                                tv_ThongBaoKiemLieu.setText(responseMessage.getErr().getMsgString().toString());
                                return;
                            }

//                            Gson gson = new Gson();
//                            Data data = gson.fromJson(responseMessage.getItem(), Data.class);
                            KLCheckingScrap data = responseMessage.getItem();
                            Intent intent = new Intent(getActivity().getApplicationContext(), AddInfoKLActivity.class);
                            intent.putExtra("RFID",RFID);
                            intent.putExtra("ScaleTicket",data.getScaleTicket());
                            intent.putExtra("ScaleTicketCode", data.getScaleTicket().getScaleTicketCode());
                            intent.putExtra("VehicleNumber", data.getVehicleModel().getVehicleNumber());
                            intent.putExtra("TypeText", data.getVehicleModel().getType());
                            intent.putExtra("InHour", data.getCheckingScrap().getInHourGuard());
                            intent.putExtra("ScaleTicketPODetailList", (Serializable) data.getScaleTicketPODetailList());
                            intent.putExtra("History", (Serializable) data.getHistory());
                            intent.putExtra("DuyetPKL",data.getIsDaDuyet());
                            startActivity(intent);
                            getActivity().getIntent().removeExtra("RFIDKL");


                        } catch (Exception e) {
                            Toast.makeText(getContext(), "Thông báo: " + e, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<SingleResponeMessage<KLCheckingScrap>> call, Throwable t) {
                        tv_ThongBaoKiemLieu.setText("Vui lòng thử lại");
                        call.cancel();
                    }
                });
        } else {

        }
        return root;
    }
}
