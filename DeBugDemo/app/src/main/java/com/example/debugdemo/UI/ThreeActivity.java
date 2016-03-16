package com.example.debugdemo.UI;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.debugdemo.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/1/2.
 *
 * 评论界面
 *
 */
public class ThreeActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener{
    private TextView tv_send,tv_change;
    private EditText et_pl;
    private ViewPager vp;
    private ArrayList<Fragment> fra_list;
    private MyViewPager myViewPager;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_three);

            initViews();

        }

    private void initViews() {
        initViewPager();
        tv_change= (TextView) findViewById(R.id.tv_changge);
        tv_send= (TextView) findViewById(R.id.tv_send);
        et_pl= (EditText) findViewById(R.id.ed_pinlun);

    }

    private void initViewPager() {
    vp= (ViewPager) findViewById(R.id.vp_content);


    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }



    public class MyViewPager extends FragmentPagerAdapter{
        private ArrayList<Fragment> listData;
        private FragmentManager fm;

        public MyViewPager(FragmentManager fm, ArrayList<Fragment> listData, FragmentManager fm1) {
            super(fm);
            this.listData = listData;
            fm = fm1;
        }

        public MyViewPager(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return listData.get(position);
        }

        @Override
        public int getCount() {
            return listData.size();
        }


        @Override
        public Fragment instantiateItem(ViewGroup container, int position) {
            Fragment fragment= (Fragment) super.instantiateItem(container,position);
            fm.beginTransaction().show(fragment).commit();
            return fragment;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            Fragment fragment=listData.get(position);
            fm.beginTransaction().hide(fragment).commit();
        }
    }









}
