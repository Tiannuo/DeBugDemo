package com.example.debugdemo.Fragmnet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.debugdemo.R;

import butterknife.Bind;
import butterknife.OnClick;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by Administrator on 2016/1/18 0018.
 */
public class My extends BaseFragment {

    @Bind(R.id.bt_share)
    Button bt_share;


    @Override
    protected View getView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.activity_share,container,false);
    }

    @Override
    protected void initData() {
            bt_share.setText("share分享");
    }






   @OnClick(R.id.bt_share)
    protected void Click(View v){
            switch (v.getId()){
                case R.id.bt_share:

                    Toast.makeText(activity,"分享",Toast.LENGTH_SHORT).show();
                    showShare();



                    break;

            }

   }

    private void showShare() {
        ShareSDK.initSDK(activity);
        OnekeyShare oks=new OnekeyShare();
        oks.disableSSOWhenAuthorize();
        oks.setTitle("我是tittle");
        oks.setText("我是文本");
        oks.setUrl("www.baidu.com");
        oks.setImageUrl("http://e.hiphotos.baidu.com/image/h%3D200/sign=4bd6530cafec8a130b1a50e0c7019157/11385343fbf2b2118fe9f2adcc8065380dd78e09.jpg");


        oks.show(activity);
    }


}
