package com.example.administrator.practice1_asynctask;

import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/4/11.
 */

public class UpdateUIAsyncTask extends AsyncTask {

    private TextView txtWorkProgress;
    private ProgressBar progressBar1;
    private ProgressBar progressBar2;
    private Button btnDownload;
    private ScrollView myscroller;
    private TextView txtReturnedValues;

    public UpdateUIAsyncTask(TextView txtWorkProgress, ProgressBar progressBar1, ProgressBar progressBar2,
                             Button btnDownload, ScrollView myscroller, TextView txtReturnedValues) {
        super();
        this.txtWorkProgress = txtWorkProgress;
        this.progressBar1 = progressBar1;
        this.progressBar2 = progressBar2;
        this.btnDownload = btnDownload;
        this.myscroller = myscroller;
        this.txtReturnedValues = txtReturnedValues;
    }

    protected void onPreExecute() {
        super.onPreExecute();
        txtWorkProgress.setText("Downloading...");
        progressBar1.setVisibility(View.VISIBLE);
        progressBar2.setVisibility(View.VISIBLE);
        btnDownload.setText("Downloading...");
        btnDownload.setEnabled(false);
        txtReturnedValues.setText("returned from thread...");
        myscroller.fullScroll(View.FOCUS_DOWN);
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        int i = 0;
        for (i = 0; i <= 100; i ++) {
            publishProgress(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return i + objects.toString();
    }

    protected void onProgressUpdate(Object[] values) {
        int value = (int) values[0];
        progressBar1.setProgress(value);
        progressBar1.setSecondaryProgress(value + 10);
        //progressBar1.incrementProgressBy(1);
//        progressBar2.setProgress(value);
//        progressBar2.setSecondaryProgress(value + 10);
        txtWorkProgress.setText("Downloading..." + value +"% has been finished");

        if(value % 10 == 0) {
            txtReturnedValues.append("\n return value: "+ value);
            myscroller.fullScroll(View.FOCUS_DOWN);
        }
    }

    protected void onPostExecute(Object o) {
        txtWorkProgress.setText("AsyncTask finished!");
        progressBar1.setVisibility(View.INVISIBLE);
        progressBar2.setVisibility(View.INVISIBLE);
        btnDownload.setText("Download");
        btnDownload.setEnabled(true);
        txtReturnedValues.append("\nDone\n back thread has been stopped");
        myscroller.fullScroll(View.FOCUS_DOWN);
    }
}
