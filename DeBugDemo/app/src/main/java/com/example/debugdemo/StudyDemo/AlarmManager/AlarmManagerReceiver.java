package com.example.debugdemo.StudyDemo.AlarmManager;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import com.example.debugdemo.R;

/**
 * Created by Administrator on 2016/2/29 0029.
 */
public class AlarmManagerReceiver extends BroadcastReceiver {
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        String msg = intent.getStringExtra("msg");
        Log.i("AlarmManagerReceiver", "msg    " + msg);

        //Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
   /*     Notification notification=new Notification.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setTicker("服药提醒")
                .setContentText(msg)
                .build();
        notification.flags |=Notification.FLAG_AUTO_CANCEL;
        manager.notify(0,notification);*/

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentTitle("测试标题")
                .setContentText(msg)
                .setTicker("服药提醒")
                .setPriority(Notification.PRIORITY_DEFAULT)
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setAutoCancel(true)
                .setSmallIcon(R.mipmap.ic_launcher);
        Notification notification = builder.build();
        notification.flags |= Notification.FLAG_AUTO_CANCEL;

        manager.notify(intent.getIntExtra("id",0), notification);
    }
}
