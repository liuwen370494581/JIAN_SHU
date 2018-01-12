package com.example.liuwen.jian_shu.Base;

import android.app.Activity;
import android.content.Context;

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
}
