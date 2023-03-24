package com.example.helath_tracker;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class DisplayToken extends AppCompatActivity {
    TextView etken;
    Button qr;
    String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_token);

        getSupportActionBar().setTitle("Your Code");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF00aced));

        qr=findViewById(R.id.QRbtn);
        etken=findViewById(R.id.etToken);
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            System.out.println("Fetching FCM registration token failed");
                            return;
                        }
                        // Get new FCM registration token
                        token = task.getResult();

                        // Log and toast
                        System.out.println(token);
                        Toast.makeText(DisplayToken.this,"your device registration token is"+ token,
                                Toast.LENGTH_SHORT).show();

                        etken.setText(token);
                    }
                });

        qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DisplayToken.this, QRcode.class);
                intent.putExtra("Value",token);
                startActivity(intent);

            }
        });
    }
}