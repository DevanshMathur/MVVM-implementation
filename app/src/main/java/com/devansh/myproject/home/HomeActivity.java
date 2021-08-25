package com.devansh.myproject.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.devansh.myproject.appUtils.AppUtils;
import com.devansh.myproject.R;
import com.devansh.myproject.festivalDetails.FestivalDetailsActivity;
import com.devansh.myproject.home.adapter.FestivalAdapter;
import com.devansh.myproject.home.model.Festival;
import com.devansh.myproject.home.viewmodel.ViewModelFestival;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements LifecycleOwner, FestivalAdapter.OnItemClicked {

    Context context;
    RecyclerView rvFestivals;
    static ArrayList<Festival> festivals = new ArrayList<>();
    FestivalAdapter festivalAdapter;
    ViewModelFestival viewModelFestival;
    FestivalAdapter.OnItemClicked onItemClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        context = this;
        onItemClicked = this;
        rvFestivals = findViewById(R.id.rv_festivals);
        initializeView();
        viewModelFestival = new ViewModelProvider(this).get(ViewModelFestival.class);
        viewModelFestival.getMutableLiveData().observe(this,festListUpdateObserver);
        findViewById(R.id.btn_fetch_data).setVisibility(View.VISIBLE);
        findViewById(R.id.btn_fetch_data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchData();
            }
        });
    }

    private void initializeView() {

    }

    private void fetchData() {
        viewModelFestival.updateData();
    }

    Observer<ArrayList<Festival>> festListUpdateObserver = new Observer<ArrayList<Festival>>() {
        @Override
        public void onChanged(ArrayList<Festival> festivals) {
            HomeActivity.festivals = festivals;
            festivalAdapter = new FestivalAdapter(context, festivals);
            festivalAdapter.setOnItemClickedListener(onItemClicked);
            rvFestivals.setLayoutManager(new LinearLayoutManager(context));
            rvFestivals.setAdapter(festivalAdapter);
        }
    };

    @Override
    public void itemClicked(int position) {
        Intent intent = new Intent(this, FestivalDetailsActivity.class);
        intent.putExtra(AppUtils.FESTIVAL,HomeActivity.festivals);
        intent.putExtra(AppUtils.POSITION,position);
        startActivity(intent);
    }
}