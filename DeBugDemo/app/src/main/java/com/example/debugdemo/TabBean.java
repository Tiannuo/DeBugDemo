package com.example.debugdemo;

/**
 * Created by Administrator on 2016/1/18 0018.
 */
public class TabBean {
    private int title,icon;
    private Class fragment;




    public TabBean(int icon, Class fragment, int title) {
        this.icon = icon;
        this.fragment = fragment;
        this.title = title;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public Class getFragment() {
        return fragment;
    }

    public void setFragment(Class fragment) {
        this.fragment = fragment;
    }
}
