package com.example.liuwen.jian_shu.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.liuwen.jian_shu.Adapter.WelcomeViewPagerAdapter;
import com.example.liuwen.jian_shu.Base.BaseActivity;
import com.example.liuwen.jian_shu.Base.Config;
import com.example.liuwen.jian_shu.MainActivity;
import com.example.liuwen.jian_shu.R;
import com.example.liuwen.jian_shu.Utils.SharedPreferencesUtil;
import com.example.liuwen.jian_shu.Utils.UIUtils;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/01/23 10:59
 * desc   :
 */
public class WelcomeActivity extends AppCompatActivity {

    private boolean mIsFirst;
    private ViewPager mViewPager;
    private List<View> mViews;
    private MyHandler myHandler = new MyHandler(this);

    private static class MyHandler extends android.os.Handler {
        private WeakReference<Context> reference;

        public MyHandler(Context context) {
            reference = new WeakReference<Context>(context);

        }

        @Override
        public void handleMessage(Message msg) {
            WelcomeActivity activity = (WelcomeActivity) reference.get();
            if (activity != null) {
                boolean isFirstStar = SharedPreferencesUtil.getBooleanPreferences(UIUtils.getContext(), Config.FistStar, false);
                if (!isFirstStar) {
                    activity.startActivity(new Intent(UIUtils.getContext(), MainActivity.class));
                    activity.finish();
                }
            }
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        mIsFirst = SharedPreferencesUtil.getBooleanPreferences(this, Config.FistStar, true);
        if (mIsFirst) {
            setContentView(R.layout.activity_welcome);
        } else {
            setContentView(R.layout.activity_lauch);
        }
        initView();
    }


    private void initView() {
        if (mIsFirst) {
            mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
            mViews = new ArrayList<>();
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            ImageView imageView1 = new ImageView(this);
            imageView1.setLayoutParams(lp);
            imageView1.setBackgroundResource(R.mipmap.guide_p1_img);
            mViews.add(imageView1);
            ImageView imageView2 = new ImageView(this);
            imageView2.setLayoutParams(lp);
            imageView2.setBackgroundResource(R.mipmap.guide_p2_img);
            mViews.add(imageView2);
            ImageView imageView3 = new ImageView(this);
            imageView3.setLayoutParams(lp);
            imageView3.setBackgroundResource(R.mipmap.guide_p3_img);
            mViews.add(imageView3);

            View view = LayoutInflater.from(this).inflate(R.layout.layout_welcome_last_pager, null);
            TextView textView = (TextView) view.findViewById(R.id.layout_loading_txt);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferencesUtil.setBooleanPreferences(WelcomeActivity.this, Config.FistStar, false);
                    startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                    WelcomeActivity.this.finish();
                }
            });
            mViews.add(view);
            WelcomeViewPagerAdapter pagerAdapter = new WelcomeViewPagerAdapter(mViews);
            mViewPager.setAdapter(pagerAdapter);
        } else {
            myHandler.postDelayed(runnable, 1000);
        }
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            myHandler.sendEmptyMessage(0);
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myHandler.removeCallbacksAndMessages(null);
    }
}
