package com.example.liuwen.jian_shu.Adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.example.liuwen.jian_shu.Fragment.MyFragment;

import java.util.List;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/01/23 11:15
 * desc   :
 */
public class WelcomeViewPagerAdapter extends PagerAdapter {


    private List<View> mViews;

    public WelcomeViewPagerAdapter(List<View> views)
    {
        this.mViews = views;
    }

    @Override
    public int getCount() {
        return mViews.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView(mViews.get(position));
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public Object instantiateItem(View container, int position) {
        View view = mViews.get(position);
        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(view);
        return mViews.get(position);
    }
}
