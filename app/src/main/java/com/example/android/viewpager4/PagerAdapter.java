package com.example.android.viewpager4;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Vikas on 4/27/2016.
 */
public class PagerAdapter extends FragmentPagerAdapter
{
   private List<FirstFragment> fragments;

    public PagerAdapter(FragmentManager fm, List<FirstFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int arg0)
    {
        return this.fragments.get(arg0);
    }

    @Override
    public int getCount()
    {
        return this.fragments.size();
    }

}
