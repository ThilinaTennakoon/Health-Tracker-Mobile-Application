package com.example.helath_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RemainderActivity extends AppCompatActivity {
      private Button reminderBtn,home,gym,whater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remainder);

        getSupportActionBar().hide();

        reminderBtn=(Button) findViewById(R.id.SetReminBtn);
        home=findViewById(R.id.btnhome);
        gym=findViewById(R.id.btngym);
        whater=findViewById(R.id.button4);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity9();}
            }
        );
        gym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity10();}
            }
        );
        reminderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity5();}
            }
        );

        whater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity6();}

        });

    }
        public void openActivity5(){
            Intent intent =new Intent(this,AlarmMainActivity.class);
            startActivity(intent);


        }
    public void openActivity6(){
        Intent intent =new Intent(this,biodataActivity.class);
        startActivity(intent);


    }
    public void openActivity10(){
        Intent intent =new Intent(this,WorkoutActivity.class);
        startActivity(intent);


    }
    public void openActivity9(){
        Intent intent =new Intent(this,HomeActivity.class);
        startActivity(intent);


    }
}