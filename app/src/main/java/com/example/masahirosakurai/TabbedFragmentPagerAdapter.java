package com.example.masahirosakurai;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class TabbedFragmentPagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> frags = new ArrayList<>();
    ArrayList<String> names = new ArrayList<>();

    public TabbedFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment f, String e){
        frags.add(f);
        names.add(e);
    }

    @Override
    public Fragment getItem(int i) {
        return frags.get(i);
    }

    @Override
    public int getCount() {
        return frags.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return names.get(position);
    }
}
