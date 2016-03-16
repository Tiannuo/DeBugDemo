package com.example.debugdemo.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/12 0012.
 */
public class PagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> list_fra=new ArrayList<>();
    private List<String> list_title=new ArrayList<>();

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return list_fra.get(position);
    }

    @Override
    public int getCount() {
        return list_fra.size();
    }

    public void  addFra(Fragment fragment,String title){
        list_fra.add(fragment);
        list_title.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list_title.get(position);
    }
}
