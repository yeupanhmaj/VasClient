package com.example.parkingvehicle.ui.BaoVe;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.parkingvehicle.Model.AcctionMessage;
import com.example.parkingvehicle.Model.Data;
import com.example.parkingvehicle.Model.ResponseMessage;
import com.example.parkingvehicle.Model.SaveVehicle;
import com.example.parkingvehicle.R;
import com.example.parkingvehicle.interfaces.APIClient;
import com.example.parkingvehicle.interfaces.APIInterface;
import com.example.parkingvehicle.ui.WareHouse;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReadNFCActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView textView, tv_ThongBao;
    private ImageView btnBack;
    private String txtPlateNumber, txtNameDriver, txtCMND, txtSelectedGate, txtReceived, txtNote, userid;
    private NfcAdapter mAdapter;
    private PendingIntent mPendingIntent;
    private NdefMessage mNdefPushMessage;
    private AlertDialog mDialog;
    private APIInterface apiInterface;
    private List<Tag> mTags = new ArrayList<>();
    private String thongBao;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readnfc);
        toolbar = findViewById(R.id.toolbar_nfc);
        textView = toolbar.findViewById(R.id.toolbarTitle_nfc);
        btnBack = findViewById(R.id.btnBackReadNFC);
        textView.setText("QUÉT THẺ");
        tv_ThongBao = findViewById(R.id.tv_ThongBao);
        tv_ThongBao.setText(thongBao);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        resolveIntent(getIntent());
        mDialog = new AlertDialog.Builder(this).setNeutralButton("Ok", null).create();

        mAdapter = NfcAdapter.getDefaultAdapter(this);
        if (mAdapter == null) {
            showMessage(R.string.error, R.string.no_nfc);
            finish();
            return;
        }

        mPendingIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
        mNdefPushMessage = new NdefMessage(new NdefRecord[]{newTextRecord(
                "Message from NFC Reader :-)", Locale.ENGLISH, true)});
        userid = WareHouse.UserId;
        txtPlateNumber = getIntent().getStringExtra("PlateNumber");
        txtNameDriver = getIntent().getStringExtra("NameDriver");
        txtCMND = getIntent().getStringExtra("CMND");
        txtSelectedGate = getIntent().getStringExtra("SelectedGate");
        txtReceived = getIntent().getStringExtra("Received");
        txtNote = getIntent().getStringExtra("Note");
    }

    private void showMessage(int title, int message) {
        mDialog.setTitle(title);
        mDialog.setMessage(getText(message));
        mDialog.show();
    }

    private NdefRecord newTextRecord(String text, Locale locale, boolean encodeInUtf8) {
        byte[] langBytes = locale.getLanguage().getBytes(Charset.forName("US-ASCII"));

        Charset utfEncoding = encodeInUtf8 ? Charset.forName("UTF-8") : Charset.forName("UTF-16");
        byte[] textBytes = text.getBytes(utfEncoding);

        int utfBit = encodeInUtf8 ? 0 : (1 << 7);
        char status = (char) (utfBit + langBytes.length);

        byte[] data = new byte[1 + langBytes.length + textBytes.length];
        data[0] = (byte) status;
        System.arraycopy(langBytes, 0, data, 1, langBytes.length);
        System.arraycopy(textBytes, 0, data, 1 + langBytes.length, textBytes.length);

        return new NdefRecord(NdefRecord.TNF_WELL_KNOWN, NdefRecord.RTD_TEXT, new byte[0], data);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mAdapter != null) {
            if (!mAdapter.isEnabled()) {
                showWirelessSettingsDialog();
            }
            mAdapter.enableForegroundDispatch(this, mPendingIntent, null, null);
            mAdapter.enableForegroundNdefPush(this, mNdefPushMessage);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mAdapter != null) {
            mAdapter.disableForegroundDispatch(this);
            mAdapter.disableForegroundNdefPush(this);
        }
    }

    private void showWirelessSettingsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("NFC is not enabled. Please go to the wireless settings to enable it.");
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                startActivity(intent);
            }
        });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.create().show();
        return;
    }

    private void resolveIntent(Intent intent) {
        String action = intent.getAction();
        if (NfcAdapter.ACTION_TAG_DISCOVERED.equals(action)
                || NfcAdapter.ACTION_TECH_DISCOVERED.equals(action)
                || NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action)) {
            Parcelable[] rawMsgs = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
            NdefMessage[] msgs;
            if (rawMsgs != null) {
                msgs = new NdefMessage[rawMsgs.length];
                for (int i = 0; i < rawMsgs.length; i++) {
                    msgs[i] = (NdefMessage) rawMsgs[i];
                }
            } else {
                // Unknown tag type
                byte[] empty = new byte[0];
                byte[] id = intent.getByteArrayExtra(NfcAdapter.EXTRA_ID);
                Tag tag = (Tag) intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
                byte[] payload = dumpTagData(tag).getBytes();
                NdefRecord record = new NdefRecord(NdefRecord.TNF_UNKNOWN, empty, id, payload);
                NdefMessage msg = new NdefMessage(new NdefRecord[]{record});
                msgs = new NdefMessage[]{msg};
                mTags.add(tag);
            }
            // Setup the views
            //buildTagViews(msgs);
        }
    }

    String abc;

    private String dumpTagData(Tag tag) {
        StringBuilder sb = new StringBuilder();
        byte[] id = tag.getId();
        sb.append(toDec(id));
        return abc = sb.toString();
    }

    private long toDec(byte[] bytes) {
        long result = 0;
        long factor = 1;
        for (int i = 0; i < bytes.length; ++i) {
            long value = bytes[i] & 0xffl;
            result += value * factor;
            factor *= 256l;
        }
        return result;
    }


    @Override
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        resolveIntent(intent);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        final String token = "45FCC8F419313AZ559E2DED09B9AF94";
        final String key = "19ac858c-6517-45ce-a22e-095aff5cffff";
        final SaveVehicle data = new SaveVehicle();

//        data.BienSoXe = txtPlateNumber;
//        data.TenTaiXe = txtNameDriver;
//        data.CMND = txtCMND;
//        data.SelectedGate = txtSelectedGate;
//        data.GiaoNhan = txtReceived;
//        data.Note = txtNote;
//        data.RFID = 0 + abc; //Sửa lại tên Biến NFC
        data.setBienSoXe(txtPlateNumber);
        data.setTenTaiXe(txtNameDriver);
        data.setCMND(txtCMND);
        data.setSelectedGate(txtSelectedGate);
        data.setGiaoNhan(txtReceived) ;
        data.setNote(txtNote);
        data.setRFID(0 + abc); //Sửa lại tên Biến NFC
        Call<AcctionMessage> call3 = apiInterface.SaveVehicleIn(key,token, data, userid);
        call3.enqueue(new Callback<AcctionMessage>() {
            @Override
            public void onResponse(Call<AcctionMessage> call, Response<AcctionMessage> response) {
                try {
                    Log.d("TAG", response.code() + "");
                    AcctionMessage responseMessage = response.body();
                    if (responseMessage.getIsSuccess()) {
                       tv_ThongBao.setText(responseMessage.getErr().getMsgString().toString());
                    }
                    else {
                        tv_ThongBao.setText(responseMessage.getErr().getMsgString().toString());
                    }
                } catch (Exception e) {
                    tv_ThongBao.setText("Vui lòng thử lại");
                }
            }

            @Override
            public void onFailure(Call<AcctionMessage> call, Throwable t) {
                call.cancel();
            }

        });
    }
}
