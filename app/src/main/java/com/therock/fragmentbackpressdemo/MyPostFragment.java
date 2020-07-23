package com.therock.fragmentbackpressdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class MyPostFragment extends Fragment {


    private static final int GRIDVIEW_ITEM_ONE_ROW_SIZE = 2;

    private RecyclerView mRecycler;



    View search_bar_layout_mypost;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu( true );


        super.onCreate( savedInstanceState );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate( R.layout.fragment_my_post, container, false );





        // Inflate the layout for this fragment
        return root;

    }






}
