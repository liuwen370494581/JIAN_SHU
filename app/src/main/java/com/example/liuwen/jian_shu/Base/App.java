package com.example.liuwen.jian_shu.Base;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.multidex.MultiDexApplication;
import android.util.Log;

import com.example.liuwen.jian_shu.Utils.CrashHandler;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/01/12 16:21
 * desc   :
 */
public class App extends MultiDexApplication {

    //以下是属性应用用于整个应用程序 合理利用资源 减少资源浪费
    private static Context mContext;//上下文
    private static Thread mMainThread;//主线程
    private static long mMainThreadId;//主线程ID
    private static Looper mMainLooper;//循环队列
    private static Handler mHandler;//主线程handler

    @Override
    public void onCreate() {
        super.onCreate();
        //崩溃日志记录
        CrashHandler.getInstance().init(this);
        //对全局属性赋值
        mContext=getApplicationContext();
        mMainThread=Thread.currentThread();
        mMainThreadId = android.os.Process.myTid();
        mHandler = new Handler();
    }

    public static Context getContext() {
        return mContext;
    }

    public static void setContext(Context mContext) {
        App.mContext = mContext;
    }


    public static Thread getMainThread() {
        return mMainThread;
    }

    public static void setMainThread(Thread mMainThread) {
        App.mMainThread = mMainThread;
    }

    public static long getMainThreadId() {
        return mMainThreadId;
    }

    public static void setMainThreadId(long mMainThreadId) {
        App.mMainThreadId = mMainThreadId;
    }

    public static Looper getMainThreadLooper() {
        return mMainLooper;
    }

    public static void setMainThreadLooper(Looper mMainLooper) {
        App.mMainLooper = mMainLooper;
    }

    public static Handler getMainHandler() {
        return mHandler;
    }

    public static void setMainHandler(Handler mHandler) {
        App.mHandler = mHandler;
    }


}
