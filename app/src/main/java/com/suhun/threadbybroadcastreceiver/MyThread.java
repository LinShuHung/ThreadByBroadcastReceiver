package com.suhun.threadbybroadcastreceiver;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyThread extends Thread{
    private String tag = MyThread.class.getSimpleName();
    private MainActivity activity;
    private String op="";
    private String name;
    public MyThread(Context activity, String name){
        this.activity = (MainActivity)activity;
        this.name = name;
    }
    public MyThread(Context activity, String op, String name){
        this.activity = (MainActivity)activity;
        this.op = op;
        this.name = name;
    }
    @Override
    public void run() {
        super.run();
        if(op.equals("")){
            Log.d(tag, "+++++MyThread Not yet+++++");
        }else if(op.equals("method1")){
            Log.d(tag, "+++++MyThread run method1+++++");
            this.runMethod1();
        }else if(op.equals("method2")){
            Log.d(tag, "+++++MyThread run method2+++++");
            this.runMethod2();
        }
    }

    private void runMethod1(){
        for(int i=1;i<=20;i++){
            Log.d(tag, "+++++MyThread run method1 +++++"+this.name+":"+i);
            try{
                Thread.sleep(500);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }

    private void runMethod2(){
        for(int i=1;i<=20;i++){
            Log.d(tag, "+++++MyThread run method2 +++++"+":"+i);
            try{
                Thread.sleep(500);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
