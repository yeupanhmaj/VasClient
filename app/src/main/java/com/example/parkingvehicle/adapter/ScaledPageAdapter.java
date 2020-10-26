package com.example.parkingvehicle.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import com.example.parkingvehicle.Model.ItemScaled;
import com.example.parkingvehicle.R;

import java.util.List;

public class ScaledPageAdapter extends RecyclerView.Adapter<ScaledPageAdapter.ViewHolder> {
    private List<ItemScaled> items;
    private OnItemClickListener onItemClickListener;

    public ScaledPageAdapter(List<ItemScaled> items, OnItemClickListener onItemClickListener) {
        this.items = items;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_scaled, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemScaled item = items.get(position);
        holder.tvNum.setText(String.valueOf(item.getId()));
        holder.tvNumberCar.setText(item.getBienSoXe());
        holder.tvNumPort.setText(item.getLoaiCong());
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
    }

    // ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvNum;
        TextView tvNumberCar;
        TextView tvNumPort;
        ViewHolder(View itemView) {
            super(itemView);
            tvNum = itemView.findViewById(R.id.tvNum);
            tvNumberCar = itemView.findViewById(R.id.tvNumberCar);
            tvNumPort = itemView.findViewById(R.id.tvNumPort);
            itemView.setOnClickListener(v -> onItemClickListener.OnItemClick(getAdapterPosition()));
        }
    }

}
