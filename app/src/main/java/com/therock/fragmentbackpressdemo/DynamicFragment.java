package com.therock.fragmentbackpressdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class DynamicFragment extends Fragment {
    private RecyclerView.LayoutManager sub_cat_layoutManager;
    private static RecyclerView sub_cat_recyclerView;
    public static DynamicFragment newInstance() {
        return new DynamicFragment();
    }
    public static String ID;
    private ArrayList<String> tabTitle_list, name_list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate( R.layout.fragment_dynamic, container, false );
        name_list = (ArrayList<String>) getArguments().getSerializable( "name_list");
        initViews( root );


        sub_cat_recyclerView.addOnItemTouchListener( new RecyclerItemClickListener( getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int pos) {

                        //move to child fragment from here
                        enterMessagingFragment( pos );
                        Log.e( "CLICK","Dynamic" );

                    }
                } ) );

        return root;
    }

    private void enterMessagingFragment(int pos) {

        MessageListningFragment messageListningFragment = new MessageListningFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.addToBackStack( null );
        transaction.replace( R.id.dynamic_container, messageListningFragment ).commitAllowingStateLoss();

    }

    private void initViews(View view) {

        sub_cat_recyclerView = view.findViewById( R.id.my_recycler_view );
        sub_cat_recyclerView.setHasFixedSize( true );
        sub_cat_layoutManager = new LinearLayoutManager( getActivity() );
        sub_cat_recyclerView.setLayoutManager( sub_cat_layoutManager );
        sub_cat_recyclerView.setItemAnimator( new DefaultItemAnimator() );
        //call adapter
        SubCategoryAdapter  sub_cat_adapter = new SubCategoryAdapter( getActivity(),name_list);
        sub_cat_recyclerView.setAdapter( sub_cat_adapter );





    }


}