package com.example.helath_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WeekActivity extends AppCompatActivity {
    private Button day1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week);

        getSupportActionBar().hide();

        day1=(Button) findViewById(R.id.day1);
        day1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity3();
            }
        });
    }
    public void openActivity3(){
        Intent intent =new Intent(this,DayActivity.class);
        startActivity(intent);

    }
}