package com.example.openhack;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class list_ItemAdapter extends BaseAdapter{

    private ArrayList<list_Item> listCustom = new ArrayList<>();

    @Override
    public int getCount() {
        return listCustom.size();
    }

    @Override
    public Object getItem(int position) {
        return listCustom.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
     CustomViewHolder holder;
        if (convertView == null) {

            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null, false);

            holder = new CustomViewHolder();

            holder.imageView = (ImageView) convertView.findViewById(R.id.imageView1);
            holder.textStoreName = (TextView) convertView.findViewById(R.id.textView1);
            holder.textPayPerHour = (TextView) convertView.findViewById(R.id.textView2);
            holder.textWriteTime = (TextView) convertView.findViewById(R.id.textView3);


            convertView.setTag(holder);
        } else {
            holder = (CustomViewHolder) convertView.getTag();
        }

        list_Item dto = listCustom.get(position);

        holder.imageView.setImageResource(dto.getProfileImage());
        holder.textStoreName.setText(dto.getStoreName());
        holder.textPayPerHour.setText(dto.getPayPerHour());
        holder.textWriteTime.setText(dto.getWriteTime());

        return convertView;
    }

    class CustomViewHolder {
        ImageView imageView;
        TextView textStoreName;
        TextView textWriteTime;
        TextView textPayPerHour;
    }

    // MainActivity에서 Adapter에있는 ArrayList에 data를 추가시켜주는 함수
    public void addItem(list_Item dto) {
        listCustom.add(dto);
    }
}

