package com.example.liuwen.jian_shu.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.liuwen.jian_shu.Adapter.GridViewAdapter;
import com.example.liuwen.jian_shu.Base.BaseFragment;
import com.example.liuwen.jian_shu.Enage.ProvideDate;
import com.example.liuwen.jian_shu.R;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/01/12 15:04
 * desc   :
 */
public class MessageFragment extends BaseFragment {
    private GridView mGridView;
    private GridViewAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mGridView = (GridView) view.findViewById(R.id.message_grid_view);
        mAdapter = new GridViewAdapter(ProvideDate.getMessageDate(), getActivity());
        mGridView.setAdapter(mAdapter);

    }

    @Override
    protected void loadData() {

    }
}
