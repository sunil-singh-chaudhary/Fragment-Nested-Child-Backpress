package com.therock.fragmentbackpressdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MessageListningFragment extends Fragment  {
    private static RecyclerView.Adapter msg_adapter;
    private RecyclerView.LayoutManager msg_layoutManager;
    private static RecyclerView msg_recyclerView;
    private View root;
    public static int checkedItem = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu( true );

        OnBackPressedCallback callback = new OnBackPressedCallback( true ) {
            @Override
            public void handleOnBackPressed() {
                checkedItem = 0;
                // Handle the back button event
                FragmentManager fm = getFragmentManager();
                if (fm != null) {
                    if (fm.getBackStackEntryCount() > 0) {
                        fm.popBackStack();
                        Log.e( "backpress", "MessageListningFragment" );

                    }

                    List<Fragment> fragList = fm.getFragments();
                    if (fragList != null && fragList.size() > 0) {
                        for (Fragment frag : fragList) {
                            if (frag == null) {
                                continue;
                            }
                            if (frag.isVisible()) {
                                Log.e( "bcprs isvisble", "MessageListning-" + frag.toString() );

                            }
                        }
                    }
                }


            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback( this, callback );
        super.onCreate( savedInstanceState );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        root = inflater.inflate( R.layout.fragment_message_listning, container, false );

      //  enterFullMsgFragment();

        SetRecyclerView( root );

        return root;
    }


    private void SetRecyclerView(View root) {
        msg_recyclerView = root.findViewById( R.id.msg_recycler_view );
        msg_recyclerView.setHasFixedSize( true );
        msg_layoutManager = new LinearLayoutManager( getActivity() );
        msg_recyclerView.setLayoutManager( msg_layoutManager );
        msg_recyclerView.setItemAnimator( new DefaultItemAnimator() );
    }

    private void enterFullMsgFragment() {

        FullMsgViewFragment fullMsgViewFragment = new FullMsgViewFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        String BACK_STACK_ROOT_TAG = "MessageListning_fragment";
        transaction.addToBackStack( BACK_STACK_ROOT_TAG );

        transaction.replace( R.id.for_fullmsg_container, fullMsgViewFragment ).commitAllowingStateLoss();

    }


}
