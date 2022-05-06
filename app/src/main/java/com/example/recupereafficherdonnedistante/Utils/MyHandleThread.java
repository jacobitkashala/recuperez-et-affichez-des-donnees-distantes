package com.example.recupereafficherdonnedistante.Utils;

import android.os.HandlerThread;
import android.os.Looper;
import android.view.View;
import android.widget.ProgressBar;

import java.lang.ref.WeakReference;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class MyHandleThread extends HandlerThread {

    private WeakReference<ProgressBar> progressBarWeakReference;

    // Constructor
    public MyHandleThread(String name, ProgressBar progressBar) {
        super(name);
        progressBarWeakReference = new WeakReference<>(progressBar);
    }

    // Public method that will start handler
    public void startHandler(){

        // Checking if progressbar is accessible, and setting it visible
        if (progressBarWeakReference.get() != null) progressBarWeakReference.get().setVisibility(View.VISIBLE);

        // Checking if handlerThread is already alive, else we start it.
        if (!this.isAlive()) this.start();

        // Creating a new Handler and setting it the looper of handlerThread
       /*  Handler handler = new Handler() {
             @Override
             public void publish(LogRecord record) {

             }

             @Override
             public void flush() {

             }

             @Override
             public void close() throws SecurityException {

             }
         };*/

        // Executing a new Runnable
       /*
        handler.post(new Runnable(){
            @Override
            public void run() {
                // Execute our long task during 7 seconds
                Utils.executeLongActionDuring7seconds();

                // Update UI after task finished (In Main Thread)
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        if (progressBarWeakReference.get() != null) progressBarWeakReference.get().setVisibility(View.GONE);
                    }
                });
            }
        });*/
    }

}
