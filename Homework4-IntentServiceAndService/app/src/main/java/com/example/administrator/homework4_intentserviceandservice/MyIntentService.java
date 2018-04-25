package com.example.administrator.homework4_intentserviceandservice;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/4/25.
 */

public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        showToastByRunnable();
    }

    private void showToastByRunnable() {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MyIntentService.this, "吴静远 15301078 -- MyIntentService", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //Toast.makeText(getApplicationContext(), "MyIntentService Create", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "MyIntentService Destroy", Toast.LENGTH_SHORT).show();
    }
}
