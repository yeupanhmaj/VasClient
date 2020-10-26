package com.example.parkingvehicle.ui.BaoVe;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.parkingvehicle.Model.Data;
import com.example.parkingvehicle.Model.Gate;
import com.example.parkingvehicle.Model.GateList;
import com.example.parkingvehicle.Model.ListResponeMessage;
import com.example.parkingvehicle.Model.ResponseMessage;
import com.example.parkingvehicle.R;
import com.example.parkingvehicle.interfaces.APIClient;
import com.example.parkingvehicle.interfaces.APIInterface;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AddVehicleActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView textView, edtPlateNumber, edtTypeText,edt_NameDriver,edt_IdentityCard;
    private ImageView btnBlack;
    private Button btnReadNFC;
    private Spinner spn_Delivery, spn_Port;
    private EditText edt_Note;
    private Data data;
    APIInterface apiInterface;
    public String nameGate;
    public String gateId;
    public String gatePort,received;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle);
        toolbar = findViewById(R.id.toolbar_2);
        textView = toolbar.findViewById(R.id.toolbarTitle);
        btnBlack = findViewById(R.id.btnBack);
        btnReadNFC = findViewById(R.id.btnReadNFC);
        edtPlateNumber = findViewById(R.id.edtPlateNumber);
        edtTypeText = findViewById(R.id.edtTypeText);
        edt_NameDriver = findViewById(R.id.edt_NameDriver);
        edt_IdentityCard = findViewById(R.id.edt_IdentityCard);
        edt_Note = findViewById(R.id.edt_Note);
        spn_Delivery = findViewById(R.id.edt_Delivery);
        spn_Port = findViewById(R.id.edt_Port);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        btnBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        textView.setText("THÔNG TIN XE VÀO");
        edtPlateNumber.setText(getIntent().getStringExtra("PlateNumber"));
        edtTypeText.setText(getIntent().getStringExtra("TypeText"));
        final String token = "45FCC8F419313AZ559E2DED09B9AF94";
        final String key = "19ac858c-6517-45ce-a22e-095aff5cffff";
        final ArrayList list = new ArrayList<>();

        Call<ListResponeMessage<GateList>> call3 = apiInterface.GetGateList(key,token);
        call3.enqueue(new Callback<ListResponeMessage<GateList>>() {
            @Override
            public void onResponse(Call<ListResponeMessage<GateList>> call, Response<ListResponeMessage<GateList>> response) {
                Log.d("TAG", response.code() + "");
                ListResponeMessage<GateList> responseMessage = response.body();
                if(!responseMessage.getIsSuccess()){
                    return;
                }
                TypeToken<List<Gate>> token = new TypeToken<List<Gate>>() {};
                Gson gson = new Gson();

                final List<GateList> gateList = responseMessage.getData();
                if (gateList == null) {
                    return;
                }
                for (int i = 0; i < gateList.size(); i++)
                {
                    nameGate = gateList.get(i).getGateName();
                    gateId = gateList.get(i).getGateId();

                    list.add(nameGate);
                    Log.d("CheckGate",nameGate);
                }
                ArrayAdapter adapter = new ArrayAdapter(AddVehicleActivity.this, android.R.layout.simple_spinner_item,list);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spn_Port.setAdapter(adapter);
                spn_Port.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        gatePort = gateList.get(position).getGateId();
                    }


                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }

            @Override
            public void onFailure(Call<ListResponeMessage<GateList>> call, Throwable t) {
            }
        });
        final List<String> list_1 = new ArrayList<>();
        list_1.add("giao");
        list_1.add("nhan");
        list_1.add("chuyen");
        ArrayAdapter adapter = new ArrayAdapter(AddVehicleActivity.this, android.R.layout.simple_spinner_item,list_1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_Delivery.setAdapter(adapter);
        spn_Delivery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                received = list_1.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnReadNFC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String plateNumber = edtPlateNumber.getText().toString();
                String note = edt_Note.getText().toString();
                String namedriver = edt_NameDriver.getText().toString();
                String identitycard = edt_IdentityCard.getText().toString();
                Bundle bundle = new Bundle();
                Intent intent = new Intent(AddVehicleActivity.this,ReadNFCActivity.class);
                intent.putExtras(bundle);
                intent.putExtra("PlateNumber",plateNumber);
                intent.putExtra("NameDriver",namedriver);
                intent.putExtra("CMND",identitycard);
                intent.putExtra("SelectedGate",gatePort);
                intent.putExtra("Received",received);
                intent.putExtra("Note",note);
                startActivity(intent);
                finish();
            }
        });
    }
}
