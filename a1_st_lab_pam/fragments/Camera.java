package com.example.a1_st_lab_pam.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;



import com.example.a1_st_lab_pam.R;
//LayoutInflater ne ajuta sa transformam din continutul layout file sa cream elemente View


public class Camera extends Fragment {

    View view;

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       view= inflater.inflate(R.layout.fragment_camera, container, false);

       Button btnSend2 = view.findViewById(R.id.rear_btn);

       btnSend2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
               startActivityForResult(intent1,0);
           }
       });


       return view;
    }
}