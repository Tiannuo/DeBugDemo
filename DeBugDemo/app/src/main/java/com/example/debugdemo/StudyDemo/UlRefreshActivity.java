package com.example.debugdemo.StudyDemo;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.debugdemo.Adapter.UlrRefrshAdapter;
import com.example.debugdemo.Helper.Constants;
import com.example.debugdemo.R;

import java.util.ArrayList;
import java.util.Arrays;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.indicator.PtrIndicator;

/**
 * Created by Administrator on 2016/1/22 0022.
 */
public class UlRefreshActivity extends FragmentActivity {
    private ListView listView;
    private BaseAdapter adapter;
    private PtrClassicFrameLayout ptr;
    private ArrayList<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ulrefresh);
        initView();
    }

    private void initView() {
        LoadMoreView header=new LoadMoreView(this);
        listView= (ListView) findViewById(R.id.ptr_listview);
        list=new ArrayList<>();

        ptr= (PtrClassicFrameLayout) findViewById(R.id.ptr_main);
        ptr.setHeaderView(header);
        ptr.addPtrUIHandler(header);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ptr.autoRefresh();
            }
        }, 500);

        ptr.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                getData();
                ptr.refreshComplete();
            }
        });




    }

    public void getData() {
        list.addAll(Arrays.asList(Constants.SMALL_IMAGE_URLS));
        adapter=new UlrRefrshAdapter(this,list);
        listView.setAdapter(adapter);
    }

    public class LoadMoreView extends FrameLayout implements PtrUIHandler{
        //http://www.tuicool.com/articles/IJZnumI
        private LayoutInflater inflater;
        private ViewGroup headView;
        private TextView tv_head;
        private ImageView iv_head;

        public LoadMoreView(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public LoadMoreView(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
        }

        public LoadMoreView(Context context) {
            super(context);
            init(context);
        }

        private void init(Context context) {
                inflater=LayoutInflater.from(context);
                headView= (ViewGroup) inflater.inflate(R.layout.header_morelayout,this,true);
               // tv_head= (TextView) headView.findViewById(R.id.tv_headmore);
            tv_head.setText("下拉刷新逗比");
        }

        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        public LoadMoreView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
            super(context, attrs, defStyleAttr, defStyleRes);
        }

        @Override
        public void onUIReset(PtrFrameLayout frame) {
            tv_head.setText("下拉刷新逗比");
        }

        @Override
        public void onUIRefreshPrepare(PtrFrameLayout frame) {
            tv_head.setText("下拉刷新逗比");
        }

        @Override
        public void onUIRefreshBegin(PtrFrameLayout frame) {
            tv_head.setText("正在刷新逗比");
        }

        @Override
        public void onUIRefreshComplete(PtrFrameLayout frame) {
            tv_head.setText("刷新完成逗比");
        }

        @Override
        public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator) {
            final int mOffsetToRefresh = frame.getOffsetToRefresh();
            final int currentPos = ptrIndicator.getCurrentPosY();
            final int lastPos = ptrIndicator.getLastPosY();



            if (currentPos < mOffsetToRefresh && lastPos >= mOffsetToRefresh) {
                if (isUnderTouch && status == PtrFrameLayout.PTR_STATUS_PREPARE) {
                    tv_head.setText("下拉刷新逗比");
                }
            } else if (currentPos > mOffsetToRefresh && lastPos <= mOffsetToRefresh) {
                if (isUnderTouch && status == PtrFrameLayout.PTR_STATUS_PREPARE) {
                    tv_head.setText("松开刷新逗比");
                }
            }




















        }







    }

}
