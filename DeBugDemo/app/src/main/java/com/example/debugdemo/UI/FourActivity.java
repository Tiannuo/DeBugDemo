package com.example.debugdemo.UI;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.debugdemo.Fragmnet.MyFrag1;
import com.example.debugdemo.R;

/**
 * Created by Administrator on 2016/1/15 0015.
 */
public class FourActivity extends FragmentActivity {
    private MyFrag1 myFrag1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        myFrag1=new MyFrag1();

        getSupportFragmentManager().beginTransaction().replace(R.id.fra_contain,myFrag1).commit();

    }
}
