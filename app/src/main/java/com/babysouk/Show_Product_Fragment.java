package com.babysouk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.babysouk.Adapters.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class Show_Product_Fragment extends Fragment {
    private Context context;
    private ImageView imageView;
    private ViewPager viewPager_tabs;
    private TabLayout tabs;
    private Button add_to_cart;
    private LinearLayout gift_wrap;

    public Show_Product_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_show__product_, container, false);
        context = container.getContext();
        viewPager_tabs = view.findViewById(R.id.tab_viewpager);
        tabs = view.findViewById(R.id.tabs);
        add_to_cart = view.findViewById(R.id.product_add_to_cart);
        gift_wrap = view.findViewById(R.id.product_linear_gift);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabs.addTab(tabs.newTab().setText("Overview"));
        tabs.addTab(tabs.newTab().setText("Brand Story"));
        tabs.addTab(tabs.newTab().setText("Delivery"));
        tabs.addTab(tabs.newTab().setText("Reviews"));

        final ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(context, getFragmentManager(), tabs.getTabCount());
        viewPager_tabs.setAdapter(viewPagerAdapter);

        viewPager_tabs.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager_tabs.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login_Fragment login_fragment = new Login_Fragment();
                getFragmentManager().beginTransaction().replace(R.id.frame_layout, login_fragment).addToBackStack(null).commit();
            }
        });

        gift_wrap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gift = new Intent(context, Main2Activity.class);
                gift.putExtra("key","Gift_Wrap");
                startActivity(gift);
            }
        });
    }
}
