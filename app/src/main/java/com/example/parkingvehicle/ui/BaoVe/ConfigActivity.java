package com.example.parkingvehicle.ui.BaoVe;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.parkingvehicle.Model.ResponseMessage;
import com.example.parkingvehicle.Model.SingleResponeMessage;
import com.example.parkingvehicle.Model.User;
import com.example.parkingvehicle.R;
import com.example.parkingvehicle.interfaces.APIClient;
import com.example.parkingvehicle.interfaces.APIInterface;
import com.example.parkingvehicle.ui.LoginActivity;
import com.example.parkingvehicle.ui.TranferData;
import com.example.parkingvehicle.ui.WareHouse;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ConfigActivity extends AppCompatActivity {
    public static String txtUrl;
    private Button btnConfirm, btnTest;
    private EditText edtURLIP;
    private TextView tvShowDialog;
    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_host);
        edtURLIP = findViewById(R.id.edt_ip);
        edtURLIP.setText(WareHouse.Url);
        btnConfirm = findViewById(R.id.btn_Confirm);
        btnTest = findViewById(R.id.btn_Test);
        tvShowDialog = findViewById(R.id.showDialog);
        btnTest.setOnClickListener(v -> {
            txtUrl = edtURLIP.getText().toString();
            WareHouse.Url = txtUrl;
            apiInterface = APIClient.getClient().create(APIInterface.class);
            final String token = "45FCC8F419313AZ559E2DED09B9AF94";
            final String key = "19ac858c-6517-45ce-a22e-095aff5cffff";
            Call<SingleResponeMessage<User>> call3 = apiInterface.GetUser(
                    "19ac858c-6517-45ce-a22e-095aff5cffff",
                    "45FCC8F419313AZ559E2DED09B9AF94",
                    "baove",
                    "123");
            call3.enqueue(new Callback<SingleResponeMessage<User>>() {
                @Override
                public void onResponse(Call<SingleResponeMessage<User>> call, Response<SingleResponeMessage<User>> response) {
                    try
                    {
                        Log.d("TAG", response.code() + "");
                        SingleResponeMessage<User> responseMessage = response.body();
                        if(responseMessage.getIsSuccess())
                        {
                            tvShowDialog.setText("Kết nối thành công");
                        }
                    }
                    catch (Exception e) {

                        tvShowDialog.setText("Vui lòng thử lại " + e.getMessage().toString());
                    }
                }

                @Override
                public void onFailure(Call<SingleResponeMessage<User>> call, Throwable t) {
                    tvShowDialog.setText("Vui lòng cấu hình lại");
                    call.cancel();
                }

            });
        });
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtUrl = edtURLIP.getText().toString();
                WareHouse.Url = txtUrl;
                TranferData tranferData = TranferData.getInstance(ConfigActivity.this);
                tranferData.saveData("Dev", WareHouse.Url);
                Toast.makeText(ConfigActivity.this,"Đã lưu vào trong cache",Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(ConfigActivity.this, LoginActivity.class);
                finish();
                //startActivity(intent);
            }
        });
    }
}
