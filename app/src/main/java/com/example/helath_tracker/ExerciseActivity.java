package com.example.helath_tracker;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.Locale;

public class ExerciseActivity extends AppCompatActivity {
     AnimationDrawable exercise;
    private static final int SPEECH_REQUEST_CODE = 0;
     private  static final long START_TIME_IN_MILLIS =20000;
   private TextView mTextViewCountDown;
   private Button mBttonStartPause;
   private CountDownTimer mCountDownTimer;
   private boolean mtimerRunning;
   private long mTimeLeftInMillis=START_TIME_IN_MILLIS;

    private   MediaPlayer tiksoundMP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        tiksoundMP=MediaPlayer.create(ExerciseActivity.this,R.raw.tiktik);



        getSupportActionBar().hide();


        //time count down code
        ImageView imageView =(ImageView) findViewById(R.id.image);
        imageView.setBackgroundResource(R.drawable.animation);
        exercise=(AnimationDrawable) imageView.getBackground();

        mTextViewCountDown=findViewById(R.id.text_View_countdown);
        mBttonStartPause=findViewById(R.id.button_start_pause);

        mBttonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mtimerRunning){

                    pauseTimer();

                }
                else {

                    startTimer();
                }
            }
        });



    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        exercise.start();


    }

    private void startTimer(){


mCountDownTimer= new CountDownTimer(mTimeLeftInMillis,1000) {
    @Override
    public void onTick(long l) {
        mTimeLeftInMillis=l;
    updateCountDownText();

    }

    @Override
    public void onFinish() {
mtimerRunning=false;
mBttonStartPause.setText("Start");
displaySpeechRecognizer();
    }
}.start();

mtimerRunning=true;
mBttonStartPause.setText("pause");



    }


    private void pauseTimer(){

       mCountDownTimer.cancel();
          mtimerRunning=false;
       mBttonStartPause.setText("Start");
    }

    private void resetTimer(){

       mTimeLeftInMillis= START_TIME_IN_MILLIS;
       updateCountDownText();
    }


    private void updateCountDownText(){

        int minutes=(int) (mTimeLeftInMillis/ 1000 )/60;
        int seconds=(int) (mTimeLeftInMillis/ 1000) % 60;

        String timeLeftFormatted=String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);

        mTextViewCountDown.setText(timeLeftFormatted);


        tiksoundMP.start();
    }


    private void displaySpeechRecognizer() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Give Your Command(Again,Exit,Next)'");
  // This starts the activity and populates the intent with the speech text.
        startActivityForResult(intent, SPEECH_REQUEST_CODE);
    }

    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        if (requestCode == SPEECH_REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> results = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);
            String spokenText = results.get(0);
            if(results.get(0).toString().equals("again")){

                resetTimer();
                startTimer();


            }
            else if(results.get(0).toString().equals("next")){

                Intent intent =new Intent(this,Exercise2.class);
                startActivity(intent);


            }
            else if(results.get(0).toString().equals("exit")){

                Intent intent =new Intent(this,DayActivity.class);
                startActivity(intent);


            }

            else{
                displaySpeechRecognizer();

            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}





