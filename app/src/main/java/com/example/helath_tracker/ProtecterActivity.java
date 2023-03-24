package com.example.helath_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;

import java.sql.SQLOutput;


public class ProtecterActivity extends AppCompatActivity {
    public String savetokn;
    EditText titleEt,messageEt,tokenEt;
    Button sendToAllBtn,sendToTokenBtn,Btntoken;
    String token = "tokenString";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protecter);

        getSupportActionBar().setTitle("Send Reminder");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF00aced));

        titleEt = findViewById(R.id.titleEt);
        messageEt = findViewById(R.id.messageEt);
        tokenEt = findViewById(R.id.tokenEt);
        sendToAllBtn = findViewById(R.id.sendToAllBtn);
        sendToTokenBtn = findViewById(R.id.sendToTokenBtn);
        Btntoken=findViewById(R.id.btnToken);

        //SharedPreferences sharedPreferences=getSharedPreferences("com.example.helath_tracker", Context.MODE_PRIVATE);
        //tokenEt.setText(sharedPreferences.getString("tkn",savetokn));



        SharedPreferences pref =PreferenceManager.getDefaultSharedPreferences(this);
        tokenEt.setText(pref.getString("tkn",savetokn));




        FirebaseMessaging.getInstance().subscribeToTopic("all");
        SharedPreferences prefs = getSharedPreferences("RegisteredToken", MODE_PRIVATE);
        token = prefs.getString("tokenName", "");//"No name defined" is the default value.
        Toast.makeText(getApplicationContext(), ""+token, Toast.LENGTH_SHORT).show();
        Log.d("Token",token);




        sendToAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              savetokn=tokenEt.getText().toString();

             //   SharedPreferences sharedPreferences=getSharedPreferences("com.example.helath_tracker", Context.MODE_PRIVATE);
               //  sharedPreferences.edit().putString("tkn",savetokn).apply();

              SharedPreferences pref= PreferenceManager.getDefaultSharedPreferences(ProtecterActivity.this);
              SharedPreferences.Editor editor=pref.edit();
              editor.putString("tkn",savetokn);
              editor.apply();

            }
        });

        sendToTokenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (titleEt.getText().toString().trim().isEmpty() || messageEt.getText().toString().trim().isEmpty()){
                    Toast.makeText(ProtecterActivity.this, "Pleas Fill Details", Toast.LENGTH_SHORT).show();
                } else {
                    FcmNotificationSender notificationsSender = new FcmNotificationSender(tokenEt.getText().toString(),titleEt.getText().toString(),
                            messageEt.getText().toString(),getApplicationContext(),ProtecterActivity.this);
                    notificationsSender.SendNotifications();
                }
            }
        });



        Btntoken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intent);

            }
        });


    }

}