package com.cam.luyentapgiaodien.bai5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProvinceActivity extends AppCompatActivity {

    private TextView textView;
    private String[] arrData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_province);
        textView = (TextView) findViewById(R.id.tv_textView);
        arrData = getResources().getStringArray(R.array.province);
        Intent intent = getIntent();
        int id = intent.getIntExtra("idProvince",0);
        textView.setText(arrData[id]);


    }
}

