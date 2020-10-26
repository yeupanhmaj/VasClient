package com.example.parkingvehicle.adapter;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parkingvehicle.Model.ScaleTicketPODetailList;
import com.example.parkingvehicle.R;

import java.util.ArrayList;
import java.util.List;

public class ScaleTicketPODetailPageAdapter extends RecyclerView.Adapter<ScaleTicketPODetailPageAdapter.ViewHolder> {

    private List<ScaleTicketPODetailList> items;
    private OnItemClickListener onItemClickListener;
    private Context context;

    public ScaleTicketPODetailPageAdapter(Context context, List<ScaleTicketPODetailList> items, OnItemClickListener onItemClickListener) {
        this.items = items;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ScaleTicketPODetailPageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kiemlieu, parent, false);
        return new ViewHolder(view);
    }

    // ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_POLine;
        TextView tv_VatTu;
        Spinner Sp_Percent;
        ImageButton imageButton;

        ViewHolder(View itemView) {
            super(itemView);
            tv_POLine = itemView.findViewById(R.id.tv_POLine);
            tv_VatTu = itemView.findViewById(R.id.tv_VatTu);
            Sp_Percent = itemView.findViewById(R.id.Sp_Percent);
            imageButton = itemView.findViewById(R.id.btnRemove);
            imageButton.setOnClickListener(v -> onItemClickListener.OnItemClick(getAdapterPosition()));
        }
    }

    private int percent;

    @Override
    public void onBindViewHolder(@NonNull ScaleTicketPODetailPageAdapter.ViewHolder holder, int position) {
        ScaleTicketPODetailList item = items.get(position);
        holder.tv_POLine.setText(item.getPoLine());
        holder.tv_VatTu.setText(item.getProductName());
        double d = item.getTyLeTrongLuong();
        String s = String.valueOf(d);
        String[] str = s.split("\\.");
        int tl = Integer.parseInt(str[0]);

        int a = 0;
        final List<Integer> Percent = new ArrayList<>();
        Percent.add(0);
        for (int i = 0; i <= 99; i++) {
            a = a + 1;
            Percent.add(a);
        }
        
        ArrayAdapter userAdapter = new ArrayAdapter(context, R.layout.support_simple_spinner_dropdown_item, Percent);
        holder.Sp_Percent.setAdapter(userAdapter);
        holder.Sp_Percent.setSelection(tl);
        holder.Sp_Percent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                percent = (int) holder.Sp_Percent.getItemAtPosition(position);
                onItemClickListener.OnItemSelectd(holder.getAdapterPosition(), percent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    public int getItemCount() {
        if (items != null)
            return items.size();
        return 0;
    }


    // interface OnItemClickListener
    public interface OnItemClickListener {
        void OnItemClick(int position);

        void OnItemSelectd(int position, int value);
    }
}
