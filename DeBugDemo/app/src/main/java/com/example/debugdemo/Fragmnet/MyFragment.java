package com.example.debugdemo.Fragmnet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.debugdemo.R;
import com.handmark.pulltorefresh.library.PullNestedScrolView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/12/31 0031.
 */
public class MyFragment extends Fragment {
    private ArrayList<String> list;
    private PullNestedScrolView pullNestedScrolView;
    private ListView listView;
    private MyAdapter myAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        list=new ArrayList<>();





        return inflater.inflate(R.layout.frag_my, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public void changeStaus(int flag){
            if (flag==0){
                pullNestedScrolView.setMode(PullToRefreshBase.Mode.PULL_FROM_START);

            }else if (flag==1){
                pullNestedScrolView.setMode(PullToRefreshBase.Mode.PULL_FROM_END);

            }else if (flag==2) {
                pullNestedScrolView.setMode(PullToRefreshBase.Mode.DISABLED);

            }

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView= (ListView) view.findViewById(R.id.mylistview);
        listView.setEmptyView(view.findViewById(R.id.myText));
        pullNestedScrolView= (PullNestedScrolView) view.findViewById(R.id.pullnestedscrollow);
        pullNestedScrolView.setMode(PullToRefreshBase.Mode.DISABLED);


       /* for (int i=0;i<8;i++){
            list.add("Item"+i);
        }*/
        myAdapter=new MyAdapter();
        listView.setAdapter(myAdapter);




        pullNestedScrolView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<NestedScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<NestedScrollView> refreshView) {
                for (int i=0;i<8;i++){
                    list.add("Item"+i);
                }
                myAdapter.notifyDataSetChanged();
                pullNestedScrolView.onRefreshComplete();

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<NestedScrollView> refreshView) {

            }
        });

    }

    public class MyAdapter extends BaseAdapter{


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
