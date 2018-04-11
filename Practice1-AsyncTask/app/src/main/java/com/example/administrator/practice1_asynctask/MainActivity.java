package com.example.administrator.practice1_asynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtWorkProgress;
    Button btnDownload;
    ProgressBar progressBar1;
    ProgressBar progressBar2;
    ScrollView myscroller;
    TextView txtReturnedValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtWorkProgress = (TextView) findViewById(R.id.txtWorkProgress);
        btnDownload = (Button) findViewById(R.id.btnDownload);
        progressBar1 = (ProgressBar) findViewById(R.id.progress1);
        progressBar2 = (ProgressBar) findViewById(R.id.progress2);
        myscroller = (ScrollView) findViewById(R.id.myscroller);
        txtReturnedValues = (TextView) findViewById(R.id.txtReturnedValues);

        progressBar1.setVisibility(View.INVISIBLE);
        progressBar2.setVisibility(View.INVISIBLE);

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateUIAsyncTask updateUIAsyncTask =
                        new UpdateUIAsyncTask(txtWorkProgress, progressBar1, progressBar2, btnDownload, myscroller, txtReturnedValues);
                updateUIAsyncTask.execute();
            }
        });
    }
}
