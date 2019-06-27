package com.example.openhack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class jobDetailPage extends AppCompatActivity {
    private TextView mTextMessage;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menuitem_bottombar_left:
                    Intent intent = new Intent(jobDetailPage.this, scrapPage.class);
                    startActivity(intent);
                    break;

                case R.id.menuitem_bottombar_search:
                    Intent intent2 = new Intent(jobDetailPage.this, registerPage.class);
                    startActivity(intent2);
                    break;
                case R.id.menuitem_bottombar_right:
                    Intent intent3 = new Intent(jobDetailPage.this, listPage.class);
                    startActivity(intent3);
                    break;
            }
            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_detail_page);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
