package com.babysouk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;
import com.multilevelview.MultiLevelRecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class Select_Language extends AppCompatActivity implements AdapterView.OnItemSelectedListener, NavigationView.OnNavigationItemSelectedListener {
    private Context context;
    private Spinner spinner;
    private Button english, arabic, get_started;
    private ImageView menu;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select__language);
        context = this;
        ids();
        final String[] region = {getResources().getString(R.string.uae), getResources().getString(R.string.bahraini),
                getResources().getString(R.string.egypt), getResources().getString(R.string.kuwait),getResources().getString(R.string.omani),
                getResources().getString(R.string.qatar),getResources().getString(R.string.saudi),getResources().getString(R.string.us)};


        spinner.setOnItemSelectedListener(Select_Language.this);
        final ArrayAdapter adapter =  new ArrayAdapter(context,R.layout.support_simple_spinner_dropdown_item,region);
        spinner.setAdapter(adapter);

        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                english.setTextColor(getResources().getColor(R.color.pink));
                arabic.setTextColor(getResources().getColor(R.color.black));
            }
        });

        arabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                english.setTextColor(getResources().getColor(R.color.black));
                arabic.setTextColor(getResources().getColor(R.color.pink));
                updateResources(context, "ar");
                Toast.makeText(context, getResources().getString(R.string.uae), Toast.LENGTH_SHORT).show();


            }
        });

        get_started.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, Home_Page.class));
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigationView.setVisibility(View.VISIBLE);
                drawerLayout.openDrawer(Gravity.LEFT);
                if (navigationView.isShown()) {
                    navigationView.setVisibility(View.GONE);
                }

            }
        });

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private static boolean updateResources(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Resources resources = context.getResources();

        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;

        resources.updateConfiguration(configuration, resources.getDisplayMetrics());

        return true;
    }

    private void ids() {
        spinner = findViewById(R.id.spinner);
        english = findViewById(R.id.english);
        arabic = findViewById(R.id.arabic);
        get_started = findViewById(R.id.get_started);
        menu = findViewById(R.id.ham_menu);
        navigationView = findViewById(R.id.navigation_view);
        drawerLayout = findViewById(R.id.drawer_layout);

    }


}
