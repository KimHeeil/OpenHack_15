package com.example.openhack;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private TextView mTextMessage;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menuitem_bottombar_left:
                    Intent intent = new Intent(MainActivity.this, scrapPage.class);
                    startActivity(intent);
                    break;

                case R.id.menuitem_bottombar_search:
                    Intent intent2 = new Intent(MainActivity.this, registerPage.class);
                    startActivity(intent2);
                    break;
                case R.id.menuitem_bottombar_right:
                    Intent intent3 = new Intent(MainActivity.this, registerPage.class);
                    startActivity(intent3);
                    break;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TabHost tabHost1 = (TabHost) findViewById(R.id.tabHost1);
        tabHost1.setup();

        TabHost.TabSpec ts1 = tabHost1.newTabSpec("Tab Spec 1");
        ts1.setContent(R.id.content1);
        ts1.setIndicator("지도로 보기");
        tabHost1.addTab(ts1);

        TabHost.TabSpec ts2 = tabHost1.newTabSpec("Tab Spec 2") ;
        ts2.setContent(R.id.content2) ;
        ts2.setIndicator("게시물로 보기") ;
        tabHost1.addTab(ts2) ;

        FragmentManager fragmentManager = getFragmentManager();
        MapFragment mapFragment = (MapFragment) fragmentManager
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }




    @Override
    public void onMapReady(final GoogleMap map) {
        //double latitude = location.getLatitude();
        //double longitude = location.getLongitude();
        LatLng SEOUL = new LatLng(35.95, 126.97);
        LatLng SEOUL1 = new LatLng(35.950400, 126.975391);

        LatLng SEOUL2 = new LatLng(35.950800, 126.975091);

        LatLng SEOUL3 = new LatLng(35.950400, 126.975891);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(SEOUL);
        markerOptions.title("빠리바게트");
        markerOptions.snippet("1일 단기알바");
        map.addMarker(markerOptions);

        MarkerOptions markerOptions1 = new MarkerOptions();
        markerOptions1.position(SEOUL1);
        markerOptions1.title("베스킨 라빈스");
        markerOptions1.snippet("3일 급구");
        map.addMarker(markerOptions1);

        MarkerOptions markerOptions2 = new MarkerOptions();
        markerOptions2.position(SEOUL2);
        markerOptions2.title("사무실 이전");
        markerOptions2.snippet("3시간 구합니다.");
        map.addMarker(markerOptions2);

        MarkerOptions markerOptions3 = new MarkerOptions();
        markerOptions3.position(SEOUL3);
        markerOptions3.title("피시방 대타");
        markerOptions3.snippet("28일 하루 야간 대타구해요.");
        map.addMarker(markerOptions3);


        map.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
        map.animateCamera(CameraUpdateFactory.zoomTo(15));
    }



    }

