package com.example.openhack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Handler;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class registerPage extends AppCompatActivity {
    private TextView mTextMessage;
    String name;
    String date;
    String price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        Button nextButton = findViewById(R.id.button3);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText)findViewById(R.id.editText);
                EditText editText2 = (EditText)findViewById(R.id.editText2);
                EditText editText3 = (EditText)findViewById(R.id.editText3);
                name = editText.getText().toString();
                date = editText2.getText().toString();
                price = editText3.getText().toString();
                System.out.println("여기까지 굳");
                HttpPostData();
                Intent intent = new Intent(getApplicationContext(),registerPage2.class);
                startActivity(intent);
            }
        });
    }

    public void HttpPostData() {
        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("name", name);
        requestBody.addProperty("date", date);
        requestBody.addProperty("price", price);

        Call<JsonObject> request =  MainActivity.service.uploadPost(requestBody);

        request.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Log.d("uploadPostResult", "" + response.code());
            }
            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                // Code...
            }
        });
//        try{
//            URL url = new URL("http://10.10.2.124:3000/users/post");
//            HttpURLConnection http = (HttpURLConnection)url.openConnection();
//            http.setDefaultUseCaches(false);
//            http.setDoInput(true);
//            http.setDoOutput(true);
//            http.setRequestMethod("POST");
//
//            http.setRequestProperty("content-type", "application/x-www-form-urlencoded");
//
//            StringBuffer buffer = new StringBuffer();
//            buffer.append("name").append("=").append(name).append("&");
//            buffer.append("date").append("=").append(date).append("&");
//            buffer.append("price").append("=").append(price).append("&");
//            OutputStreamWriter outStream = new OutputStreamWriter(http.getOutputStream(), "EUC-KR");
//            PrintWriter writer = new PrintWriter(outStream);
//            writer.write(buffer.toString());
//            writer.flush();
//        } catch (MalformedURLException e) {
//            System.out.println("ㄲㅂ");
//        } catch (IOException e) {
//            System.out.println("ㄲㅂ");
//        }
    }
}
