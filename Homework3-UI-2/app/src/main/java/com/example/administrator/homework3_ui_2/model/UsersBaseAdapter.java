package com.example.administrator.homework3_ui_2.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.homework3_ui_2.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/4/4.
 */

public class UsersBaseAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<User> users;

    public UsersBaseAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        User user = (User)getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(this.context).inflate(R.layout.item_user, parent, false);
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
