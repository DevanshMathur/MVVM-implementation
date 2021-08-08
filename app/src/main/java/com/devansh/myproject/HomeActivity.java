package com.devansh.myproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.devansh.myproject.adapter.FestivalAdapter;
import com.devansh.myproject.model.Festival;
import com.devansh.myproject.viewmodel.ViewModelFestival;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements LifecycleOwner {

    Context context;
    RecyclerView rvFestivals;
    FestivalAdapter festivalAdapter;
    ViewModelFestival viewModelFestival;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        context = this;
        rvFestivals = findViewById(R.id.rv_festivals);
        viewModelFestival = new ViewModelProvider(this).get(ViewModelFestival.class);
        viewModelFestival.getMutableLiveData().observe(this,festListUpdateObserver);
    }

    Observer<ArrayList<Festival>> festListUpdateObserver = new Observer<ArrayList<Festival>>() {
        @Override
        public void onChanged(ArrayList<Festival> festivals) {
            festivalAdapter = new FestivalAdapter(context, festivals);
            rvFestivals.setLayoutManager(new LinearLayoutManager(context));
            rvFestivals.setAdapter(festivalAdapter);
        }
    };
}