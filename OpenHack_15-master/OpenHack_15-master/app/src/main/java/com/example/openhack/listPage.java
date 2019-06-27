package com.example.openhack;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.HashMap;

public class listPage extends AppCompatActivity {
    private ArrayList<HashMap<String, String>> Data = new ArrayList<HashMap<String, String>>();
    private HashMap<String, String> InputData1 = new HashMap<>();
    private HashMap<String, String> InputData2 = new HashMap<>();

    private list_ItemAdapter adapter;
    private ListView listView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menuitem_bottombar_left:
                    Intent intent = new Intent(listPage.this, scrapPage.class);
                    startActivity(intent);

                    break;

                case R.id.menuitem_bottombar_search:
                    Intent intent2 = new Intent(listPage.this, registerPage.class);
                    startActivity(intent2);

                    break;
                case R.id.menuitem_bottombar_right:
                    Intent intent3 = new Intent(listPage.this, listPage.class);
                    startActivity(intent3);

                    break;
            }
            return false;
        }
    };
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
    public void btnClick(View view)
    {
        Toast.makeText(getApplicationContext(),"스크랩 되었습니다.",Toast.LENGTH_SHORT).show();
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

