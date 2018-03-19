package com.cam.problem7giaiphuongtrinhbachai;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    private EditText edtA, edtB;
    private Button btnResutl;
    //Tạo đối tượng SharedPreferences và Editor để lưu dữ liệu
    private SharedPreferences pre;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    void initView() {
        btnResutl = findViewById(R.id.btn_result);
        edtA = findViewById(R.id.edt_a);
        edtB = findViewById(R.id.edt_b);
        pre = getSharedPreferences("DATA", MODE_PRIVATE);
        editor = pre.edit();
        //Set status khi mới run app là false
        editor.putBoolean("status", false);
        editor.commit();
        btnResutl.setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        //Kiểm tra nếu biến status là true (nghĩa là từ ResultActivity trở về) thì reset editText và show toast
        if (pre.getBoolean("status", false)) {
            edtA.setText("0");
            edtB.setText("0");
            Toast.makeText(this, "Wellcome back to MainActivity ! Your last edit text : a = " + pre.getInt("soA", 0) + ", b = " + pre.getInt("soB", 0), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_result:
                int a, b;
                try {
                    a = Integer.parseInt(edtA.getText().toString());
                    b = Integer.parseInt(edtB.getText().toString());
                    //Lưu 2 giá trị a, b và biến status là true vào bộ nhớ trước khi chuyển sang ResultActivity
                    editor.putInt("soA", a);
                    editor.putInt("soB", b);
                    editor.putBoolean("status", true);
                    editor.commit();

                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);    //Tao intent de chuyen qua man hinh ResultActivity
                    Bundle bundle = new Bundle();       //Tao bundle de dong goi du lieu goi kem theo intent

                    //dua tung du lieu da nhap vao 2 edit text vao bundle
                    bundle.putInt("soA", a);
                    bundle.putInt("soB", b);

                    intent.putExtra("myBudle", bundle);      //dua bundle vao intent

                    startActivity(intent);      //Mo ResultActivity bang intent
                } catch (Exception e) {
                    System.out.print(e);
                    Toast.makeText(this, "Have an error! Please check input type!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
