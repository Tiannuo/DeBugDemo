package com.example.debugdemo.Fragmnet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.debugdemo.R;

/**
 * Created by Administrator on 2016/1/18 0018.
 */
public class TabHostFragment extends Fragment implements View.OnClickListener{



    private Button bt_buy;
    private static  final  String TAG="HomeFragment";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.i("===","onCreateView1");
        View view=inflater.inflate(R.layout.item_myfragment,null);
        bt_buy= (Button) view.findViewById(R.id.bt_buy);
        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_buy:
               // UPPayAssistEx.startPay()
                break;
        }
    }
}
