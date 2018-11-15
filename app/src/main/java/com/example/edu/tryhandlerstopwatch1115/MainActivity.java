package com.example.edu.tryhandlerstopwatch1115;

import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnStart,btnReset,btnPause,btnSave;
    private TextView textViewTimer;

    private Handler handler;
    private long millisecondTime,startTime,updateTime,timeBuff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewTimer = findViewById(R.id.textViewTimer);

        btnStart = findViewById(R.id.btnStart);
        btnReset = findViewById(R.id.btnReset);
        btnPause = findViewById(R.id.btnPause);
        btnSave = findViewById(R.id.btnSave);

        btnStart.setOnClickListener(this);
        btnReset.setOnClickListener(this);
        btnPause.setOnClickListener(this);
        btnSave.setOnClickListener(this);

        handler = new Handler();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnStart:
                startTime = SystemClock.uptimeMillis();
                //handler.postDelayed(runnable,0);
                handler.post(runnable);
                break;
            case R.id.btnPause:
                timeBuff += millisecondTime;
                handler.removeCallbacks(runnable);
                break;
            case R.id.btnReset:
                break;
            case R.id.btnSave:
                break;
        }
    }

    public Runnable runnable = new Runnable() {
        @Override
        public void run() {
            millisecondTime = SystemClock.uptimeMillis() - startTime;
            updateTime = timeBuff + millisecondTime;
            SimpleDateFormat formatter = new SimpleDateFormat("mm : ss : SSS");
            textViewTimer.setText(formatter.format(updateTime));
            //handler.postDelayed(this,0);
            handler.post(this);
        }
    };
}
