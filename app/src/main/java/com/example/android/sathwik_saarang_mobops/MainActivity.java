package com.example.android.sathwik_saarang_mobops;

import android.net.Uri;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import com.example.android.sathwik_saarang_mobops.R;


public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE1 = "com.example.sathwikchadaga_saarang_mobops.MESSAGE1";
    public final static String EXTRA_MESSAGE2 = "com.example.sathwikchadaga_saarang_mobops.MESSAGE2";
    public final static String EXTRA_MESSAGE3 = "com.example.sathwikchadaga_saarang_mobops.MESSAGE3";
    public final static String EXTRA_MESSAGE4 = "com.example.sathwikchadaga_saarang_mobops.MESSAGE4";
    public final static String EXTRA_MESSAGE5 = "com.example.sathwikchadaga_saarang_mobops.MESSAGE5";
    public final static String EXTRA_MESSAGE6 = "com.example.sathwikchadaga_saarang_mobops.MESSAGE6";
    public final static String EXTRA_MESSAGE7 = "com.example.sathwikchadaga_saarang_mobops.MESSAGE7";
    public final static String EXTRA_MESSAGE8 = "com.example.sathwikchadaga_saarang_mobops.MESSAGE8";
    public final static String EXTRA_MESSAGE9 = "com.example.sathwikchadaga_saarang_mobops.MESSAGE9";
    public final static String EXTRA_MESSAGE10 = "com.example.sathwikchadaga_saarang_mobops.MESSAGE10";
    public final static String EXTRA_MESSAGE11 = "com.example.sathwikchadaga_saarang_mobops.MESSAGE11";
    public final static String EXTRA_MESSAGE12 = "com.example.sathwikchadaga_saarang_mobops.MESSAGE12";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new SimpleAdapter());
    }

}

