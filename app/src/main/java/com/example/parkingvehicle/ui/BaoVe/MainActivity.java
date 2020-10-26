package com.example.parkingvehicle.ui.BaoVe;

import android.annotation.SuppressLint;
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
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.parkingvehicle.R;
import com.example.parkingvehicle.interfaces.APIInterface;
import com.example.parkingvehicle.ui.LoginActivity;
import com.example.parkingvehicle.ui.WareHouse;
import com.google.android.material.navigation.NavigationView;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import okhttp3.internal.framed.Header;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private AppBarConfiguration mAppBarConfiguration;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;
    private TextView tv;
    private Header header;
    private TextView username, roles;
    private APIInterface apiInterface;
    private Button btnLogOut;
    private String userid;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar_3);
        TextView tv = toolbar.findViewById(R.id.toolbarMain);
        btnLogOut = findViewById(R.id.btnLogout);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

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

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawerOpen, R.string.drawerClose);
        drawerLayout.addDrawerListener(toggle);
        View header = navigationView.getHeaderView(0);
        username = header.findViewById(R.id.userName);
        roles = header.findViewById(R.id.roles);
        username.setText(getIntent().getStringExtra("FullName"));
        roles.setText(getIntent().getStringExtra("Rolename"));
        userid = getIntent().getStringExtra("UserId");
        WareHouse.UserId = userid;
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        btnLogOut.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
        if (savedInstanceState == null) {
            //tv.setText("DANH SÁCH XE");
            //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
            //       new ListVehicleFragment()).commit();
            tv.setText("XE VÀO");
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new VehicleInFragment()).commit();
        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        toolbar = findViewById(R.id.toolbar_3);
            tv = toolbar.findViewById(R.id.toolbarMain);
            switch (menuItem.getItemId()) {
                case R.id.nav_0:
                    tv.setText("XE VÀO");
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new VehicleInFragment()).commit();
                    drawerLayout.closeDrawers();
                    break;
                case R.id.nav_1:
                    toolbar = findViewById(R.id.toolbar_3);
                    tv.setText("XE RA");
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new VehicleOutFragment()).commit();
                    drawerLayout.closeDrawers();
                    break;
                case R.id.nav_2:
                    toolbar = findViewById(R.id.toolbar_3);
                    tv.setText("DANH SÁCH XE");
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new ListVehicleFragment()).commit();
                    drawerLayout.closeDrawers();
                    break;
                case R.id.nav_3:
                    toolbar = findViewById(R.id.toolbar_3);
                    tv.setText("CẤU HÌNH");
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new PortConfigFragment()).commit();
                    drawerLayout.closeDrawers();
                default:
                    break;
        }
        return false;
    }
    private NfcAdapter mAdapter;
    private PendingIntent mPendingIntent;
    private NdefMessage mNdefPushMessage;
    private AlertDialog mDialog;
    private List<Tag> mTags = new ArrayList<>();

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        resolveIntent(intent);
        intent.putExtra("RFID", 0 + abc);
        toolbar = findViewById(R.id.toolbar_3);
        tv = toolbar.findViewById(R.id.toolbarMain);
        tv.setText("XE RA");
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new VehicleOutFragment()).commit();
    }

    private void showMessage(int title, int message) {
        mDialog.setTitle(title);
        mDialog.setMessage(getText(message));
        Toast.makeText(this, "NFC không có hỗ trợ", Toast.LENGTH_SHORT).show();
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
        }
    }

    String abc ;

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

}
