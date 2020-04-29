package com.babysouk;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class Settings_Fragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private Context context;
    private Spinner spinner_country, spinner_language;

    public Settings_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings_, container, false);
        context = container.getContext();
        spinner_country = view.findViewById(R.id.settings_spinner_country);
        spinner_language = view.findViewById(R.id.settings_spinner_language);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final String[] region = {getResources().getString(R.string.uae), getResources().getString(R.string.bahraini),
                getResources().getString(R.string.egypt), getResources().getString(R.string.kuwait),getResources().getString(R.string.omani),
                getResources().getString(R.string.qatar),getResources().getString(R.string.saudi),getResources().getString(R.string.us)};

        final String[] language = {"English", "Arabic"};

        spinner_country.setOnItemSelectedListener(Settings_Fragment.this);
        ArrayAdapter adapter =  new ArrayAdapter(context,R.layout.support_simple_spinner_dropdown_item,region);
        spinner_country.setAdapter(adapter);

        spinner_country.setOnItemSelectedListener(Settings_Fragment.this);
        ArrayAdapter adapter1 =  new ArrayAdapter(context,R.layout.support_simple_spinner_dropdown_item,language);
        spinner_country.setAdapter(adapter1);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
