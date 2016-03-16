package com.example.debugdemo.Fragmnet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.debugdemo.R;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/1/15 0015.
 */
public class MyFrag1 extends Fragment {

    private ArrayList<String> list;
    private   PullToRefreshListView pullToRefreshListView;
    private ListView listView;
    private MyAdapter myAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        list=new ArrayList<>();

        return inflater.inflate(R.layout.frag_my1, null);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
      pullToRefreshListView= (PullToRefreshListView) view.findViewById(R.id.mylistview);
        listView=pullToRefreshListView.getRefreshableView();
        listView.setEmptyView(view.findViewById(R.id.myText));
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        myAdapter=new MyAdapter();
        listView.setAdapter(myAdapter);


        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                for (int i=0;i<8;i++){
                    list.add("Item"+i);
                }
                myAdapter.notifyDataSetChanged();

                pullToRefreshListView.onRefreshComplete();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

            }
        });

    }



    public class MyAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder=null;
            if (convertView==null){
                viewHolder=new ViewHolder();
                convertView=LayoutInflater.from(getActivity()).inflate(R.layout.item_myfragment,null);
                viewHolder.tv= (TextView) convertView.findViewById(R.id.tv);
                convertView.setTag(viewHolder);
            }else {
                viewHolder= (ViewHolder) convertView.getTag();
            }
            viewHolder.tv.setText(list.get(position));


            return convertView;
        }


        class ViewHolder{
            TextView tv;

        }



    }
}
