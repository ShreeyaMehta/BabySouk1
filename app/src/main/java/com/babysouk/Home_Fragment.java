package com.babysouk;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.babysouk.Adapters.ViewPagerImageAdapter;
import com.google.android.material.tabs.TabLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home_Fragment extends Fragment {
    private Context context;
    private ViewPager viewPager;
    private RecyclerView recyclerView;
    private TabLayout tabLayout;

    public Home_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_, container, false);

        int[] urls = new int[]{R.drawable.download, R.drawable.downloads, R.drawable.downloadss};

       context = container.getContext();


       viewPager = view.findViewById(R.id.view_pager);
       //recyclerView = view.findViewById(R.id.recently_viewed_rv);
       tabLayout = view.findViewById(R.id.tab_layout);

        ViewPagerImageAdapter viewPagerImageAdapter = new ViewPagerImageAdapter(context, urls);
        viewPager.setAdapter(viewPagerImageAdapter);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }
}
