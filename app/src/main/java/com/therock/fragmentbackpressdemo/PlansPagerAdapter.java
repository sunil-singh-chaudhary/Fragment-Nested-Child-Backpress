package com.therock.fragmentbackpressdemo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class PlansPagerAdapter extends FragmentStatePagerAdapter {
    private int mNumOfTabs;
    private ArrayList<String> tabTitle,mainlist;

    public PlansPagerAdapter(FragmentManager fm, int NumOfTabs, ArrayList<String> tabTitle,ArrayList<String> mainlist) {
        super( fm );
        this.mNumOfTabs = NumOfTabs;
        this.tabTitle = tabTitle;
        this.mainlist=mainlist;
    }

    @Override
    public Fragment getItem(int position) {

        Bundle args = new Bundle();
        args.putInt( "position", position );
        args.putSerializable( "name_list",  mainlist );
        Fragment frag = DynamicFragment.newInstance();
        frag.setArguments( args );
        return frag;

    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}