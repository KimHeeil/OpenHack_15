package com.example.openhack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.os.Handler;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class registerPage2 extends AppCompatActivity {
        int mYear, mMonth, mDay;
        private Button mTxtDate ;
        private Button mTxtDateend;
        int btnSelected;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register_page2);
            //텍스트뷰 2개 연결
            mTxtDate=findViewById(R.id.startDateBtn);
            mTxtDateend=findViewById(R.id.endDateBtn);
            Calendar cal = new GregorianCalendar();

            mYear = cal.get(Calendar.YEAR);
            mMonth = cal.get(Calendar.MONTH);
            mDay = cal.get(Calendar.DAY_OF_MONTH);
            btnSelected=2;
            UpdateNow();
            btnSelected=1;
            UpdateNow();


            Button nextButton = findViewById(R.id.nextButton);
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(),"등록되었습니다.",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }
            });
        }

        public void mOnClick(View v){
                    //여기서 리스너도 등록함
            switch(v.getId()){

                //날짜 대화상자 버튼이 눌리면 대화상자를 보여줌
                case R.id.startDateBtn:
                    //여기서 리스너도 등록함

                    new DatePickerDialog(registerPage2.this, mDateSetListener, mYear,
                            mMonth, mDay).show();
                    btnSelected =1;
                    break;
                //시간 대화상자 버튼이 눌리면 대화상자를 보여줌
                case R.id.endDateBtn:
                    //여기서 리스너도 등록함
                    new DatePickerDialog(registerPage2.this, mDateSetListener, mYear,
                            mMonth, mDay).show();
                    btnSelected=2;
                    break;
            }


        }


    DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear,

                                      int dayOfMonth) {

                    // TODO Auto-generated method stub

                    //사용자가 입력한 값을 가져온뒤
                    mYear = year;
                    mMonth = monthOfYear;
                    mDay = dayOfMonth;

                    //텍스트뷰의 값을 업데이트함
                    UpdateNow();
                }
            };

        void UpdateNow(){

            if(btnSelected==1)
            {
                String temp= String.format("%d  /  %d  /  %d ",mYear,mMonth+1,mDay);
                mTxtDate.setText(temp);
            }
            else if(btnSelected==2)
            {
                String temp= String.format("%d  /  %d  /  %d ",mYear,mMonth+1,mDay);
                mTxtDateend.setText(temp);
            }


        }

    }

