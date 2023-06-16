package com.suhun.threadbybroadcastreceiver;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String tag = MainActivity.class.getSimpleName();
    public TextView resultView;
    private MyReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultView = findViewById(R.id.result);
    }

    @Override
    protected void onStart() {
        super.onStart();
        myReceiver = new MyReceiver(MainActivity.this);
        registerReceiver(myReceiver, new IntentFilter("runThread"));
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myReceiver);
    }

    public void createFun(View view){
        Log.d(tag, "+++++MaiActivity run createFun+++++");
        MyThread myThread = new MyThread(MainActivity.this, "method1", "happy");
//        MyThread myThread = new MyThread(MainActivity.this, "method2", "happy");
        myThread.start();
    }
}