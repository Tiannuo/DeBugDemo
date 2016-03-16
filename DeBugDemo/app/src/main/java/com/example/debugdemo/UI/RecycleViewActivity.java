package com.example.debugdemo.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.debugdemo.Adapter.ReCycleAdapter;
import com.example.debugdemo.Helper.DividerItemDecoration;
import com.example.debugdemo.R;
import com.handmark.pulltorefresh.library.PullToRecycleView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/2/2 0002.
 */
public class RecycleViewActivity extends AppCompatActivity {
    private PullToRecycleView pullToRecycleView;
    private RecyclerView recyclerView;
    private ArrayList<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);
        list=new ArrayList<>();
        //   SyLinearLayoutManager manager=new SyLinearLayoutManager(RecycleViewActivity.this);
         LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        for (int i=0;i<10;i++){
            list.add("Item+"+i);
        }
        pullToRecycleView= (PullToRecycleView) findViewById(R.id.recyview);
        recyclerView= pullToRecycleView.getRefreshableView();
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(RecycleViewActivity.this, R.drawable.divier_gray, LinearLayoutManager.VERTICAL));
       //recyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this).build());
        //recyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this).color(Color.RED).size(1).margin(2,10).build());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new ReCycleAdapter(RecycleViewActivity.this, list));




        pullToRecycleView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<RecyclerView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
                pullToRecycleView.onRefreshComplete();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
                pullToRecycleView.onRefreshComplete();
            }
        });
    }
}
