package com.babysouk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class Fragment_Main_Page extends AppCompatActivity {
    private Context context;
    private String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment__main__page);
        context = this;

        value=getIntent().getStringExtra("key");

        Show_Product_Fragment show_product_fragment = new Show_Product_Fragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, show_product_fragment).addToBackStack(null).commit();


     /*   assert value != null;
        if(value.equals("Login")) {
            Login_Fragment login_fragment = new Login_Fragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, login_fragment).addToBackStack(null).commit();
        }*/
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(context, Home_Page.class);
        intent.putExtra("key", "profile");
        startActivity(intent);
    }
}
