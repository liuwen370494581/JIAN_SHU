package com.example.liuwen.jian_shu.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.liuwen.jian_shu.Base.BaseFragment;
import com.example.liuwen.jian_shu.R;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/01/12 15:04
 * desc   :
 */
public class DiscoverFragment extends BaseFragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
    }

    @Override
    protected void loadData() {

    }
}
