package com.example.debugdemo.BaseUse;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.debugdemo.R;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/3/7 0007.
 */

public abstract class BaseTitleActivity extends BaseActivity{

    protected FrameLayout fl_content;
    protected boolean flag;

    protected TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basetitle);
        initParentView();
        getIntentData();
        initView();
        initData();


    }

    private void initParentView() {
        fl_content= (FrameLayout) findViewById(R.id.f1_content);
        tv_title= (TextView) findViewById(R.id.tv_middle_title);

    }


    protected void setChildLayout(int layout) {
        View view=getLayoutInflater().inflate(layout,fl_content,false);
        fl_content.addView(view);
        ButterKnife.bind(this);
    }

    protected abstract void getIntentData();

    protected  abstract void initView();

    protected  abstract void initData();


    protected boolean FirstLogin(){

        if (!flag){
            flag=true;
            return false;
        }
        flag=false;
      return true;
    }


}
