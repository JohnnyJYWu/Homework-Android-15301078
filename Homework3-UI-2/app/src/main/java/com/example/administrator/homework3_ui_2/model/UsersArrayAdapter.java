package com.example.administrator.homework3_ui_2.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.homework3_ui_2.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/4/3.
 */

public class UsersArrayAdapter extends ArrayAdapter<User> {
    public UsersArrayAdapter(Context context, ArrayList<User> users) {
        super(context, 0, users);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        User user = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent, false);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        TextView tvID = (TextView) convertView.findViewById(R.id.tvID);

        imageView.setImageDrawable(user.getImg());
        tvName.setText(user.getName());
        tvID.setText(user.getId());

        return convertView;
    }
}