package com.example.tarik.athletto;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.DisplayMetrics;

/**
 * Created by tarik on 8/3/16.
 */
public class SplashScreen extends Activity {

    DisplayMetrics displayMetrics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        Thread timer = new Thread(){
            public void run(){   // timer of 3 seconds is applied to splash screen
                try{
                    sleep(3000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    Intent intent = new Intent(SplashScreen.this,MainActivity.class);  //mainactivity is started now
                    startActivity(intent);
                }
            }

        };
        timer.start();
    }

    @Override
    protected void onPause() {    // it is shown only one time ie at the starting of app
        super.onPause();
        finish();
    }
}
