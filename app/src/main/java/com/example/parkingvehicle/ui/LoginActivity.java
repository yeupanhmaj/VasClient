package com.example.parkingvehicle.ui;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.parkingvehicle.Model.Data;
import com.example.parkingvehicle.Model.ResponseMessage;
import com.example.parkingvehicle.Model.SingleResponeMessage;
import com.example.parkingvehicle.Model.User;
import com.example.parkingvehicle.Model.UserModel;
import com.example.parkingvehicle.R;
import com.example.parkingvehicle.interfaces.APIClient;
import com.example.parkingvehicle.interfaces.APIInterface;
import com.example.parkingvehicle.ui.BaoVe.ConfigActivity;
import com.example.parkingvehicle.ui.BaoVe.MainActivity;
import com.example.parkingvehicle.ui.KiemLieu.KLMainActivity;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    APIInterface apiInterface;
    EditText edtUsername, edtPassword;
    TextView textView;
    Button btnLogin, btnConfig;
    public static String Url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TranferData tranferData = TranferData.getInstance(LoginActivity.this);
        Url = tranferData.getData("Dev", WareHouse.UrlOrgin);
        WareHouse.Url = Url;
        textView = findViewById(R.id.responseText);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnConfig = findViewById(R.id.btnConfig);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(v -> {
            apiInterface = APIClient.getClient().create(APIInterface.class);
            final String token = "45FCC8F419313AZ559E2DED09B9AF94";
            final String key = "19ac858c-6517-45ce-a22e-095aff5cffff";
            final String txtUsername = edtUsername.getText().toString();
            final String txtPassword = edtPassword.getText().toString();
            Call<SingleResponeMessage<User>> call3 = apiInterface.GetUser(key,token,txtUsername, txtPassword);
            call3.enqueue(new Callback<SingleResponeMessage<User>>() {
                @Override
                public void onResponse(Call<SingleResponeMessage<User>> call, Response<SingleResponeMessage<User>> response) {
                    try {
                        Log.d("TAG", response.code() + "");
                        SingleResponeMessage<User> responseMessage = response.body();
                        if (!responseMessage.getIsSuccess()) {
                            textView.setText(responseMessage.getErr().getMsgString().toString());
                            edtUsername.setText("");
                            edtPassword.setText("");
                            return;
                        }
                        User user = new User();
                        User login = response.body().getItem();
                        if (login == null) {
                            Toast.makeText(getApplication(),response.body().getErr().getMsgString().toString(),Toast.LENGTH_LONG).show();
                            return;
                        }
                        if(login.getRoldCode().equals("BAOVE"))
                        {
                            Intent i = new Intent(LoginActivity.this, MainActivity.class);
                            Animatoo.animateZoom(LoginActivity.this);
                            finish();
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("UserForModel", login);
                            // shared references
                            i.putExtras(bundle);
                            i.putExtra("FullName", login.getFullName());
                            i.putExtra("Rolename", login.getRoldCode());
                            i.putExtra("UserId", login.getUserId());
                            startActivity(i);
                            finish();
                        }
                        else if (login.getRoldCode().equals("KIEMLIEU"))
                        {
                            Intent i = new Intent(LoginActivity.this, KLMainActivity.class);
                            Animatoo.animateZoom(LoginActivity.this);
                            finish();
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("UserForModel", login);
                            // shared references
                            i.putExtras(bundle);
                            i.putExtra("FullName", login.getFullName());
                            i.putExtra("Rolename", login.getRoldCode());
                            i.putExtra("UserId", login.getUserId());
                            startActivity(i);
                            finish();
                        }


                    } catch (Exception e) {
                        textView.setText("Vui lòng thử lại");
                        edtUsername.setText("");
                        edtPassword.setText("");
                    }
                }

                @Override
                public void onFailure(Call<SingleResponeMessage<User>> call, Throwable t) {
                    textView.setText("Vui lòng thử lại");
                    call.cancel();
                }
            });
        });
        btnConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ConfigActivity.class);
                startActivity(intent);
            }
        });
    }
}
