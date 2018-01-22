package com.example.liuwen.jian_shu.Fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.liuwen.jian_shu.Base.BaseFragment;
import com.example.liuwen.jian_shu.ChildFragment.ChildMyFragment;
import com.example.liuwen.jian_shu.R;

import java.util.ArrayList;
import java.util.List;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/01/12 15:05
 * desc   :
 */
public class MyFragment extends BaseFragment {

    private ChildMyFragment childMyFragment_01;
    private ChildMyFragment childMyFragment_02;
    private ChildMyFragment childMyFragment_03;
    private ChildMyFragment childMyFragment_04;

    private AppBarLayout mAppBarLayout;
    private Toolbar mToolbar;
    private Bitmap bitmap;
    private ViewPager mViewPager;

    private PagerAdapter mPagerAdapter;

    private LinearLayout head_layout;

    private TabLayout toolbar_tab;

    private List<ChildMyFragment> mFragments = new ArrayList<ChildMyFragment>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_01, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mAppBarLayout = (AppBarLayout) view.findViewById(R.id.app_bar_layout);
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        mViewPager = (ViewPager) view.findViewById(R.id.view_pager);
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        setHasOptionsMenu(true);
        //((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true); //消除箭头的
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.profile_bg);
        mViewPager.setOffscreenPageLimit(4);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

            }
        });
        head_layout = (LinearLayout) view.findViewById(R.id.login_layout);
        toolbar_tab = (TabLayout) view.findViewById(R.id.toolbar_tab);
        head_layout.setBackgroundDrawable(new BitmapDrawable(bitmap));
        final CollapsingToolbarLayout mCollapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar_layout);
        mCollapsingToolbarLayout.setContentScrim(new BitmapDrawable(bitmap));
        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset <= -head_layout.getHeight() / 2) {
                    mCollapsingToolbarLayout.setTitle("用户中心");
                } else {
                    mCollapsingToolbarLayout.setTitle(" ");
                }
            }
        });
        initFragment();
    }

    private void initFragment() {
        if (childMyFragment_01 == null) {
            childMyFragment_01 = new ChildMyFragment();
        }
        if (childMyFragment_02 == null) {
            childMyFragment_02 = new ChildMyFragment();
        }
        if (childMyFragment_03 == null) {
            childMyFragment_03 = new ChildMyFragment();
        }
        if (childMyFragment_04 == null) {
            childMyFragment_04 = new ChildMyFragment();
        }

        mFragments.add(childMyFragment_01);
        mFragments.add(childMyFragment_02);
        mFragments.add(childMyFragment_03);
        mFragments.add(childMyFragment_04);
        mPagerAdapter = new PagerAdapter(getFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(toolbar_tab));
        toolbar_tab.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

    }

    public class PagerAdapter extends FragmentPagerAdapter {
        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return childMyFragment_01;
            } else if (position == 1) {
                return childMyFragment_02;
            } else if (position == 2) {
                return childMyFragment_03;
            } else if (position == 3) {
                return childMyFragment_04;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }

    }

    @Override
    protected void loadData() {
    }
}
