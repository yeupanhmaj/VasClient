package com.example.parkingvehicle.ui.BaoVe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parkingvehicle.Model.ItemScaled;
import com.example.parkingvehicle.R;
import com.example.parkingvehicle.adapter.ScaledPageAdapter;

import java.util.ArrayList;
import java.util.List;

public class ScalingFragment extends Fragment {
    private RecyclerView recyclerView;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_scaling, container, false);
        recyclerView = root.findViewById(R.id.listVehicleScaling);
        recyclerView.setHasFixedSize(true);
        final List<ItemScaled> items = new ArrayList<>();
        items.add(new ItemScaled(0,"61S1-998.78","","COM1"));
        items.add(new ItemScaled(1,"59S2-923.67","","COM2"));
        items.add(new ItemScaled(2,"61C1-546.56","","COM1"));
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
