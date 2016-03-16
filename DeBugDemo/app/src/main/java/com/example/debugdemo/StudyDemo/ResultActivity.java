package com.example.debugdemo.StudyDemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import com.example.debugdemo.Helper.JavaBean.ResultBean;
import com.example.debugdemo.R;
import com.google.gson.Gson;

/**
 * Created by Administrator on 2016/3/7 0007.
 */
public class ResultActivity extends FragmentActivity {
    private TextView tv_reult;
    private String json="{     \"result\": \"0\",     \"msg\": null,     \"data\": {         \"cityVOList\": [             {                 \"showCityName\": \"杭州\",                 \"city\": {                     \"cityid\": 2,                     \"proid\": 11,                     \"cityname\": \"杭州市\",                     \"citycode\": \"330100\",                     \"areacode\": \"0571\",                     \"initials\": \"\",                     \"isOpen\": true                 }             },             {                 \"showCityName\": \"济南\",                 \"city\": {                     \"cityid\": 137,                     \"proid\": 15,                     \"cityname\": \"济南市\",                     \"citycode\": \"370100\",                     \"areacode\": \"0531\",                     \"initials\": \"\",                     \"isOpen\": true                 }             },             {                 \"showCityName\": \"广州\",                 \"city\": {                     \"cityid\": 200,                     \"proid\": 19,                     \"cityname\": \"广州市\",                     \"citycode\": \"440100\",                     \"areacode\": \"020\",                     \"initials\": \"\",                     \"isOpen\": true                 }             }         ],         \"citys\": [             {                 \"cityid\": 2,                 \"proid\": 11,                 \"cityname\": \"杭州市\",                 \"citycode\": \"330100\",                 \"areacode\": \"0571\",                 \"initials\": \"\",                 \"isOpen\": true             },             {                 \"cityid\": 137,                 \"proid\": 15,                 \"cityname\": \"济南市\",                 \"citycode\": \"370100\",                 \"areacode\": \"0531\",                 \"initials\": \"\",                 \"isOpen\": true             },             {                 \"cityid\": 200,                 \"proid\": 19,                 \"cityname\": \"广州市\",                 \"citycode\": \"440100\",                 \"areacode\": \"020\",                 \"initials\": \"\",                 \"isOpen\": true             }         ]     } }";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        init();
    }

    private void init() {
        tv_reult= (TextView) findViewById(R.id.tv_result);
        ResultBean resultBean=new Gson().fromJson(json,ResultBean.class);
        tv_reult.setText(resultBean.getData().getCityVOList().get(0).getCity().getCityid()+"");


    }
}
