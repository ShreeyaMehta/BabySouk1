package com.babysouk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home_Page extends AppCompatActivity {
    private Context context;
    private BottomNavigationView bottomNavigationView;
    private String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__page);
        context = this;
        ids();

        value = getIntent().getStringExtra("key");

        if(value == null){
            loadfragment(new Home_Fragment());
        }else if(value.equals("profile")){
            loadfragment(new Account_Fragment());
            bottomNavigationView.setSelectedItemId(R.id.navigation_account);
        }


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        bottomNavigationView.setItemIconTintList(null);
                        loadfragment(new Home_Fragment());
                        return true;
                    case R.id.navigation_brands:
                        bottomNavigationView.setItemIconTintList(null);
                        loadfragment(new Brands_Fragment());
                        return true;
                    case R.id.navigation_offers:
                        bottomNavigationView.setItemIconTintList(null);
                        loadfragment(new Offers_Fragment());
                        return true;
                    case R.id.navigation_wishlist:
                        bottomNavigationView.setItemIconTintList(null);
                        loadfragment(new Wishlist_Fragment());
                        return true;
                    case R.id.navigation_account:
                        bottomNavigationView.setItemIconTintList(null);
                        loadfragment(new Account_Fragment());
                        return true;
                }
                return false;
            }
        });
    }

    private void ids() {
        bottomNavigationView = findViewById(R.id.bottom_navigation);
    }

    private void loadfragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        FragmentManager mgr = getSupportFragmentManager();
        if (mgr.getBackStackEntryCount() == 1) {
            // No backstack to pop, so calling super
            finish();
        } else {
            mgr.popBackStack();
        }
    }
}
