package com.therock.fragmentbackpressdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.List;


public class FullMsgViewFragment extends Fragment {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        // This callback will only be called when MyFragment is at least Started.
        OnBackPressedCallback callback = new OnBackPressedCallback( true ) {
            @Override
            public void handleOnBackPressed() {
                // Handle the back button event
                FragmentManager fm = getFragmentManager();
                if (fm != null) {
                    if (fm.getBackStackEntryCount() > 0) {
                        fm.popBackStack();
                        Log.e( "backpress", "FullMsgViewFragment" );

                    }

                    List<Fragment> fragList = fm.getFragments();
                    if (fragList != null && fragList.size() > 0) {
                        for (Fragment frag : fragList) {
                            if (frag == null) {
                                continue;
                            }
                            if (frag.isVisible()) {

                                //-------------------- click backpress To Update Favourite List and Reflect ----page click values here--------

                                //  MessageListningFragment.getInstance().showVollyTotalMsg( MessageListningFragment.getInstance().defaulPageClick );

                                //-------------------------------------------------------------------------------- -------
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
        View root = inflater.inflate( R.layout.fragment_my_post, container, false );
        getActivity().getWindow().setSoftInputMode( WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN );


        return root;
    }

}
