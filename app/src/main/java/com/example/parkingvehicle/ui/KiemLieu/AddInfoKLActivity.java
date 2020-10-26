package com.example.parkingvehicle.ui.KiemLieu;

import android.annotation.SuppressLint;
import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parkingvehicle.Model.Data;
import com.example.parkingvehicle.Model.History;
import com.example.parkingvehicle.Model.ScaleTicket;
import com.example.parkingvehicle.Model.ScaleTicketPODetailList;
import com.example.parkingvehicle.R;
import com.example.parkingvehicle.adapter.HistoryAdapter;
import com.example.parkingvehicle.adapter.ScaleTicketPODetailPageAdapter;
import com.example.parkingvehicle.interfaces.APIInterface;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AddInfoKLActivity extends AppCompatActivity {
    private ImageView btnBack;
    private Toolbar toolbar;
    private TextView tv_Toolbar, tv_MaPhieu, tv_GioVao, edtPlateNumber, edtTypeText;
    private EditText edt_TruKG, edt_TruPhanTram, edt_Note, inputContent1, inputContent2;
    private RadioButton rd_SaLan, rd_2Cont, rd_1Cont, rd_XeThuong, rd_20feet, rd_40feet;
    private RadioGroup rg_radionButton, rd_Container;
    private Button btnAddNew, btnSaveTemp, btnSave;
    private RecyclerView recyclerView, listStatusThongBao;
    private ScaleTicketPODetailPageAdapter scaleTicketPODetailPageAdapter;
    private HistoryAdapter historyAdapter;
    private ArrayList<ScaleTicketPODetailList> items;


    private ArrayList<History> itemsHistory;
    private boolean isDaDuyetPKL;
    APIInterface apiInterface;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiemlieu_themthongtinkl);
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> finish());
        toolbar = findViewById(R.id.toolbar_AddKL);
        tv_Toolbar = toolbar.findViewById(R.id.toolbarTitle_AddKL);
        tv_Toolbar.setText("Thêm thông tin kiểm liệu");

        tv_MaPhieu = findViewById(R.id.tv_MaPhieu);
        tv_GioVao = findViewById(R.id.tv_GioVao);
        edtPlateNumber = findViewById(R.id.edtPlateNumber);
        edtTypeText = findViewById(R.id.edtTypeText);
        edt_TruKG = findViewById(R.id.edt_TruKG);
        edt_TruPhanTram = findViewById(R.id.edt_TruPhanTram);
        edt_Note = findViewById(R.id.edt_Note);
        recyclerView = findViewById(R.id.ListVatTu);
        listStatusThongBao = findViewById(R.id.listStatusThongBao);
        inputContent1 = findViewById(R.id.inputContent1);
        inputContent2 = findViewById(R.id.inputContent2);


        /**RadioButton*/
        rd_SaLan = findViewById(R.id.rd_SaLan);
        rd_1Cont = findViewById(R.id.rd_1Cont);
        rd_2Cont = findViewById(R.id.rd_2Cont);
        rd_SaLan = findViewById(R.id.rd_SaLan);
        rd_XeThuong = findViewById(R.id.rd_XeThuong);
        rg_radionButton = findViewById(R.id.rg_radionButton);
        rd_Container = findViewById(R.id.rd_Container);
        rd_20feet = findViewById(R.id.rd_20feet);
        rd_40feet = findViewById(R.id.rd_40feet);

        rg_radionButton.setOnCheckedChangeListener((group, checkedId) -> {
            int id = group.getCheckedRadioButtonId();
            switch (id) {
                case R.id.rd_SaLan:
                    Toast.makeText(AddInfoKLActivity.this, "Sà lan", Toast.LENGTH_SHORT).show();
                    inputContent1.setVisibility(View.GONE);
                    inputContent2.setVisibility(View.GONE);
                    rd_Container.setVisibility(View.GONE);
                    break;
                case R.id.rd_XeThuong:
                    Toast.makeText(AddInfoKLActivity.this, "Xe thường", Toast.LENGTH_SHORT).show();
                    inputContent1.setVisibility(View.GONE);
                    inputContent2.setVisibility(View.GONE);
                    rd_Container.setVisibility(View.GONE);
                    break;
                case R.id.rd_1Cont:
                    Toast.makeText(AddInfoKLActivity.this, "Xe 1 container", Toast.LENGTH_SHORT).show();
                    inputContent2.setVisibility(View.GONE);
                    inputContent1.setVisibility(View.VISIBLE);
                    rd_Container.setVisibility(View.VISIBLE);
                    break;
                case R.id.rd_2Cont:
                    Toast.makeText(AddInfoKLActivity.this, "Xe 2 container", Toast.LENGTH_SHORT).show();
                    inputContent1.setVisibility(View.VISIBLE);
                    inputContent2.setVisibility(View.VISIBLE);
                    rd_Container.setVisibility(View.GONE);
                    break;
                default:

                    break;
            }
        });
        /**Button*/
        btnAddNew = findViewById(R.id.btnAddNew);
        btnSaveTemp = findViewById(R.id.btnSaveTemp);
        btnSave = findViewById(R.id.btnSave);
        /**GetStringExtra*/
        String RFID = getIntent().getStringExtra("RFID");
        String MaPhieu = getIntent().getStringExtra("ScaleTicketCode");
        String VehicleNumber = getIntent().getStringExtra("VehicleNumber");
        String TypeText = getIntent().getStringExtra("TypeText");
        String InHour = getIntent().getStringExtra("InHour");
        items = (ArrayList<ScaleTicketPODetailList>) getIntent().getSerializableExtra("ScaleTicketPODetailList");
        itemsHistory = (ArrayList<History>) getIntent().getSerializableExtra("History");
        ScaleTicket scaleTicket = (ScaleTicket) getIntent().getSerializableExtra("ScaleTicket");
        isDaDuyetPKL = getIntent().getBooleanExtra("DuyetPKL", false);

        tv_MaPhieu.setText(MaPhieu);
        String date = InHour.replaceAll("T"," ");
        Date temp = new Date();
        try {
            temp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS")
                    .parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String dateTemp = temp.toString();
        //long utcMillisecond = Long.parseLong(InHour.substring(InHour.indexOf("(") + 1, InHour.indexOf(")")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        tv_GioVao.setText(DateFormat.format("HH:mm - dd/MM/yyyy",temp));
        edtPlateNumber.setText(VehicleNumber);
        edtTypeText.setText(TypeText);
        String note = edt_Note.getText().toString();
        RelativeLayout tv_StatusThongBao = findViewById(R.id.tv_StatusThongBao);
        if (isDaDuyetPKL) {
            btnSave.setEnabled(false);
            btnSaveTemp.setEnabled(false);
            edt_Note.setEnabled(false);
            rd_SaLan.setEnabled(false);
            rd_1Cont.setEnabled(false);
            rd_2Cont.setEnabled(false);
            rd_SaLan.setEnabled(false);
            rd_XeThuong.setEnabled(false);
            edt_TruKG.setEnabled(false);
            edt_TruPhanTram.setEnabled(false);
            btnAddNew.setEnabled(false);
            btnAddNew.setBackground(getResources().getDrawable(R.drawable.buttonshape8));
            btnSave.setBackground(getResources().getDrawable(R.drawable.buttonshape8));
            btnSaveTemp.setBackground(getResources().getDrawable(R.drawable.buttonshape8));
        } else {
            btnSave.setEnabled(true);
            btnSaveTemp.setEnabled(true);
        }
        /**RemoveIntent*/
        getIntent().removeExtra("RFID");
        getIntent().removeExtra("ScaleTicketCode");
        getIntent().removeExtra("VehicleNumber");
        getIntent().removeExtra("TypeText");
        getIntent().removeExtra("InHour");
        getIntent().removeExtra("ScaleTicketPODetailList");
        getIntent().removeExtra("History");
        getIntent().removeExtra("DuyetPKL");
        getIntent().removeExtra("ScaleTicket");
        /**RecyclerView PO Detail*/
        if (itemsHistory.size() > 0) {
            tv_StatusThongBao.setVisibility(View.VISIBLE);
        } else {
            tv_StatusThongBao.setVisibility(View.GONE);
        }
        recyclerView.setHasFixedSize(true);
        scaleTicketPODetailPageAdapter = new ScaleTicketPODetailPageAdapter(AddInfoKLActivity.this, items, new ScaleTicketPODetailPageAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                if (!isDaDuyetPKL) {
                    items.remove(position);
                    notifyItemRemoved(position);
                }
            }

            @Override
            public void OnItemSelectd(int position, int value) {
                items.get(position).setTyLeTrongLuong((double) value);
                int sum = 0;
                int remain = 0;

                for (int i = 0; i <= position; i++) {
                    sum += items.get(i).getTyLeTrongLuong();
                }
                if (sum <= 100) {
                    remain = 100 - sum;
                } else {
                    remain = 0;
                    //items.get(position).TyLeTrongLuong -= sum - 100;
                    double temp = items.get(position).getTyLeTrongLuong();
                    temp -= sum - 100;
                    items.get(position).setTyLeTrongLuong(temp);
                    scaleTicketPODetailPageAdapter.notifyItemChanged(position);
                }
                if (position < items.size() - 1) {
                    int size = items.size() - 1 - position;
                    int ratio = remain / size;
                    int recheck = 0;
                    for (int i = position + 1; i < items.size(); i++) {
                        items.get(i).setTyLeTrongLuong((double) ratio);//TyLeTrongLuong = (double) ratio; oldcode
                        recheck += ratio;
                    }
                    if (remain > recheck) {
                        double temp = items.get(items.size() - 1).getTyLeTrongLuong();
                        temp += remain - recheck;
                        //items.get(items.size() - 1).TyLeTrongLuong += remain - recheck;
                        items.get(items.size() - 1).setTyLeTrongLuong(temp);
                    }
                    scaleTicketPODetailPageAdapter.notifyItemRangeChanged(position + 1, size);
                } else if (remain > 0) {
                    double temp = items.get(position).getTyLeTrongLuong();
                    temp += remain;
                    //items.get(position).TyLeTrongLuong += remain;
                    items.get(position).setTyLeTrongLuong(temp);
                    scaleTicketPODetailPageAdapter.notifyItemChanged(position);
                }
            }
        });
        recyclerView.setAdapter(scaleTicketPODetailPageAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), LinearLayoutManager.VERTICAL));
        ArrayList<ScaleTicketPODetailList> POLine = new ArrayList<>();
        for (int i = 0; i < POLine.size(); i++) {
            items.add(POLine.get(i));
        }
        scaleTicketPODetailPageAdapter.notifyDataSetChanged();

        /**RecyclerView Status ThongBao*/
        listStatusThongBao.setHasFixedSize(true);
        historyAdapter = new HistoryAdapter(itemsHistory) {
        };
        listStatusThongBao.setAdapter(historyAdapter);
        listStatusThongBao.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        listStatusThongBao.addItemDecoration(new DividerItemDecoration(listStatusThongBao.getContext(), 0));
        List<History> History = new ArrayList<>();
        for (int i = 0; i < History.size(); i++) {
            itemsHistory.add(History.get(i));
        }
        historyAdapter.notifyDataSetChanged();
        Data data = new Data();
        data.RFID = RFID;
        data.ScaleTicketPODetailList = items;
        data.ScaleTicket = scaleTicket;
        data.NumberCong = "";
        data.container1Code = "";
        data.container2Code = "";
        data.TruKg = 0;
        data.TruPhanTram = 0;
        data.Note = note;

        btnSave.setOnClickListener(v -> {
            data.TruKg = Integer.parseInt(edt_TruKG.getText().toString());
            data.TruPhanTram = Integer.parseInt(edt_TruPhanTram.getText().toString());
            Log.d("TAG","" + data.TruKg);
            Log.d("TAG","" + data.TruPhanTram);
        });
        btnSaveTemp.setOnClickListener(v -> {
            //listPO.get(i).;
        });

    }

    void notifyItemRemoved(int position) {
        scaleTicketPODetailPageAdapter.notifyItemRemoved(position);
        scaleTicketPODetailPageAdapter.notifyItemRangeChanged(position, items.size());
    }
}