package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
    private Chronometer time;
    private long stopoffset;
    private boolean running;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        time = findViewById(R.id.time);
    }

    public void starttime(View v){
        if(!running){
            time.setBase(SystemClock.elapsedRealtime() - stopoffset);
            time.start();
            running=true;
        }

    }
    public void stoptime(View v){
        if(running){
            time.stop();
            stopoffset = SystemClock.elapsedRealtime() - time.getBase();
            running=false;
        }

    }
    public void holdtime(View v){
        time.setBase(SystemClock.elapsedRealtime());
        stopoffset=0;

    }
}