package com.cam.problem6_event;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;
public class MainActivity extends AppCompatActivity implements OnClickListener{
    private EditText edtA,edtB;
    Button btnCong2So;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        btnCong2So.setOnClickListener(this);
        /*btnCong2So.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //lấy dự liệu từ edittext
                String strA = edtA.getText().toString().trim();
                String strB = edtB.getText().toString().trim();

                if(strA.length() == 0 || strB.length() == 0){
                    //kiểm tra dữ liệu đã nhập đủ hay chưa?

                    Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ dữ liệu!", Toast.LENGTH_SHORT).show();
                }else{
                    int a = Integer.parseInt(edtA.getText()+"");
                    int b = Integer.parseInt(edtB.getText()+"");
                    tvResult.setText((a+b)+"");
                }

            }
        });*/
    }
    public void initView(){
        edtA = (EditText) findViewById(R.id.edt_a);
        edtB = (EditText) findViewById(R.id.edt_b);
        btnCong2So = (Button) findViewById(R.id.btn_tong2so);
        tvResult = (TextView) findViewById(R.id.tv_result);
    }
    @Override
    public void onClick(View arg0){
        String strA = edtA.getText().toString().trim();
        String strB = edtB.getText().toString().trim();

        if(strA.length() == 0 || strB.length() == 0){
            Toast.makeText(MainActivity.this, "Vui lòng nhập đủ dữ liệu!!", Toast.LENGTH_SHORT).show();
        }else{
            int a = Integer.parseInt(edtA.getText()+"");
            int b = Integer.parseInt(edtB.getText()+"");
            tvResult.setText((a+b)+"");
        }

    }
   /* public void tong2so(View v){
       String strA = edtA.getText().toString().trim();
       String strB = edtB.getText().toString().trim();

       if(strA.length() == 0 || strB.length() == 0){
           Toast.makeText(MainActivity.this, "Vui lòng nhập số!", Toast.LENGTH_SHORT).show();
       }else{
           int a = Integer.parseInt(edtA.getText()+"");
           int b = Integer.parseInt(edtB.getText()+"");
           tvResult.setText((a+b)+"");
       }


    }*/

}