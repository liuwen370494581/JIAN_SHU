package com.example.liuwen.jian_shu.ChildFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.liuwen.jian_shu.Adapter.MyChildAdapter;
import com.example.liuwen.jian_shu.Base.BaseFragment;
import com.example.liuwen.jian_shu.Base.Config;
import com.example.liuwen.jian_shu.Jsoup.Action.ActionCallBack;
import com.example.liuwen.jian_shu.Jsoup.Action.MyAction;
import com.example.liuwen.jian_shu.Module.UserModel;
import com.example.liuwen.jian_shu.R;
import com.example.liuwen.jian_shu.Utils.UIUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/01/15 14:43
 * desc   :
 */
public class ChildMyFragment extends BaseFragment {

    private String mChannelCode;
    private RecyclerView mRecyclerView;
    private MyChildAdapter myChildAdapter;
    private List<String> mList2 = new ArrayList<>();
    private List<UserModel> mList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_child_my, container, false);
        initView(view);
        initDate();
        return view;
    }


    private void initView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(UIUtils.getContext()));
        myChildAdapter = new MyChildAdapter(mList, mList2, getActivity());
        mRecyclerView.setAdapter(myChildAdapter);
    }


    @Override
    protected void loadData() {
        mChannelCode = getArguments().getString(Config.CHANNEL_CODE);
        Log.e("MainActivity", mChannelCode);
        if (mChannelCode.equals(UIUtils.getResources_().getStringArray(R.array.child_my_tabs)[0])) {
            loadingDate(0);
        } else if (mChannelCode.equals(UIUtils.getResources_().getStringArray(R.array.child_my_tabs)[1])) {
            loadingDate(1);
        } else if (mChannelCode.equals(UIUtils.getResources_().getStringArray(R.array.child_my_tabs)[2])) {
            loadingDate(2);
        } else if (mChannelCode.equals(UIUtils.getResources_().getStringArray(R.array.child_my_tabs)[3])) {
            loadingDate(3);
        }
    }

    private void initDate() {

    }

    protected void loadingDate(int position) {
        switch (position) {
            case 0:
                MyAction.searchMyDate(getActivity(), "https://www.jianshu.com/u/18740e093fcb", new ActionCallBack() {
                    @Override
                    public void ok(Object object) {
                        mList.addAll((Collection<? extends UserModel>) object);
                        myChildAdapter.updateList(mList);
                    }

                    @Override
                    public void failed(Object object) {

                    }
                });
                MyAction.searchMyDateCover(getActivity(), "https://www.jianshu.com/u/18740e093fcb", new ActionCallBack() {
                    @Override
                    public void ok(Object object) {
                        mList2.addAll((Collection<? extends String>) object);
                        myChildAdapter.updateListPic(mList2);
                    }

                    @Override
                    public void failed(Object object) {
                    }
                });
                break;

            default:

                break;
        }

    }
}
