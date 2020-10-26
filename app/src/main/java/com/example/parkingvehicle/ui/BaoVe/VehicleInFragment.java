package com.example.parkingvehicle.ui.BaoVe;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import com.example.parkingvehicle.Model.Data;
import com.example.parkingvehicle.Model.ResponseMessage;
import com.example.parkingvehicle.Model.SingleResponeMessage;
import com.example.parkingvehicle.Model.Vehicle;
import com.example.parkingvehicle.Model.VehicleModel;
import com.example.parkingvehicle.R;
import com.example.parkingvehicle.interfaces.APIClient;
import com.example.parkingvehicle.interfaces.APIInterface;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

public class VehicleInFragment extends Fragment {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageView imageView;
    private Button button;
    private EditText editText;
    private TextView tv_warn;
    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;
    static final int REQUEST_PICTURE_CAPTURE = 1;
    public int MY_PERMISSIONS_REQUEST_CAMERA = 0;
    private String pictureFilePath, item;
    Uri photoURI;
    APIInterface apiInterface;

    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_vehicle_in, container, false);
        imageView = root.findViewById(R.id.btnImage);
        editText = root.findViewById(R.id.input_BienSo);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        button = root.findViewById(R.id.btnNext);
        tv_warn = root.findViewById(R.id.tv_warn);
        //
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);
        final AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //alertDialog.show();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    requestPermission();
                } else {
                    dispatchTakePictureIntent();
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String token = "45FCC8F419313AZ559E2DED09B9AF94";
                final String key = "19ac858c-6517-45ce-a22e-095aff5cffff";
                final String txtPlateNumber = editText.getText().toString();
                if (!txtPlateNumber.isEmpty()) {
                    Call<SingleResponeMessage<Vehicle>> call3 = apiInterface.GetVehicleInfo(key,token,txtPlateNumber);
                    call3.enqueue(new Callback<SingleResponeMessage<Vehicle>>() {
                        @Override
                        public void onResponse(Call<SingleResponeMessage<Vehicle>> call, Response<SingleResponeMessage<Vehicle>> response) {
                            if (txtPlateNumber.trim().length() >= 8) {
                                Log.d("TAG", response.code() + "");
                                SingleResponeMessage<Vehicle> responseMessage = response.body();
                                if (!responseMessage.getIsSuccess()) {
                                    return;
                                }
                                Vehicle vehicle = responseMessage.getItem();
                                if (vehicle == null) {
                                    return;
                                }
                                Intent intent = new Intent(getActivity().getApplicationContext(), AddVehicleActivity.class);
                                intent.putExtra("PlateNumber", txtPlateNumber);
                                intent.putExtra("TypeText", vehicle.getTypeText());
                                startActivity(intent);
                                tv_warn.setText("");
                            } else {
                                tv_warn.setText("Vui lòng nhập trên 8 kí tự");
                            }
                        }

                        @Override
                        public void onFailure(Call<SingleResponeMessage<Vehicle>> call, Throwable t) {
                            call.cancel();
                        }
                    });
                } else {
                    tv_warn.setText("Không được bỏ trống thông tin");
                }
            }
        });
        return root;
    }

    private void requestPermission() {
        Dexter.withActivity(getActivity())
                .withPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE
                        , Manifest.permission.CAMERA)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        if (report.areAllPermissionsGranted()) {
                            dispatchTakePictureIntent();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                })
                .withErrorListener(new PermissionRequestErrorListener() {
                    @Override
                    public void onError(DexterError error) {
                        Toast.makeText(getContext().getApplicationContext(), "Error occurred! " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                })
                .onSameThread()
                .check();
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            File pictureFile = null;
            try {
                pictureFile = getPictureFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (pictureFile != null) {
                photoURI = FileProvider.getUriForFile(getContext(),
                        "com.example.parkingvehicle.provider",
                        pictureFile);

                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }
    }

    private File getPictureFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String pictureFile = "Identity_" + timeStamp;
        File storageDir = getContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(pictureFile, ".jpg", storageDir);
        pictureFilePath = image.getAbsolutePath();
        return image;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && data != null) {
            Intent intent = new Intent(getActivity().getApplicationContext(), CameraSystemActivity.class);
            intent.putExtra("URI", photoURI.toString());
            startActivityForResult(intent, 2912);
        }
        //Xử lí get activity sau khi bên kia gửi request
        else if (requestCode == 2912 && resultCode == Activity.RESULT_OK) {
            //Toast.makeText(getContext(), "O la alala", Toast.LENGTH_SHORT).show();
            final List<String> ListVehicle = data.getStringArrayListExtra("Scrap");
            //Items
            String[] items = ListVehicle.toArray(new String[0]);
            if (items != null) {
                AlertDialog.Builder b = new AlertDialog.Builder(getActivity());
                //Thiết lập title
                b.setTitle("Danh sách biển số xe");
                //Thiết lập item
                b.setItems(items, new DialogInterface.OnClickListener() {
                    //Xử lý sự kiện
                    public void onClick(DialogInterface dialog, int which) {
                        editText.setText("");
                        item = ListVehicle.get(which);
                        editText.setText(item);
                    }
                });
                //Hiển thị dialog
                b.show();
            } else {
                Toast.makeText(getActivity(), "Không có gì để hiển thị, vui lòng quét lại", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
