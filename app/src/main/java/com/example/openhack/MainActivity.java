package com.example.openhack;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private TextView mTextMessage;
    FloatingActionButton floatingActionButton1;

    GoogleMap googleMap;

    private list_ItemAdapter adapter; //리스트 뷰 관련 변수
    private ListView listView; //리스트 뷰 관련 변수
    //아래쪽에 선택하면 연결해주는 부분
    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menuitem_bottombar_left:
                    Intent intent = new Intent(MainActivity.this, listPage.class);
                    startActivity(intent);
                    break;

                case R.id.menuitem_bottombar_search:
                    Intent intent2 = new Intent(MainActivity.this, jobDetailPage.class);
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
        /////////이부분이 bottomNavigation입니다.
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
/////////////////////////////////이부분은 리스뷰 실행부분입니다.///-Jaemin/
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


/////////////////////////////////이부분은 리스뷰 실행부분입니다.///-Jaemin/
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this ,"test",Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this,jobDetailPage.class);
                startActivity(intent);


            }
        });
    }


    public void btnClick(View view)
    {
        Toast.makeText(getApplicationContext(),"스크랩 되었습니다.",Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng SEOUL = new LatLng(35.95, 126.97);
        LatLng SEOUL1 = new LatLng(35.950400, 126.976491);
        LatLng SEOUL2 = new LatLng(35.951200, 126.975091);
        LatLng SEOUL3 = new LatLng(35.949600, 126.974291);
/*
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

*/
        this.googleMap = googleMap;
        this.googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        this.googleMap.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
        this.googleMap.animateCamera(CameraUpdateFactory.zoomTo(15));

        onAddMarker(SEOUL,"빠리바게트", "대타구해요!!");
        onAddMarker(SEOUL1,"베스킨 라빈스","3일 급구");
        onAddMarker(SEOUL2,"사무실 이전", "3시간 구합니다.");
        onAddMarker(SEOUL3,"피시방 대타", "28일 하루 야간 대타구해요");

        this.googleMap.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
        this.googleMap.animateCamera(CameraUpdateFactory.zoomTo(15));
    }
    public void onAddMarker(LatLng lat, String S, String Snip){
        LatLng position = lat;
        //나의위치 마커
        MarkerOptions mymarker = new MarkerOptions()
                .icon(BitmapDescriptorFactory.defaultMarker(200f))  //마커색상지정
                .title(S)
                .snippet(Snip)
                .position(position);   //마커위치

        //마커추가
        this.googleMap.addMarker(mymarker);

        //정보창 클릭 리스너
        googleMap.setOnInfoWindowClickListener(infoWindowClickListener);

        //마커 클릭 리스너
        this.googleMap.setOnMarkerClickListener(markerClickListener);


    }
    //정보창 클릭 리스너
    GoogleMap.OnInfoWindowClickListener infoWindowClickListener = new GoogleMap.OnInfoWindowClickListener() {
        @Override
        public void onInfoWindowClick(Marker marker) {
            String markerId = marker.getId();
            Toast.makeText(MainActivity.this, "정보창 클릭 Marker ID : "+markerId, Toast.LENGTH_SHORT).show();
        }
    };

    //마커 클릭 리스너
    GoogleMap.OnMarkerClickListener markerClickListener = new GoogleMap.OnMarkerClickListener() {
        @Override
        public boolean onMarkerClick(Marker marker) {
            String markerId = marker.getId();
            //선택한 타겟위치
            LatLng location = marker.getPosition();
            Toast.makeText(MainActivity.this, "마커 클릭 Marker ID : "+markerId+"("+location.latitude+" "+location.longitude+")", Toast.LENGTH_SHORT).show();

            return false;
        }
    };



    }

