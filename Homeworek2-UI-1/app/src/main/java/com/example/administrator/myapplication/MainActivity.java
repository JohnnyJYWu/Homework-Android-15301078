package com.example.administrator.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnLinearLayout;
    Button btnRelativeLayout;
    Button btnTableLayout;
    Button btnConstraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLinearLayout = (Button)findViewById(R.id.btnLinearLayout);
        btnRelativeLayout = (Button)findViewById(R.id.btnRelativeLayout);
        btnTableLayout = (Button)findViewById(R.id.btnTableLayout);
        btnConstraintLayout = (Button)findViewById(R.id.btnConstraintLayout);

        btnLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LinearLayoutActivity.class));
            }
        });
        btnRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RelativeLayoutActivity.class));
            }
        });
        btnTableLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TableLayoutActivity.class));
            }
        });
        btnConstraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ConstraintLayoutActivity.class));
            }
        });
    }
}
