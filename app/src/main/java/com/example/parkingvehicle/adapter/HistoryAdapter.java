package com.example.parkingvehicle.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parkingvehicle.Model.History;

import com.example.parkingvehicle.R;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    private List<History> items;
    //private HistoryAdapter.OnItemClickListener onItemClickListener;
    // ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView statusContent;

        ViewHolder(View itemView) {
            super(itemView);
            statusContent = itemView.findViewById(R.id.statusContent);
        }
    }
    public HistoryAdapter( List<History> items) {
        this.items = items;
        //.onItemClickListener = onItemClickListener;
    }

    // interface OnItemClickListener
    public interface OnItemClickListener {
        void OnItemClick(int position);
    }

    @NonNull
    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_statusthongbao, parent, false);
        return new HistoryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.ViewHolder holder, int position) {
        History item = items.get(position);
        holder.statusContent.setText(item.getHistoryNote());
    }

    @Override
    public int getItemCount() {
        if (items != null)
            return items.size();
        return 0;
    }
}
