package com.example.liuwen.jian_shu.Base;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/01/12 15:01
 * desc   :  基类
 */
public abstract class BaseFragment extends LazyLoadFragment {


    protected Activity mActivity;

    //加载数据
    protected abstract void loadData();

    @Override
    protected void onFragmentFirstVisible() {
        loadData();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //设置系统的bar全部显示出来
            getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        super.onCreate(savedInstanceState);
    }
}
