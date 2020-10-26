package com.example.parkingvehicle.ui.BaoVe;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.parkingvehicle.Model.AcctionMessage;
import com.example.parkingvehicle.Model.CheckingScrap;
import com.example.parkingvehicle.Model.ResponseMessage;
import com.example.parkingvehicle.Model.SingleResponeMessage;
import com.example.parkingvehicle.R;
import com.example.parkingvehicle.interfaces.APIClient;
import com.example.parkingvehicle.interfaces.APIInterface;
import com.example.parkingvehicle.ui.WareHouse;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VehicleOutFragment extends Fragment {
    APIInterface apiInterface;
    private List<Tag> mTags = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_vehicle_out, container, false);
        final TextView tv = root.findViewById(R.id.tv_ThongBaoXeRa);
        String RFID = getActivity().getIntent().getStringExtra("RFID");
        getActivity().getIntent().removeExtra("RFID");
        final String KeyConst = "19ac858c-6517-45ce-a22e-095aff5cffff";
        final String Token = "45FCC8F419313AZ559E2DED09B9AF94";
        final String UserId = WareHouse.UserId;
        apiInterface = APIClient.getClient().create(APIInterface.class);
        if (RFID != null) {
            Call<SingleResponeMessage<CheckingScrap>> call3 = apiInterface.GetVehicleNumber(KeyConst, Token, RFID);
            call3.enqueue(new Callback<SingleResponeMessage<CheckingScrap>>() {
                @Override
                public void onResponse(Call<SingleResponeMessage<CheckingScrap>> call, Response<SingleResponeMessage<CheckingScrap>> response) {
                    try {
                        Log.d("TAG", response.code() + "");
                        SingleResponeMessage<CheckingScrap> responseMessage = response.body();
                        if (responseMessage.getIsSuccess()) {
                            CheckingScrap data = responseMessage.getItem();
                            new AlertDialog.Builder(getContext())
                                    .setTitle("Xe ra")
                                    .setMessage("Xe \" " + (data.getVehicleNumber().isEmpty()?"":data.getVehicleNumber()) + " \" đang chuẩn bị ra ?")

                                    // Specifying a listener allows you to take an action before dismissing the dialog.
                                    // The dialog is automatically dismissed when a dialog button is clicked.
                                    .setPositiveButton(android.R.string.yes, (dialog, which) -> {
                                        Call<AcctionMessage> callOut = apiInterface.SaveVehicleOut(KeyConst,Token,RFID,"PORT1",UserId);
                                        callOut.enqueue(new Callback<AcctionMessage>() {
                                            @Override
                                            public void onResponse(Call<AcctionMessage> call1, Response<AcctionMessage> response1) {
                                                try {
                                                    Log.d("TAG", response1.code() + "");
                                                    AcctionMessage responseMessage = response1.body();
                                                    if (responseMessage.getIsSuccess()) {
                                                        tv.setText(responseMessage.getErr().getMsgString().toString());
                                                    } else {
                                                        tv.setText(responseMessage.getErr().getMsgString().toString());
                                                    }
                                                } catch (Exception e) {
                                                    tv.setText("Vui lòng thử lại rq2+ "+e.getMessage());
                                                    Toast.makeText(getActivity(),e.getMessage(),Toast.LENGTH_LONG).show();
                                                }
                                            }

                                            @Override
                                            public void onFailure(Call<AcctionMessage> call1, Throwable t) {
                                                tv.setText("Vui lòng thử lại rq2 + "+t.getMessage());
                                                Toast.makeText(getActivity(),t.getMessage(),Toast.LENGTH_LONG).show();
                                                call1.cancel();
                                            }

                                        });
                                    })

                                    // A null listener allows the button to dismiss the dialog and take no further action.
                                    .setNegativeButton(android.R.string.no, null)
                                    .setIcon(android.R.drawable.ic_dialog_info)
                                    .show();
                        } else {
                            tv.setText(responseMessage.getErr().getMsgString().toString());
                        }
                    } catch (Exception e) {
                        tv.setText("Vui lòng thử lại rq1");
                    }
                }

                @Override
                public void onFailure(Call<SingleResponeMessage<CheckingScrap>> call, Throwable t) {
                    tv.setText("Vui lòng thử lại");
                    call.cancel();
                }

            });
        } else {
            tv.setText("");
        }
        return root;
    }
}

