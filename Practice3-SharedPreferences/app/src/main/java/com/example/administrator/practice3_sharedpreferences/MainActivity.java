package com.example.administrator.practice3_sharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvInputName;
    TextView tvInputID;
    TextView tvOutputName;
    TextView tvOutputID;
    TextView tvName;
    TextView tvID;

    EditText editInputName;
    EditText editInputID;

    Button btnSave;
    Button btnRead;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        tvInputName = (TextView) findViewById(R.id.tvInputName);
        tvInputID = (TextView) findViewById(R.id.tvInputID);
        tvOutputName = (TextView) findViewById(R.id.tvOutputName);
        tvOutputID = (TextView) findViewById(R.id.tvOutputID);
        tvName = (TextView) findViewById(R.id.tvName);
        tvID = (TextView) findViewById(R.id.tvID);

        editInputName = (EditText) findViewById(R.id.editInputName);
        editInputID = (EditText) findViewById(R.id.editInputID);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnRead = (Button) findViewById(R.id.btnRead);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveInfo(editInputName.getText().toString(), editInputID.getText().toString());
            }
        });
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readInfo();
            }
        });
    }

    private static final String STUDENT_INFO = "userInfo";
    private static final String STUDENT_NAME = "STUDENT_NAME";
    private static final String STUDENT_ID = "STUDENT_ID";

    private void saveInfo(String name, String ID) {
        SharedPreferences sharedPreferences = getSharedPreferences(STUDENT_INFO, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(STUDENT_NAME, name);
        editor.putString(STUDENT_ID, ID);

//        System.out.println(name);
//        System.out.println(ID);

        editor.commit();
        Toast.makeText(this, "Save Successful", Toast.LENGTH_SHORT).show();
    }

    private void readInfo() {
        SharedPreferences sharedPreferences = getSharedPreferences(STUDENT_INFO, Activity.MODE_PRIVATE);
        String name = sharedPreferences.getString(STUDENT_NAME, "defaultName");
        String ID = sharedPreferences.getString(STUDENT_ID, "defaultID");

//        System.out.println(name);
//        System.out.println(ID);

        tvName.setText(name);
        tvID.setText(ID);

        Toast.makeText(this, "Read Successful", Toast.LENGTH_SHORT).show();
    }
}
