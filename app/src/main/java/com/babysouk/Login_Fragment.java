package com.babysouk;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class Login_Fragment extends Fragment {
    private Context context;
    private EditText email, password, password_recover;
    private Button sign_in, recover_password;
    private TextView forgot_Password, sign_up;

    public Login_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login_, container, false);
        context = container.getContext();
        sign_up = view.findViewById(R.id.login_Sign_up);
        sign_in = view.findViewById(R.id.sign_in);
        forgot_Password = view.findViewById(R.id.Forgot_Password);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register_Fragment register_fragment = new Register_Fragment();
                getFragmentManager().beginTransaction().replace(R.id.frame_layout, register_fragment).addToBackStack(null).commit();
            }
        });

        forgot_Password.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                Log.d("click", "clicked");
                LayoutInflater layoutInflater = LayoutInflater.from(context);
                View view1 = layoutInflater.inflate(R.layout.recover_password, null);
                final AlertDialog alertDialog = new AlertDialog.Builder(context).create();
                Log.d("inflate", "inflate");
                recover_password = view1.findViewById(R.id.recover_btn);
                password_recover = view1.findViewById(R.id.edt_alert_email);
                recover_password.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });
                Objects.requireNonNull(alertDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                alertDialog.setView(view1);
                alertDialog.show();
            }
        });

        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, Home_Page.class));
            }
        });
    }
}
