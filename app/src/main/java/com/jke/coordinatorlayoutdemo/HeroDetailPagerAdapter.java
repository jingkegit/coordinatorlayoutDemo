package com.jke.coordinatorlayoutdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by jke on 2017/4/7.
 */

public class HeroDetailPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;
    private String[] titles  = {"英雄首页","视频集锦","玩家攻略"};

    public HeroDetailPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments==null ? null : fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments==null? 0 : fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
