package com.example.parkingvehicle.ui.BaoVe;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.parkingvehicle.R;
import com.example.parkingvehicle.TextDectection.GraphicOverlay;
import com.example.parkingvehicle.TextDectection.TextGraphic;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.text.FirebaseVisionText;
import com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class CameraSystemActivity extends AppCompatActivity {
    private GraphicOverlay mGraphicOverlay;
    private TextGraphic textGraphic;
    // Max width (portrait mode)
    private Integer mImageMaxWidth;
    // Max height (portrait mode)
    private Button btnIdentity;
    private Integer mImageMaxHeight;
    private ImageView imageView;
    Uri uri;
    String a;
    /**
     * Number of results to show in the UI.
     */
    private static final int RESULTS_TO_SHOW = 3;
    /**
     * Dimensions of inputs.
     */
    private static final int DIM_IMG_SIZE_X = 224;
    private static final int DIM_IMG_SIZE_Y = 224;

    private final PriorityQueue<Map.Entry<String, Float>> sortedLabels = new PriorityQueue<>(
            RESULTS_TO_SHOW,
            new Comparator<Map.Entry<String, Float>>() {
                @Override
                public int compare(Map.Entry<String, Float> o1, Map.Entry<String, Float>
                        o2) {
                    return (o1.getValue()).compareTo(o2.getValue());
                }
            });

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageview);
        FirebaseApp.initializeApp(this);
        btnIdentity = findViewById(R.id.identity);
        imageView = findViewById(R.id.pictureCap);
        Bundle bundle = getIntent().getExtras();
        uri = Uri.parse(bundle.getString("URI"));
        imageView.setImageURI(uri);
        btnIdentity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    runTextRecognition();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void runTextRecognition() throws IOException {
        Bitmap bmp = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), uri);
        try {
            FirebaseVisionImage image = FirebaseVisionImage.fromBitmap(bmp);
            FirebaseVisionTextRecognizer detector = FirebaseVision.getInstance()
                    .getOnDeviceTextRecognizer();
            btnIdentity.setEnabled(false);
            detector.processImage(image)
                    .addOnSuccessListener(
                            new OnSuccessListener<FirebaseVisionText>() {
                                @Override
                                public void onSuccess(FirebaseVisionText texts) {
                                    btnIdentity.setEnabled(true);
                                    processTextRecognitionResult(texts);
                                }
                            })
                    .addOnFailureListener(
                            new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    // Task failed with an exception
                                    btnIdentity.setEnabled(true);
                                    e.printStackTrace();
                                }
                            });
        } catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    private void processTextRecognitionResult(FirebaseVisionText texts) {
        try {
            List<FirebaseVisionText.TextBlock> blocks = texts.getTextBlocks();
            if (blocks.size() == 0) {
                showToast("Không tìm thấy biển số, vui lòng thử lại");
                ContentResolver contentResolver = getContentResolver ();
                contentResolver.delete (uri,null ,null );
                finish();
                return;
            }
            ArrayList<String> ListBienSoXe = new ArrayList<>();
            for (int i = 0; i < blocks.size(); i++) {
                List<FirebaseVisionText.Line> lines = blocks.get(i).getLines();
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < lines.size(); j++) {
                    List<FirebaseVisionText.Element> elements = lines.get(j).getElements();
                    for (int k = 0; k < elements.size(); k++) {
                        builder.append(elements.get(k).getText());
                    }
                    if (j < lines.size() - 1)
                        builder.append('-');
                }
                a = builder.toString();

                if (a.charAt(2) == '-') {
                    String[] output = a.split("-");
                    String abcded = output[0] + output[1] + "-" + output[2];
                    ListBienSoXe.add(abcded);
                } else if (a.charAt(3) == '-') {
                    ListBienSoXe.add(a);
                }
            }
            ContentResolver contentResolver = getContentResolver ();
            contentResolver.delete (uri,null ,null );
            //Return về 1 activity nào đó
            Intent resultIntent = new Intent();
            resultIntent.putStringArrayListExtra("Scrap", ListBienSoXe);
            setResult(Activity.RESULT_OK, resultIntent);
            finish();
        } catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    private void showToast(String message) {
        Toast.makeText(CameraSystemActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    // Functions for loading images from app assets.

    // Returns max image width, always for portrait mode. Caller needs to swap width / height for
    // landscape mode.
    private Integer getImageMaxWidth() {
        if (mImageMaxWidth == null) {
            // Calculate the max width in portrait mode. This is done lazily since we need to
            // wait for
            // a UI layout pass to get the right values. So delay it to first time image
            // rendering time.
            mImageMaxWidth = imageView.getWidth();
        }

        return mImageMaxWidth;
    }

    // Returns max image height, always for portrait mode. Caller needs to swap width / height for
    // landscape mode.
    private Integer getImageMaxHeight() {
        if (mImageMaxHeight == null) {
            // Calculate the max width in portrait mode. This is done lazily since we need to
            // wait for
            // a UI layout pass to get the right values. So delay it to first time image
            // rendering time.
            mImageMaxHeight =
                    imageView.getHeight();
        }

        return mImageMaxHeight;
    }

    // Gets the targeted width / height.
    private Pair<Integer, Integer> getTargetedWidthHeight() {
        int targetWidth;
        int targetHeight;
        int maxWidthForPortraitMode = getImageMaxWidth();
        int maxHeightForPortraitMode = getImageMaxHeight();
        targetWidth = maxWidthForPortraitMode;
        targetHeight = maxHeightForPortraitMode;
        return new Pair<>(targetWidth, targetHeight);
    }
}
