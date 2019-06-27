package com.example.openhack;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class listPage extends AppCompatActivity {
    private ArrayList<HashMap<String, String>> Data = new ArrayList<HashMap<String, String>>();
    private HashMap<String, String> InputData1 = new HashMap<>();
    private HashMap<String, String> InputData2 = new HashMap<>();

    private list_ItemAdapter adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_page);

        listView = (ListView) findViewById(R.id.List_view);

        //데이터 초기화
        setContentView(R.layout.activity_list_page);

        adapter = new list_ItemAdapter();
        listView = (ListView) findViewById(R.id.List_view);
        for(int i=0; i<10; i++) {
            TypedArray arrResId = getResources().obtainTypedArray(R.array.resId);
            list_Item dto = new list_Item();
            dto.setProfileImage(arrResId.getResourceId(0, 0));
            dto.setStoreName("test");
            dto.setPayPerHour("test11");
            dto.setWriteTime("test123");
            adapter.addItem(dto);
         }
            listView.setAdapter(adapter);
    }
/*
    private void setData() {
        TypedArray arrResId = getResources().obtainTypedArray(R.array.resId);
        String[] titles = getResources().getStringArray(R.array.title);
        String[] payPerHours = getResources().getStringArray(R.array.content);
        String[] writeTime = getResources().getStringArray(R.array.content);


        for (int i = 0; i < arrResId.length(); i++) {
            list_Item dto = new list_Item();
            dto.setProfileImage(arrResId.getResourceId(i, 0));
            dto.setStoreName(titles[i]);
            dto.setPayPerHour(payPerHours[i]);
            dto.getWriteTime(writeTime);

            adapter.addItem(dto);
        }
    }
*/
    }

