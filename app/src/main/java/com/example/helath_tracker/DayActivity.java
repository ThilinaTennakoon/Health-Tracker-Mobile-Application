package com.example.helath_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DayActivity extends AppCompatActivity {
    private Button stretch;
    private Button stretch1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);

        getSupportActionBar().hide();


        stretch=(Button) findViewById(R.id.button5);
        stretch1=(Button) findViewById(R.id.button6);

        stretch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity3();
            }
        });

        stretch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity4();
            }
        });
    }
    public void openActivity3(){
        Intent intent =new Intent(this,ExerciseActivity.class);
        startActivity(intent);


    }

    public void openActivity4(){
        Intent intent =new Intent(this,Exercise2.class);
        startActivity(intent);


    }
}