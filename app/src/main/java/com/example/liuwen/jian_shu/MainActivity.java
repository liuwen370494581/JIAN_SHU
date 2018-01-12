package com.example.liuwen.jian_shu;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liuwen.jian_shu.Adapter.MainAdapter;
import com.example.liuwen.jian_shu.Fragment.DiscoverFragment;
import com.example.liuwen.jian_shu.Fragment.MainFragment;
import com.example.liuwen.jian_shu.Fragment.MessageFragment;
import com.example.liuwen.jian_shu.Fragment.MyFragment;
import com.example.liuwen.jian_shu.tab.BarEntity;
import com.example.liuwen.jian_shu.tab.BottomTabBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomTabBar.OnSelectListener {
    private BottomTabBar tb;
    private List<BarEntity> bars;
    private MainFragment homeFragment;
    private DiscoverFragment discoverFragment;
    private MessageFragment messageFragment;
    private MyFragment myFragment;
    private FragmentManager manager;
    private long firstTime = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();
        tb = (BottomTabBar) findViewById(R.id.tb);
        tb.setManager(manager);
        tb.setOnSelectListener(this);
        bars = new ArrayList<>();
        bars.add(new BarEntity("关注", R.mipmap.icon_home_red, R.mipmap.icon_home_gray));
        bars.add(new BarEntity("发现", R.mipmap.icon_discover_red, R.mipmap.icon_discover_gray));
        bars.add(new BarEntity("", 0, 0));
        bars.add(new BarEntity("消息", R.mipmap.icon_message_red, R.mipmap.icon_message_gray));
        bars.add(new BarEntity("我的", R.mipmap.icon_my_red, R.mipmap.icon_my_gray));
        tb.setBars(bars);

    }

    @Override
    public void onSelect(int position) {
        switch (position) {
            case 0:
                if (homeFragment == null) {
                    homeFragment = new MainFragment();
                }
                tb.switchContent(homeFragment);
                break;
            case 1:
                if (discoverFragment == null) {
                    discoverFragment = new DiscoverFragment();
                }
                tb.switchContent(discoverFragment);
                break;
            case 2:
                break;
            case 3:
                if (messageFragment == null) {
                    messageFragment = new MessageFragment();
                }
                tb.switchContent(messageFragment);
                break;
            case 4:
                if (myFragment == null) {
                    myFragment = new MyFragment();
                }
                tb.switchContent(myFragment);
                break;
            default:
                break;
        }

    }
}
