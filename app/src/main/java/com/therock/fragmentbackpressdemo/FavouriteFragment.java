package com.therock.fragmentbackpressdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FavouriteFragment extends Fragment  {



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu( true );
        super.onCreate( savedInstanceState );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate( R.layout.fragment_my_post, container, false );



        return root;


    }


}
