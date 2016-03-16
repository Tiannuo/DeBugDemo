package com.example.debugdemo.StudyDemo.AlarmManager;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by Administrator on 2016/3/3 0003.
 */

@Table(name="user")
public class User {
        @Column(name="id",isId =true)
        private int id;

        @Column(name="name")
        private String name;

        @Column(name="clock_id")
        private int clock_id;

        @Column(name="hour")
        private int hour;

        @Column(name="minute")
        private int minute;

        @Column(name="flag")
        private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getClock_id() {
        return clock_id;
    }

    public void setClock_id(int clock_id) {
        this.clock_id = clock_id;
    }
}
