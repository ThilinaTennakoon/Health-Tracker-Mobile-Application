package com.example.helath_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class biodataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata);


        getSupportActionBar().setTitle("Water Remainder");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF00aced));




    }
    public void openActivity2(){
        Intent intent =new Intent(this,HomeActivity.class);
        startActivity(intent);
        finish();
    }
}