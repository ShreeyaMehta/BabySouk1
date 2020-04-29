package com.babysouk;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Save_Address_book extends Fragment {
    private Button add_new_address;

    public Save_Address_book() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_save__address_book, container, false);
        add_new_address = view.findViewById(R.id.btn_add_new_address);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        add_new_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Add_new_Address_Fragment add_new_address_fragment = new Add_new_Address_Fragment();
                getFragmentManager().beginTransaction().replace(R.id.frame_main2, add_new_address_fragment).addToBackStack(null).commit();

            }
        });
    }
}
