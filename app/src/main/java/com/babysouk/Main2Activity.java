package com.babysouk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Main2Activity extends AppCompatActivity {
    private Context context;
    private BottomNavigationView bottomNavigationView;
    private String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        context = this;
        ids();

        value=getIntent().getStringExtra("key");


        assert value != null;
        switch (value) {
            case "address_book":
                loadfragment(new Save_Address_book());
                break;
            case "contact":
                loadfragment(new Contact_us_Fragment());
                break;
            case "profile":
                loadfragment(new Profile_info_Fragment());
                break;
            case "settings":
                loadfragment(new Settings_Fragment());
                break;
            default:
                loadfragment(new Account_Fragment());
                break;
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
        fragmentTransaction.replace(R.id.frame_main2, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(context, Home_Page.class);
        intent.putExtra("key", "profile");
        startActivity(intent);
    }
}
