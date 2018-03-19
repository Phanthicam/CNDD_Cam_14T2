package com.cam.problem7giaiphuongtrinhbachai;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends Activity implements View.OnClickListener {
    private TextView tvResult;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        initView();
        Intent intent = getIntent(); //Lấy intent đã gọi đến
        Bundle bundle = intent.getBundleExtra("myBudle"); //Lấy bundle gởi theo intent
        //Lấy 2 giá trị a và b từ bundle
        int a = bundle.getInt("soA", 0);
        int b = bundle.getInt("soB", 0);

        giaiPTBN(a, b);      //Xu ly ket qua
    }

    void initView() {
        btnBack = findViewById(R.id.btn_back);
        tvResult = findViewById(R.id.tv_result);
        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
        }

    }

    void giaiPTBN(int a, int b) {
        if (a == 0) {
            if (b == 0) {
                tvResult.setText("Phuơng trình vô số nghiệm");
            } else {
                tvResult.setText("Phương trình vô nghiệm");
            }
        } else {
            tvResult.setText("Nghiệm của phương trình là: " + (float) -b / a);
        }
    }
}
