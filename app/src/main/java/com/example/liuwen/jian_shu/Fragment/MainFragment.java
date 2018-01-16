package com.example.liuwen.jian_shu.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.liuwen.jian_shu.Base.BaseFragment;
import com.example.liuwen.jian_shu.Base.Config;
import com.example.liuwen.jian_shu.ChildFragment.FriendsCircleFragment;
import com.example.liuwen.jian_shu.R;
import com.example.liuwen.jian_shu.Utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

import me.weyye.library.colortrackview.ColorTrackTabLayout;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/01/12 15:01
 * desc   :
 */
public class MainFragment extends BaseFragment {

    private String[] titles;
    private ColorTrackTabLayout mTab;
    private ViewPager mViewPager;
    private ImageView ivAddChannel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mian, container, false);
        initView(view);
        initTable();
        return view;
    }

    private void initTable() {
        final List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            FriendsCircleFragment friendsCircleFragment = new FriendsCircleFragment();
            Bundle bundle = new Bundle();
            bundle.putString(Config.CHANNEL_CODE, titles[i]);
            friendsCircleFragment.setArguments(bundle);
            fragments.add(friendsCircleFragment);
        }

        mViewPager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return titles.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        });
        mTab.setupWithViewPager(mViewPager);
        mTab.setSelectedTabIndicatorHeight(0);
        mViewPager.setOffscreenPageLimit(titles.length);
    }

    private void initView(View view) {
        mTab = (ColorTrackTabLayout) view.findViewById(R.id.tab);
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        ivAddChannel = (ImageView) view.findViewById(R.id.iv_operation);
        titles = UIUtils.getResources_().getStringArray(R.array.child_tabs);
        mTab.setTabPaddingLeftAndRight(UIUtils.dip2Px(10), UIUtils.dip2Px(10));
        mTab.post(new Runnable() {
            @Override
            public void run() {
                //设置最小宽度，使其可以在滑动一部分距离
                ViewGroup slidingTabStrip = (ViewGroup) mTab.getChildAt(0);
                slidingTabStrip.setMinimumWidth(slidingTabStrip.getMeasuredWidth() + ivAddChannel.getMeasuredWidth());
            }
        });

    }


    @Override
    protected void loadData() {

    }
}
