package com.babysouk.Adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.babysouk.Brand_Story_Fragment;
import com.babysouk.Delivery_Fragment;
import com.babysouk.Overview_Fragment;
import com.babysouk.Review_Fragment;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private Context context;
    private int totalTabs;
    public ViewPagerAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        context = context;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Overview_Fragment overview_fragment = new Overview_Fragment();
                return overview_fragment;
            case 1:
                Brand_Story_Fragment brand_story_fragment = new Brand_Story_Fragment();
                return brand_story_fragment;
            case 2:
                Delivery_Fragment delivery_fragment = new Delivery_Fragment();
                return delivery_fragment;
            case 3:
                Review_Fragment review_fragment = new Review_Fragment();
                return review_fragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}