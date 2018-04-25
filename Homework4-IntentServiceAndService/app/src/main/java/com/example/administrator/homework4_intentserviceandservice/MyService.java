package com.example.administrator.homework4_intentserviceandservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(getApplicationContext(), "MyService Create", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int stratId) {

//        long endTime = System.currentTimeMillis() + 2 * 1000;
//        System.out.println("Service onStart");
//        while (System.currentTimeMillis() < endTime) {
//            synchronized (this) {
//                try {
//                    wait(endTime - System.currentTimeMillis());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        System.out.println("Service task finish");

        Toast.makeText(getApplicationContext(), "吴静远 15301078 -- MyService", Toast.LENGTH_SHORT).show();

        return super.onStartCommand(intent, flags, stratId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Toast.makeText(getApplicationContext(), "MyService Destroy", Toast.LENGTH_SHORT).show();
    }
}
