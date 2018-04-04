package com.example.administrator.homework3_ui_2.model;

import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2018/4/3.
 */

public class User {
    private String name;
    private String id;
    private Drawable img;

    public User(){}

    public User(String name, String id, Drawable img) {
        this.name = name;
        this.id = id;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Drawable getImg() {
        return img;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }
}
