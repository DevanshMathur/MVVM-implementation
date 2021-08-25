package com.devansh.myproject.festivalDetails.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.devansh.myproject.R;
import com.devansh.myproject.appUtils.AppUtils;
import com.devansh.myproject.home.model.Festival;

import java.util.ArrayList;


public class FestivalDetailFragment extends Fragment {

    TextView name;
    TextView place;
    TextView description;
    ImageView image;
    Festival festival;
    int position;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_festival_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding(view);
        fragmentSetup();
    }

    private void fragmentSetup() {
        position = getArguments().getInt(AppUtils.POSITION);
        festival = (Festival) getArguments().getSerializable(AppUtils.FESTIVAL);
        name.setText("Name :- "+festival.getName());
        place.setText("Place :- "+festival.getPlace());
        description.setText(festival.getDescription());
        Glide.with(this)
                .load(festival.getUri())
                .placeholder(R.drawable.india)
                .into(image);
    }

    private void binding(View view) {
        name = view.findViewById(R.id.tv_name);
        place = view.findViewById(R.id.tv_place);
        description = view.findViewById(R.id.tv_description);
        image = view.findViewById(R.id.iv_image);
    }
}