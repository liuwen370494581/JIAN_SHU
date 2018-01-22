package com.example.liuwen.jian_shu.ChildFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.liuwen.jian_shu.Adapter.MyChildAdapter;
import com.example.liuwen.jian_shu.Base.BaseFragment;
import com.example.liuwen.jian_shu.Base.Config;
import com.example.liuwen.jian_shu.Jsoup.Action.ActionCallBack;
import com.example.liuwen.jian_shu.Jsoup.Action.MyAction;
import com.example.liuwen.jian_shu.Module.UserModel;
import com.example.liuwen.jian_shu.R;
import com.example.liuwen.jian_shu.Utils.UIUtils;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

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
    private List<UserModel> mList = new ArrayList<>();
    private FrameLayout mFlContent;
    private SpringView mSpringView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_child_my, container, false);
        initView(view);
        initDate();
        return view;
    }


    private void initView(View view) {
        //mFlContent = (FrameLayout) view.findViewById(R.id.fl_content);
        mSpringView = (SpringView) view.findViewById(R.id.my_springView);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(UIUtils.getContext()));
        myChildAdapter = new MyChildAdapter(mList, getActivity());
        mRecyclerView.setAdapter(myChildAdapter);
        initReflash();

    }

    private void initReflash() {
       mSpringView.setType(SpringView.Type.FOLLOW);
        mSpringView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                myChildAdapter.clearAllDate();
                loadingDate(0);
                mSpringView.onFinishFreshAndLoad();
            }

            @Override
            public void onLoadmore() {
                loadingDate(0);
                mSpringView.onFinishFreshAndLoad();
            }
        });
        mSpringView.setHeader(new DefaultHeader(getActivity()));
        mSpringView.setFooter(new DefaultFooter(getActivity()));
    }


    @Override
    protected void loadData() {
     loadingDate(0);
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
            default:

                break;
        }

    }
}
