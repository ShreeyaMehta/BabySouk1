package com.babysouk;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.transition.Visibility;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class Gift_Wrap_Fragment extends Fragment {
    private LinearLayout show_send, show_ribbon, show_tag, show_msg;
    private RelativeLayout save_details, ribbon, tags, message;
    private ImageView address_book;

    public Gift_Wrap_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gift__wrap_, container, false);

        show_send = view.findViewById(R.id.gift_send);
        save_details = view.findViewById(R.id.linear_send_gift);
        show_ribbon = view.findViewById(R.id.gift_ribbon);
        ribbon = view.findViewById(R.id.linear_gift_ribbon);
        show_tag = view.findViewById(R.id.gift_tag);
        tags = view.findViewById(R.id.linear_gift_tag);
        show_msg = view.findViewById(R.id.gift_msg);
        message = view.findViewById(R.id.linear_gift_msg);
        address_book = view.findViewById(R.id.img_address_book);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        show_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              changeVisibility(save_details);
              ribbon.setVisibility(View.GONE);
              tags.setVisibility(View.GONE);
              message.setVisibility(View.GONE);
            }
        });

        show_ribbon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeVisibility(ribbon);
                save_details.setVisibility(View.GONE);
                tags.setVisibility(View.GONE);
                message.setVisibility(View.GONE);
            }
        });

        show_tag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeVisibility(tags);
                save_details.setVisibility(View.GONE);
                ribbon.setVisibility(View.GONE);
                message.setVisibility(View.GONE);
            }
        });

        show_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeVisibility(message);
                ribbon.setVisibility(View.GONE);
                tags.setVisibility(View.GONE);
                save_details.setVisibility(View.GONE);
            }
        });

        address_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Save_Address_book save_address_book = new Save_Address_book();
                getFragmentManager().beginTransaction().replace(R.id.frame_main2, save_address_book).addToBackStack(null).commit();

            }
        });
    }

    private void changeVisibility(RelativeLayout relativeLayout){
        if(relativeLayout.getVisibility() == View.GONE){
            relativeLayout.setVisibility(View.VISIBLE);
        }else{
            relativeLayout.setVisibility(View.GONE);
        }
    }
}
