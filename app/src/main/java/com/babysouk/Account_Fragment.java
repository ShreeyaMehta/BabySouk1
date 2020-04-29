package com.babysouk;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class Account_Fragment extends Fragment {
    private Context context;
    private Button Sign_out;
    private LinearLayout my_profile, my_orders, address_book, contact_us, rate_app, settings;

    public Account_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account_, container, false);
        context = container.getContext();
        Sign_out = view.findViewById(R.id.sign_out);
        my_profile = view.findViewById(R.id.account_profile);
        my_orders = view.findViewById(R.id.account_my_orders);
        address_book = view.findViewById(R.id.account_address);
        contact_us = view.findViewById(R.id.account_contact_us);
        rate_app = view.findViewById(R.id.account_rate_us);
        settings = view.findViewById(R.id.account_settings);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Sign_out.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                Intent Login = new Intent(getActivity(),Fragment_Main_Page.class);
                Login.putExtra("key","Login");
                Objects.requireNonNull(getActivity()).startActivity(Login);
            }
        });

        my_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profile = new Intent(context, Main2Activity.class);
                profile.putExtra("key", "profile");
                startActivity(profile);
            }
        });

        my_orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        address_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent address_book = new Intent(context, Main2Activity.class);
                address_book.putExtra("key", "address_book");
                startActivity(address_book);
            }
        });

        contact_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent contact = new Intent(context, Main2Activity.class);
                contact.putExtra("key", "contact");
                startActivity(contact);
            }
        });

        rate_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent settings = new Intent(context, Main2Activity.class);
                settings.putExtra("key", "settings");
                startActivity(settings);
            }
        });
    }
}
