package com.example.parkingvehicle.ui.BaoVe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.parkingvehicle.R;
import com.example.parkingvehicle.adapter.SectionsPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class ListVehicleFragment extends Fragment {
    TabLayout tabLayout;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list_vehicle, container, false);
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getFragmentManager());
        final TabLayout tabLayout = root.findViewById(R.id.tabLayoutHost);
        tabLayout.setSelectedTabIndicator(R.color.colorOrange);
        final ViewPager viewPager = root.findViewById(R.id.viewPager);
        //Set Fragment
        Fragment tab1 = new ScalingFragment();
        //Fragment tab2 = new ScaledFragment();
        Fragment tab3 = new ScaleOutFragment();
        adapter.addFragment(tab1, "Đang cân");
        //adapter.addFragment(tab2, "Đã cân");
        adapter.addFragment(tab3, "Đã ra");
        viewPager.setAdapter(adapter);
        final int selectedTab = getActivity().getIntent().getIntExtra("SELECT_TAB", 0);
        viewPager.setCurrentItem(selectedTab);
        tabLayout.setupWithViewPager(viewPager);
        return root;
    }
}
