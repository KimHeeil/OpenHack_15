package com.example.openhack;

import android.graphics.drawable.Drawable;

public class list_Item {
    private int profileImage ;
    private String storeName ;
    private String payPerHour ;
    private String writeTime;


    public void setProfileImage(int profileImage) {
        this.profileImage = profileImage ;
    }
    public void setStoreName(String storeName) {
        this.storeName = storeName ;
    }
    public void setPayPerHour(String payPerHour) {
        this.payPerHour = payPerHour ;
    }
    public void setWriteTime(String writeTime) {
        this.writeTime = writeTime ;
    }

    public int getProfileImage() {
        return this.profileImage ;
    }
    public String getStoreName() { return this.storeName ; }
    public String getPayPerHour() {
        return this.payPerHour ;
    }
    public String getWriteTime() {
        return this.writeTime;
    }
}
