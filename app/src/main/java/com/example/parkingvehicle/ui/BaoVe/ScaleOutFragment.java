package com.example.parkingvehicle.ui.BaoVe;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parkingvehicle.Model.ItemScaled;
import com.example.parkingvehicle.R;
import com.example.parkingvehicle.adapter.ScaledPageAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class ScaleOutFragment extends Fragment {
     private TextView textView;
    private RecyclerView recyclerView;
     private DatePickerDialog.OnDateSetListener onDateSetListener;
    @SuppressLint("ResourceType")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_scale_out, container, false);
        recyclerView = root.findViewById(R.id.listVehicleScaled);
        textView = root.findViewById(R.id.edtDatePicker);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int day = cal.get(Calendar.DAY_OF_MONTH);
                int month = cal.get(Calendar.MONTH);
                int year = cal.get(Calendar.YEAR);
                DatePickerDialog dialog = new DatePickerDialog(getContext(),onDateSetListener,year,month,day);
                dialog.show();
            }
        });
        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = dayOfMonth + "/" + month + "/" + year;
                textView.setText(date);
            }
        };
        recyclerView.setHasFixedSize(true);
        final List<ItemScaled> items = new ArrayList<>();
        items.add(new ItemScaled(0,"59S1-9983","","COM1"));
        items.add(new ItemScaled(1,"59S2-9433","","COM2"));
        items.add(new ItemScaled(2,"60S1-7333","","COM1"));
        final ScaledPageAdapter ScaledPageAdapter = new ScaledPageAdapter(items, new ScaledPageAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                Toast.makeText(getContext(),items.get(position).getBienSoXe(),Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(ScaledPageAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplication(), LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), LinearLayout.VERTICAL));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (!recyclerView.canScrollVertically(1)){
                    Toast.makeText(getContext(), "Last", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return root;
    }
}
