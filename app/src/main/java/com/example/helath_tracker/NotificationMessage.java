package com.example.helath_tracker;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.messaging.FirebaseMessaging;

//this class creates the Reminder Notification Message
public class NotificationMessage extends AppCompatActivity {
    TextView textView;
    String token = "tokenString";



   String tkkn="eRjmam4OS6OH0A9pQm20FW:APA91bFz37e8zsPDSed9u-vviLeewcBhwP2DvyiFdpngGmmMbKh4yqRnOTNdcAneXTsKjH_V7JP7HVnQX5SC_Fx1vwHUCY_mcZt-S5MvD1F-dhqczXRiWTbT49kMMaic5Cp18jC3ubXk";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_notification_message);

      //  SharedPreferences sharedPreferences=getSharedPreferences("com.example.helath_tracker", Context.MODE_PRIVATE);
      // token=sharedPreferences.getString("tkn","");

        FirebaseMessaging.getInstance().subscribeToTopic("all");
        SharedPreferences prefs = getSharedPreferences("RegisteredToken", MODE_PRIVATE);
        token = prefs.getString("tokenName", "");
        //"No name defined" is the default value.
        Toast.makeText(getApplicationContext(), ""+token, Toast.LENGTH_SHORT).show();
        Log.d("Token",token);

        //tkkn=findViewById(R.id.tokenEt);

        textView = findViewById(R.id.tv_message);
        creatobject ooo=getIntent().getParcelableExtra("object"); //call the data which is passed by another intent
        textView.setText(ooo.name);

        FcmNotificationSender notificationsSender = new FcmNotificationSender(tkkn,
                ooo.name,
               "අම්මෙ මම බේත් බීවා",getApplicationContext(),NotificationMessage.this);
        notificationsSender.SendNotifications();


    }
}