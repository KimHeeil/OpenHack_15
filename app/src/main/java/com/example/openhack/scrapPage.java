package com.example.openhack;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;

import android.content.Intent;
import android.content.res.TypedArray;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import android.widget.Toast;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class scrapPage extends AppCompatActivity {
    private TextView mTextMessage;//bottom navigation 관련 변수

    private list_ItemAdapter adapter; //리스트 뷰 관련 변수
    private ListView listView; //리스트 뷰 관련 변수

    //bottom navigation 연결 부분입니다.///////////////////
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
    ///////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrap_page);


        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }
}

