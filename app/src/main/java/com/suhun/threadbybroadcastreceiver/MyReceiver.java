package com.suhun.threadbybroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {
    private String tag = MyReceiver.class.getSimpleName();
    private MainActivity activity;
    public MyReceiver(Context activity){
        this.activity = (MainActivity) activity;

    }
    @Override
    public void onReceive(Context context, Intent intent) {
        String result = intent.getStringExtra("result");
        activity.resultView.setText(result);
    }
}
