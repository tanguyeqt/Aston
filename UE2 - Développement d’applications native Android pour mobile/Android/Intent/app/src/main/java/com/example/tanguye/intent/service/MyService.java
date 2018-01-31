package com.example.tanguye.intent.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.tanguye.intent.utils.Constant;

/**
 * Created by tanguye on 29/01/2018.
 */

public class MyService extends Service{
    private static final String TAG =  "myService";
    private Thread myThread;
    private boolean isRunning  = false;


    public MyService(){

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG,"demarrage du service");

        myThread = new Thread(new Runnable() {
            int numero= 1;

            @Override
            public void run() {

                while(isRunning){

                    sendBroadcast(new Intent(Constant.BROADCAST_MESSAGE)
                            .putExtra(Constant.INTENT_MESSAGE,"message" + numero));

                    numero ++;//incrementation du numero

                    Log.e(TAG, "message du thread");

                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        isRunning = true;
        myThread.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"arret du service");

        isRunning = false;
        myThread.interrupt();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
