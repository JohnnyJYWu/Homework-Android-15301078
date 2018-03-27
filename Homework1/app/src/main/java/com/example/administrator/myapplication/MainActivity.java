package com.example.administrator.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnDail;
    Button btnCall;
    Button btnBrowser;

    Uri phoneNum;
    Uri webUrl;
    private final int REQUEST_CODE = 0x1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //申请拨号权限
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE);

        btnDail = (Button)findViewById(R.id.btnDial);
        btnCall = (Button)findViewById(R.id.btnCall);
        btnBrowser = (Button)findViewById(R.id.btnBrowser);

        phoneNum = Uri.parse("tel:18813067600");
        webUrl = Uri.parse("http://www.baidu.com");

        btnDail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, phoneNum);
                startActivity(intent);
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (MainActivity.this.checkCallingPermission(Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED) {}
//                Intent intent = new Intent(Intent.ACTION_CALL, phoneNum);
//                startActivity(intent);

                //对于Android6.0版本及以上，需要动态申请拨号权限
                if (Build.VERSION.SDK_INT >= 23) {
                    //判断有没有拨打电话权限
                    if (PermissionChecker.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        //请求拨打电话权限
                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE);
                    } else {
                        Intent intent = new Intent(Intent.ACTION_CALL, phoneNum);
                        startActivity(intent);
                    }
                } else {
                    Intent intent = new Intent(Intent.ACTION_CALL, phoneNum);
                    startActivity(intent);
                }
            }
        });

        btnBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, webUrl);
                startActivity(intent);
            }
        });
    }
}
