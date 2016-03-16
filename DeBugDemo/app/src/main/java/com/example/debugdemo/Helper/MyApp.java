package com.example.debugdemo.Helper;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import org.xutils.DbManager;
import org.xutils.x;

/**
 * Created by Administrator on 2016/1/22 0022.
 */
public class MyApp extends Application {
    private DbManager.DaoConfig daoConfig;

    public DbManager.DaoConfig getDaoConfig(){

        return daoConfig;

    }


    @Override
    public void onCreate() {
        super.onCreate();
        //全局初始化imageloader
        initImageLoader(getApplicationContext());
        //全局初始化xutils3.0
        x.Ext.init(this);
        x.Ext.setDebug(true);
        //初始化数据库
        initSqlit();



    }

    private void initSqlit() {
        daoConfig=new DbManager.DaoConfig()
                
                .setDbName("debug")
                .setDbVersion(1)
                .setDbOpenListener(new DbManager.DbOpenListener() {
                    @Override
                    public void onDbOpened(DbManager db) {
                        db.getDatabase().enableWriteAheadLogging();
                    }
                })
                .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                    @Override
                    public void onUpgrade(DbManager db, int oldVersion, int newVersion) {

                    }
                });
    }

    private static void initImageLoader(Context applicationContext) {
        //全局配置的缓冲参数，直接复制就可以了
        ImageLoaderConfiguration configuration=new ImageLoaderConfiguration.Builder(applicationContext).threadPriority(Thread.NORM_PRIORITY-2)
                .denyCacheImageMultipleSizesInMemory().diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .diskCacheSize(30*1024*1024)
                .tasksProcessingOrder(QueueProcessingType.FIFO)
                .writeDebugLogs().build()
                ;

        ImageLoader.getInstance().init(configuration);

    }
}
