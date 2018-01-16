package com.example.liuwen.jian_shu.ChildFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.liuwen.jian_shu.Base.BaseFragment;
import com.example.liuwen.jian_shu.Base.Config;
import com.example.liuwen.jian_shu.Jsoup.Action.ActionCallBack;
import com.example.liuwen.jian_shu.Jsoup.Action.MyAction;
import com.example.liuwen.jian_shu.R;
import com.example.liuwen.jian_shu.Utils.UIUtils;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/01/15 14:43
 * desc   :
 */
public class ChildMyFragment extends BaseFragment {

    private String mChannelCode;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_child_my, container, false);
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
        MyAction.searchMyDate(getActivity(), "https://www.jianshu.com/u/18740e093fcb", new ActionCallBack() {
            @Override
            public void ok(Object object) {

            }

            @Override
            public void failed(Object object) {

            }
        });
    }

    private void initDate() {

    }
}
