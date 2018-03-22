package com.cam.luyentapgiaodien.bai6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private String[] arrData;

    private ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lv_listView);

        arrData = getResources().getStringArray(R.array.province);
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrData);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MainActivity.this,ProvinceActivity.class);
                intent.putExtra("idProvince", i);
                startActivity(intent);
            }
        });
        // arrayAdapter.notifyDataSetChanged();
    }
}
