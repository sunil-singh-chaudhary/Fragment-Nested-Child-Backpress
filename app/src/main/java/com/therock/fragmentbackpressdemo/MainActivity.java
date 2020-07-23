package com.therock.fragmentbackpressdemo;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        BottomNavigationView navigation = findViewById( R.id.navigation );
        navigation.setItemIconTintList( null );
        navigation.setOnNavigationItemSelectedListener( this );

        getOnBackPressedDispatcher().addCallback( this, onBackPressedCallback );

        Fragment fragment = new CategoryFragment();
        loadFragment( fragment );
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_category:

                fragment = new CategoryFragment();
                break;

            case R.id.navigation_favourite:

                fragment = new FavouriteFragment();
                break;

            case R.id.navigation_mypost:

                fragment = new MyPostFragment();
                break;

            case R.id.navigation_setting:

                fragment = new SettingFragment();
                break;
        }

        return loadFragment( fragment );
    }



    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            Bundle args = new Bundle();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            String BACK_STACK_ROOT_TAG = "FirstActivity_fragment";
            fragment.setArguments( args );
            transaction.addToBackStack( BACK_STACK_ROOT_TAG );
            transaction.setTransition( FragmentTransaction.TRANSIT_FRAGMENT_FADE );
            transaction.replace( R.id.frame_container, fragment ).commitAllowingStateLoss();

            return true;
        }
        return false;
    }


    OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback( true ) {
        boolean doubleBackToExitPressedOnce = false;

        @Override
        public void handleOnBackPressed() {

            if (doubleBackToExitPressedOnce) {
                ActivityCompat.finishAffinity( MainActivity.this );
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText( MainActivity.this,"Press Again to exit", Toast.LENGTH_SHORT ).show();

            new Handler().postDelayed( new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000 );


        }
    };



  
}