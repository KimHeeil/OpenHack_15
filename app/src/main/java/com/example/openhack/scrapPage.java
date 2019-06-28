package com.example.openhack;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class scrapPage extends AppCompatActivity {

    private TextView mTextMessage;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menuitem_bottombar_left:
                    Intent intent = new Intent(scrapPage.this, listPage.class);
                    startActivity(intent);
                    break;

                case R.id.menuitem_bottombar_search:
                    Intent intent2 = new Intent(scrapPage.this, jobDetailPage.class);
                    startActivity(intent2);

                    break;
                case R.id.menuitem_bottombar_right:
                    Intent intent3 = new Intent(scrapPage.this, registerPage.class);
                    startActivity(intent3);

                    break;
            }
            return false;
        }
    };
    ListView listView;
    list_ItemAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_scrap_page);

        listView =  findViewById(R.id.List_view);
        adapter = new list_ItemAdapter();

        listView =  findViewById(R.id.List_view);
        for(int i=0; i<10; i++) {
            TypedArray arrResId = getResources().obtainTypedArray(R.array.resId);
            list_Item dto = new list_Item();
            dto.setProfileImage(arrResId.getResourceId(0, 0));
            dto.setStoreName("스크랩" );
            dto.setPayPerHour("무급");
            dto.setWriteTime("2019-03-16 ~ 2019-05-09");
            adapter.addItem(dto);
        }
        listView.setAdapter(adapter);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
