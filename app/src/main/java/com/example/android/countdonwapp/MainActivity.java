package com.example.android.countdonwapp;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * @author Konrad Maslowiec aka Thorn
 * @since Nov 22, 2017
 * <p>
 * The logic for downcounter. My first Android App. Google Udacity Android Basic Project I
 */
public class MainActivity extends AppCompatActivity {
    long now = System.currentTimeMillis();

    TextView time;

    /**
     *
     * @return time setup in future minus current time
     */

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


            String hms = String.format(Locale.CANADA, "%02d day %02d hr %02d min %02d sec", TimeUnit.MILLISECONDS.toDays(millis), TimeUnit.MILLISECONDS.toHours(millis)
                            - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(millis)),
                    TimeUnit.MILLISECONDS.toMinutes(millis)
                            - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));



            System.out.println(hms);
            time.setText(hms);
        }

        @Override
        public void onFinish() {

            time.setText("!!! Merry Christmas !!!");

        }


    }
}