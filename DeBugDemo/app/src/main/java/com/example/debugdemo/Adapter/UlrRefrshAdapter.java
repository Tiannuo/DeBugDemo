package com.example.debugdemo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.debugdemo.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;

import java.util.List;

/**
 * Created by Administrator on 2016/1/22 0022.
 */
public class UlrRefrshAdapter extends BaseAdapter {
    /*
    *  MyApp先是这个类，里面有注释在helper文件夹里面
    *  再看适配器里面的详细的配置
    *
    *
    *
    * */




    private LayoutInflater layoutInflater;
    private List<String> list;

    //直接想要特定的加载图片的效果配置
    private DisplayImageOptions options;


    public UlrRefrshAdapter(Context context, List<String> list) {
        this.layoutInflater=LayoutInflater.from(context);
        this.list=list;

        options=new DisplayImageOptions.Builder()
                .showImageForEmptyUri(R.drawable.ic_empty_small)
                .showImageOnLoading(R.drawable.ic_empty_small)
                .showImageOnFail(R.drawable.ic_empty_small)
                .cacheInMemory(true)
                .displayer(new CircleBitmapDisplayer())
                .build();
    }

    @Override
    public int getCount() {
        return list==null?0:list.size();
    }

    @Override
    public Object getItem(int position) {
        if (list==null||position>list.size()-1){

            return null;
        }
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            convertView=layoutInflater.inflate(R.layout.item_lv,null);
            viewHolder=new ViewHolder();
            viewHolder.ivCar= (ImageView) convertView.findViewById(R.id.iv_car);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }

        //加载图片

        ImageLoader.getInstance().displayImage(list.get(position),viewHolder.ivCar,options);

        return convertView;
    }



    static class ViewHolder{

        ImageView ivCar;

    }
}
