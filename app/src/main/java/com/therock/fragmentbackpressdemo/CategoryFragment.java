package com.therock.fragmentbackpressdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class CategoryFragment extends Fragment {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ArrayList<String> tabTitle_list, name_list,mainlist;
    private PlansPagerAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu( true );
        super.onCreate( savedInstanceState );
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate( R.layout.fragment_category, container, false );
        name_list=new ArrayList<>(  );
        name_list.add( "First" );
        name_list.add( "Second" );
        name_list.add( "Third" );
        name_list.add( "Fourth" );
        name_list.add( "Fifth" );
        mainlist=new ArrayList<>(  );
        mainlist.add( "first card" );
        mainlist.add( "sec card" );
        mainlist.add( "third card" );
        mainlist.add( "fourht card" );
        mainlist.add( "fifth card" );
        //check network

        init( root );

        SetTabLayout();

        SetPageViewer();

        return root;
    }


    private void SetPageViewer() {

       // viewPager.setOffscreenPageLimit( 4 );
        viewPager.addOnPageChangeListener( new TabLayout.TabLayoutOnPageChangeListener( tabLayout ) );
        tabLayout.setOnTabSelectedListener( new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem( tab.getPosition() );
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        } );
    }



    private void init(View root) {
        tabLayout = root.findViewById( R.id.tabs );
        viewPager = root.findViewById( R.id.container_frameLayout_viewpager );
        tabTitle_list = new ArrayList<>();
    }

    private void SetTabLayout() {
        for (int l = 0; l < name_list.size(); l++) {
            tabLayout.addTab( tabLayout.newTab().setText( name_list.get( l ) ) );
            tabTitle_list.add( name_list.get( l ) );
        }
        adapter = new PlansPagerAdapter( getChildFragmentManager(), tabLayout.getTabCount(), tabTitle_list,mainlist );
        viewPager.setAdapter( adapter );

        /* the ViewPager requires a minimum of 1 as OffscreenPageLimit */
        int limit = (adapter.getCount() > 1 ? adapter.getCount() - 1 : 1);
        viewPager.setOffscreenPageLimit( limit );
    }




}





