package com.babysouk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class Register_Fragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private Context context;
    private EditText first_name, last_name, email, password, confirm_password;
    private Spinner spinner;
    private CheckBox checkBox;
    private Button register;

    public Register_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register_, container, false);
        context = container.getContext();
        register = view.findViewById(R.id.btn_register);
        first_name = view.findViewById(R.id.register_first_name);
        last_name = view.findViewById(R.id.register_last_name);
        email = view.findViewById(R.id.register_email);
        password = view.findViewById(R.id.register_password);
        confirm_password = view.findViewById(R.id.register_confirm_password);
        spinner = view.findViewById(R.id.register_spinner);
        checkBox = view.findViewById(R.id.register_check_box);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String[] hear = {getResources().getString(R.string.hear_about),getResources().getString(R.string.ram), getResources().getString(R.string.fb),
                getResources().getString(R.string.google), getResources().getString(R.string.insta), getResources().getString(R.string.bb),
                getResources().getString(R.string.tok), getResources().getString(R.string.frnds), getResources().getString(R.string.other)};


        spinner.setOnItemSelectedListener(Register_Fragment.this);
        ArrayAdapter adapter =  new ArrayAdapter(context,R.layout.support_simple_spinner_dropdown_item,hear);
        spinner.setAdapter(adapter);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, Home_Page.class));
            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
