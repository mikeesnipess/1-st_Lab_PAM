package com.example.a1_st_lab_pam;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.a1_st_lab_pam.fragments.Camera;
import com.example.a1_st_lab_pam.fragments.Notification;
import com.example.a1_st_lab_pam.fragments.TextBox;

public class MyViewPager extends FragmentStateAdapter {
    public MyViewPager(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new Notification();
            case 1:
                return new TextBox();
            case 2:
                return new Camera();
            default:
                return new Notification();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
