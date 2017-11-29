package com.example.android.countdonwapp;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;


public class MainActivity extends AppCompatActivity {
    long now = System.currentTimeMillis();

    TextView time;

    public long count() {

        long setup = 1514134800000L;

        long zeit = setup - now;

        return zeit;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        time = (TextView) findViewById(R.id.text);

        time.setText("");

        final CounterClass time = new CounterClass(count(), 1000);
        time.start();
        //System.out.println(count());
    }


    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("NewApi")
    public class CounterClass extends CountDownTimer {
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @TargetApi(Build.VERSION_CODES.GINGERBREAD)
        @SuppressLint("NewApi")
        @Override
        public void onTick(long millisUntilFinished) {


            long millis = millisUntilFinished;
            String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis)
                            - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));

            /*int seconds = (int) (count() / 1000) % 60 ;
            int minutes = (int) ((count() / (1000*60)) % 60);
            int hours   = (int) ((count() / (1000*60*60)) % 24);

            String hms = String.format("%02d:%02d:%02d", hours, hours-minutes, seconds);*/

            System.out.println(hms);
            time.setText(hms);
        }

        @Override
        public void onFinish() {

            time.setText("God help");

        }


    }
}