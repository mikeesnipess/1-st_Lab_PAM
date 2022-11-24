package com.example.a1_st_lab_pam;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import com.example.a1_st_lab_pam.fragments.TextBox;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.os.CountDownTimer;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileReader;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    MyViewPager myViewPager;

    NotificationManagerCompat notificationManagerCompat;
    Notification notification;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        NotificationChannel channel = new NotificationChannel("myCh","My Channel", NotificationManager.IMPORTANCE_DEFAULT);
        NotificationManager manager = getSystemService(NotificationManager.class);
        manager.createNotificationChannel(channel);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"myCh")
                .setDefaults(Notification.PRIORITY_LOW)
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setLights(0xff89cff0, 300, 100)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setVibrate(null)
                .setSmallIcon(android.R.drawable.stat_notify_sync)
                .setContentTitle("Notificare!")
                .setContentText("Notificare cu succes!!!");


        notification = builder.build();
        notificationManagerCompat= NotificationManagerCompat.from(this);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager2 = findViewById(R.id.view_pager);
        myViewPager = new MyViewPager(this);
        viewPager2.setAdapter(myViewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });  //urmareste swipe

    }
CountDownTimer countDownTimer;

    public void clickNotification(View view) {
        countDownTimer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long l) {
                notificationManagerCompat.notify(1,notification);
            }

            @Override
            public void onFinish() {
                notificationManagerCompat.notify(1,notification);
            }
        }.start();
    }

}