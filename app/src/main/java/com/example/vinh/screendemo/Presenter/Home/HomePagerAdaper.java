package com.example.vinh.screendemo.Presenter.Home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Vinh on 9/22/2018.
 */

public class HomePagerAdaper extends FragmentPagerAdapter {
    ArrayList<Fragment> listFragment = new ArrayList<Fragment>();
    ArrayList<String> listTitle = new ArrayList<String>();

    public HomePagerAdaper(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }

    public void addFragment(Fragment fm,String title){
        listFragment.add(fm);
        listTitle.add(title);
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return listTitle.get(position);
    }
}
