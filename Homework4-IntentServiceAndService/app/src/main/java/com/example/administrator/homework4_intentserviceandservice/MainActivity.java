package com.example.administrator.homework4_intentserviceandservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnStartService;
    Button btnStopService;
    Button btnStartIntentService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartService = (Button) findViewById(R.id.btnStartService);
        btnStopService = (Button) findViewById(R.id.btnStopService);
        btnStartService.setOnClickListener(this);
        btnStopService.setOnClickListener(this);

        btnStartIntentService = (Button) findViewById(R.id.btnStartIntentService);
        btnStartIntentService.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStartService:
                Intent startIntent = new Intent(this, MyService.class);
                startService(startIntent);
                break;
            case R.id.btnStopService:
                Intent stopIntent = new Intent(this, MyService.class);
                stopService(stopIntent);
                break;
            case R.id.btnStartIntentService:
                Intent startIntent2 = new Intent(this, MyIntentService.class);
                startService(startIntent2);
                break;
            default:
                break;
        }
    }
}
