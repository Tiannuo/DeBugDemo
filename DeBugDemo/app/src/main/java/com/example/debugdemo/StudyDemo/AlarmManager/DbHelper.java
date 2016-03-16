package com.example.debugdemo.StudyDemo.AlarmManager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.debugdemo.Helper.MyApp;

import org.xutils.DbManager;
import org.xutils.ex.DbException;
import org.xutils.x;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Administrator on 2016/3/3 0003.
 */
public class DbHelper {
        private static DbHelper dbHelper;
        private static DbManager db;
        private static Context contex;
    private User user;
        public static DbHelper newInstance(Context context){
            contex=context;
            db= x.getDb(((MyApp)context.getApplicationContext()).getDaoConfig());
            if (dbHelper==null){
                return new DbHelper();
            }
                return dbHelper;
        }

        public void  saveChange(boolean falg,int position){
            List<User> users=select();
            user=users.get(position);
            user.setFlag(falg);
            try {
                db.save(user);
            } catch (DbException e) {
                e.printStackTrace();
            }

            notifyToggle();
        }

        public void save(int colck_id,String name,int hour,int minute){
            user=new User();
            user.setClock_id(colck_id);
            user.setName(name);
            user.setHour(hour);
            user.setMinute(minute);
            user.setFlag(true);
            try {
                db.save(user);
            } catch (DbException e) {
                e.printStackTrace();
            }
        }

        public List<User> select(){
            List<User> userList=null;
            try {
                userList=db.selector(User.class).findAll();
                return userList;
            } catch (DbException e) {

                return null;
            }



       /*     if(userList!=null){
                for (int i=0;i<userList.size();i++){
                    Log.i("user","name"+userList.get(i).getName()+"    getClock_id"+userList.get(i).getClock_id());
                }
            }*/


        }

        public void notifyToggle(){
            List<User> userList=null;
            try {
                userList=db.selector(User.class).findAll();
            } catch (DbException e) {
                return;
            }

            AlarmManager am= (AlarmManager) contex.getSystemService(contex.ALARM_SERVICE);

            if(userList!=null){
                for (int i=0;i<userList.size();i++){
                    Log.i("user","name"+userList.get(i).getName()+"    getClock_id"+userList.get(i).getClock_id());

                    Calendar calendar = Calendar.getInstance();
                    //指定时间

                    Log.i("calendar","calendar sys " +calendar.getTimeInMillis());
                    //指定绝对时间
                    //calendar.set(2016,01,29,16,19,0);
                    //指定相对时间h_m_s
                    calendar.set(Calendar.HOUR_OF_DAY, userList.get(i).getHour());
                    calendar.set(Calendar.MINUTE, userList.get(i).getMinute());

                    //循环多个时间


                    Intent intent=new Intent("CLOCK");
                    intent.putExtra("msg", userList.get(i).getName());
                    intent.putExtra("id",userList.get(i).getClock_id());
                    PendingIntent pi=PendingIntent.getBroadcast(contex,userList.get(i).getClock_id(),intent,0);

                    // am.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),5*1000,pi);
                    //设定时间小于系统时间，需要额外判断

                    if (userList.get(i).isFlag()){
                     /*   if (Calendar.getInstance().getTimeInMillis()>calendar.getTimeInMillis()){

                            calendar.set(Calendar.DAY_OF_YEAR,calendar.get(Calendar.DAY_OF_YEAR)+1);
                        }*/
                        am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 5 * 1000, pi);
                    }else {
                        am.cancel(pi);
                    }
                    //Log.i("calendar", "calendar zdy " +calendar.getTimeInMillis());

                }




            }
            }





}
