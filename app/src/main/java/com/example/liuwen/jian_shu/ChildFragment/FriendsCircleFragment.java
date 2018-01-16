package com.example.liuwen.jian_shu.ChildFragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.liuwen.jian_shu.Base.BaseFragment;
import com.example.liuwen.jian_shu.Base.Config;
import com.example.liuwen.jian_shu.R;
import com.example.liuwen.jian_shu.Utils.UIUtils;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/01/15 10:01
 * desc   :
 */
public class FriendsCircleFragment extends BaseFragment {
    private String mChannelCode;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend_circle, container, false);
        initView(view);
        initDate();
        return view;
    }


    private void initView(View view) {
    }


    @Override
    protected void loadData() {
        mChannelCode = getArguments().getString(Config.CHANNEL_CODE);
        Log.e("MainActivity", mChannelCode);
    }

    private void initDate() {

    }
}
