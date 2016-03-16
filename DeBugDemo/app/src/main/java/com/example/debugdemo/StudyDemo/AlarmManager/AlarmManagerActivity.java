package com.example.debugdemo.StudyDemo.AlarmManager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.debugdemo.R;

import java.util.Calendar;

/**目的一个类似于闹钟的定时提醒
 * Created by Administrator on 2016/2/29 0029.
 */



public class AlarmManagerActivity extends AppCompatActivity{

    private AlarmManager am;
    private PendingIntent pi;
    private Calendar calendar;
    private int clock_id;
    private int type=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarmmanger);
        am= (AlarmManager) getSystemService(ALARM_SERVICE);
        findViewById(R.id.bt_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /*   calendar.set(Calendar.DAY_OF_YEAR,calendar.get(Calendar.DAY_OF_YEAR)-1);
                am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 5 * 1000, pi);*/
                clock_id++;
                DbHelper.newInstance(AlarmManagerActivity.this).save(clock_id,"name+"+clock_id,15,31+clock_id);

            }
        });


        findViewById(R.id.bt_cacle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              /*  am.cancel(pi);*/
              //  DbHelper.newInstance(AlarmManagerActivity.this).select();
                DbHelper.newInstance(AlarmManagerActivity.this).notifyToggle();
            }
        });

        findViewById(R.id.btchange).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                type=type+1;
                if (type%2==1){
                    DbHelper.newInstance(AlarmManagerActivity.this).saveChange(false,0);
                }else {
                    DbHelper.newInstance(AlarmManagerActivity.this).saveChange(true,0);
                }



              /*  am.cancel(pi);*/
                //  DbHelper.newInstance(AlarmManagerActivity.this).select();
            }
        });


      //  initManger();
    }

    private void initManger() {
        //指定时间
        calendar = Calendar.getInstance();
        Log.i("calendar","calendar sys " +calendar.getTimeInMillis());
        //指定绝对时间
        //calendar.set(2016,01,29,16,19,0);
        //指定相对时间h_m_s
        calendar.set(Calendar.HOUR_OF_DAY, 7);
        calendar.set(Calendar.MINUTE, 39);
        calendar.set(Calendar.SECOND, 0);
        //循环多个时间


        Intent intent=new Intent("CLOCK");
        intent.putExtra(getString(R.string.msg), "测试提醒");
        pi=PendingIntent.getBroadcast(this,0,intent,0);

       // am.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),5*1000,pi);
        //设定时间小于系统时间，需要额外判断
     /*   if (Calendar.getInstance().getTimeInMillis()>calendar.getTimeInMillis()){

            calendar.set(Calendar.DAY_OF_YEAR,calendar.get(Calendar.DAY_OF_YEAR)+1);
        }*/
        am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 5 * 10000000, pi);

        Log.i("calendar", "calendar zdy " +calendar.getTimeInMillis());

    }


}
