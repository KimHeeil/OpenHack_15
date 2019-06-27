package com.example.openhack;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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


    Location location;

    private TextView mTextMessage;
    ActionBar actionBar;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menuitem_bottombar_left:
                    mTextMessage.setText("list");
                    return true;
                case R.id.menuitem_bottombar_search:
                    mTextMessage.setText("search");
                    return true;
                case R.id.menuitem_bottombar_right:
                    mTextMessage.setText("write");
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        Tab tab = null;
        tab = actionBar.newTab();
        tab.setText("지도로 보기");
        tab.setTabListener(listener);
        actionBar.addTab(tab);

        //두번째 Tab 객체 생성 및 ActionBar에 추가하기

        tab = actionBar.newTab();//ActionBar에 붇는 Tab객체 생성

        tab.setText("게시글로 보기");   //Tab에 보여지는 글씨

        //Tab의 선택이 변경되는 것을 인지하는 TabListener 설정(아래쪽 객체 생성 코드 참고)

        tab.setTabListener(listener);

        //ActionBar에 Tab 추가

        actionBar.addTab(tab);*/
        //액션바 설정하기//
        //액션바 타이틀 변경하기
        getSupportActionBar().setTitle("ACTIONBAR");
        //액션바 배경색 변경
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF339999));
        //홈버튼 표시
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //액션바 숨기기
        //hideActionBar();

        FragmentManager fragmentManager = getFragmentManager();
        MapFragment mapFragment = (MapFragment) fragmentManager
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


      /*  Button button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), listPage.class);
                startActivity(intent);
            }

        });

        Button button2 = findViewById(R.id.button3);
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), registerPage.class);
                startActivity(intent);
            }

        });*/
    }

    //Tab의 선택변화를 인지하는 Listener 객체 생성

    //(Button의 onClickListner 처럼 생각하시면 됩니다.)

    TabListener listener = new TabListener() {


        //Tab의 선택이 벗어날 때 호출

        //첫번째 파라미터 : 선택에서 벗어나는 Tab 객체

        //두번째 파라미터 : Tab에 해당하는 View를 Fragment로 만들때 사용하는 트랜젝션.(여기서는 사용X)

        @Override

        public void onTabUnselected(Tab tab, FragmentTransaction ft) {

            // TODO Auto-generated method stub


        }


        //Tab이 선택될 때 호출

        //첫번째 파라미터 : 선택된 Tab 객체

        //두번째 파라미터 : Tab에 해당하는 View를 Fragment로 만들때 사용하는 트랜젝션.(여기서는 사용X)

        @Override

        public void onTabSelected(Tab tab, FragmentTransaction ft) {

            // TODO Auto-generated method stub


            //선택된 Tab객체의 위치값(왼족 처음부터 0,1,2....순으로 됨)

            int position = tab.getPosition();


            switch (position) {

                case 0: //가장 왼쪽 Tab 선택(Analog)


                    //MainActivity가 보여 줄 View를

                    //res폴더>>layout폴더>>layout_tab_0.xml 로 설정

                    setContentView(R.layout.layout_tab_0);

                    break;


                case 1: //두번째 Tab 선택(Digital)


                    //MainActivity가 보여 줄 View를

                    //res폴더>>layout폴더>>layout_tab_1.xml 로 설정

                    setContentView(R.layout.layout_tab_1);

                    break;


            }


        }


        //Tab이 재 선택될 때 호출

        //첫번째 파라미터 : 재 선택된 Tab 객체

        //두번째 파라미터 : Tab에 해당하는 View를 Fragment로 만들때 사용하는 트랜젝션.(여기서는 사용X)

        @Override

        public void onTabReselected(Tab tab, FragmentTransaction ft) {

            // TODO Auto-generated method stub


        }

    };

    @Override
    public void onMapReady(final GoogleMap map) {


        //double latitude = location.getLatitude();
        //double longitude = location.getLongitude();
        LatLng SEOUL = new LatLng(35.95, 126.97);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(SEOUL);
        markerOptions.title("서울");
        markerOptions.snippet("한국의 수도");
        map.addMarker(markerOptions);

        map.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
        map.animateCamera(CameraUpdateFactory.zoomTo(10));
    }

}
