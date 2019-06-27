package com.example.openhack;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface GithubService {
    @GET("users")
    Call<JsonArray> getUsers();
    @POST("users/post")
    Call<JsonObject> uploadPost(@Body JsonObject requestBody);
}
