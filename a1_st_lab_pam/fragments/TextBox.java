package com.example.a1_st_lab_pam.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.a1_st_lab_pam.R;

public class TextBox extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.fragment_text_box, container, false);
       Button button_search = view.findViewById(R.id.button2_search);
        EditText editText = view.findViewById(R.id.search_all);
       button_search.setOnClickListener(new View.OnClickListener() {
        @Override
           public void onClick(View v)
        {
            gotoUrl("https://www.google.com/search?client=opera-gx&q="+editText.getText());
            editText.setText("");
        }
       });

        return view;
    }
    private void gotoUrl(String s)
    {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}
