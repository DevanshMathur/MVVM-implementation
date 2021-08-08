package com.devansh.myproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.devansh.myproject.adapter.FestivalAdapter;
import com.devansh.myproject.model.Festival;
import com.devansh.myproject.repositories.FestivalRepository;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    RecyclerView rvFestivals;
    FestivalAdapter festivalAdapter;
    FestivalRepository festivalRepository;
    ArrayList<Festival> festivals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        festivalRepository = new FestivalRepository().getInstance();
        festivals = festivalRepository.getFestivals();

        rvFestivals = findViewById(R.id.rv_festivals);
        festivalAdapter = new FestivalAdapter(this, festivals);
        rvFestivals.setAdapter(festivalAdapter);
        rvFestivals.setLayoutManager(new LinearLayoutManager(this));
    }
}