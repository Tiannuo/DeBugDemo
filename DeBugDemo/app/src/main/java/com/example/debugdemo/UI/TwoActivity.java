package com.example.debugdemo.UI;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.debugdemo.Adapter.PagerAdapter;
import com.example.debugdemo.Fragmnet.MyFrag1;
import com.example.debugdemo.Fragmnet.MyFragment;
import com.example.debugdemo.R;

/**
 * Created by Administrator on 2015/12/31 0031.
 */
public class TwoActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private TabLayout tabLayout;
    private MyFragment myFragment;
    private MyFrag1 myFrag1;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private CoordinatorLayout coordinatorLayout;
    private AppBarLayout appBarLayout;
    private int distance;
    private Toolbar toolbar;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        initView();
        setupToolbar();

        setupViewPager(viewPager);

        setupCollapsingToolbar();

        
    }


    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {

      //  Log.i("===",  iv.getMeasuredWidth()+"   "+iv.getMeasuredHeight()+"==="+iv.getWidth()+"    "+iv.getHeight() +"==="+iv.getLayoutParams().width+"===="+iv.getLayoutParams().height);


        return super.onCreateView(parent, name, context, attrs);


    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.i("===", iv.getMeasuredWidth() + "   " + iv.getMeasuredHeight() + "===" + iv.getWidth() + "    " + iv.getHeight() + "===" + iv.getLayoutParams().width + "====" + iv.getLayoutParams().height);
        distance=iv.getMeasuredHeight()-toolbar.getMeasuredHeight();
    }

    private void initView() {
        viewPager= (ViewPager) findViewById(R.id.viewpager);
        iv= (ImageView) findViewById(R.id.iv_heard);
        coordinatorLayout= (CoordinatorLayout) findViewById(R.id.coordinatorLayout);

        tabLayout= (TabLayout) findViewById(R.id.tablayout);
        appBarLayout= (AppBarLayout) findViewById(R.id.appbarlayout);
        pagerAdapter=new PagerAdapter(getSupportFragmentManager());
        toolbar= (Toolbar) findViewById(R.id.toolbar);

     Log.i("===",  iv.getMeasuredWidth()+"   "+iv.getMeasuredHeight()+"==="+iv.getWidth()+"    "+iv.getHeight() +"==="+iv.getLayoutParams().width+"===="+iv.getLayoutParams().height);




        myFragment=new MyFragment();
        myFrag1=new MyFrag1();
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                Log.i("oooo",distance+"       "+verticalOffset+"");
                if (verticalOffset==0){
                    myFragment.changeStaus(0);


                }else if (verticalOffset==(-distance)){
                    myFragment.changeStaus(1);

                }else {
                    myFragment.changeStaus(2);
                }

            }
        });

    }

    private void setupCollapsingToolbar() {
        collapsingToolbarLayout= (CollapsingToolbarLayout) findViewById(R.id.collapsing);
        collapsingToolbarLayout.setTitleEnabled(false);

    }

    private void setupViewPager(ViewPager viewPager) {

       // pagerAdapter.addFra(myFragment,"Tab 1");
        pagerAdapter.addFra(myFragment,"Tab 2");

        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setupToolbar() {
        
    }
}
