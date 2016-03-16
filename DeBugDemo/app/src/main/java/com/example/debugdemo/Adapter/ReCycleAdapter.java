package com.example.debugdemo.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.debugdemo.R;

import java.util.List;

/**
 * Created by Administrator on 2016/2/2 0002.
 */
public class ReCycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<String> list;
    private static final int HEADER_INTEGER = 0;
    private static final int CONTENT_INTEGER = 1;

    public ReCycleAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("time","onCreateViewHolder");
        return new ListViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recycle,null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.i("time","onBindViewHolder");

                if (getItemViewType(position)==CONTENT_INTEGER){
                   // ListViewHolder listViewHolder= (ListViewHolder) holder;
                }
                ListViewHolder listViewHolder= (ListViewHolder) holder;
                listViewHolder.textView.setText(list.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return HEADER_INTEGER;
        }
            return CONTENT_INTEGER;
    }

    @Override
    public int getItemCount() {
        return list!=null&&list.size()>0?list.size():0;
    }

    class ListViewHolder extends RecyclerView.ViewHolder{
        TextView textView;

        public ListViewHolder(View itemView) {

            super(itemView);
      /*      itemView= LayoutInflater.from(context).inflate(R.layout.item_recycle,null);
            */

            textView= (TextView) itemView.findViewById(R.id.tv_recycle);

            Log.i("time","ListViewHolder");
        }
    }


}
