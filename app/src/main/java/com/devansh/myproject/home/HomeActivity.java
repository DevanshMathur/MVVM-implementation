package com.devansh.myproject.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.devansh.myproject.R;
import com.devansh.myproject.home.adapter.FestivalAdapter;
import com.devansh.myproject.home.model.Festival;
import com.devansh.myproject.home.viewmodel.ViewModelFestival;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements LifecycleOwner {

    int size;
    int lastVisibleItem;
    RecyclerView rvFestivals;
    ArrayList<Festival> festivals = new ArrayList<>();
    FestivalAdapter festivalAdapter;
    ViewModelFestival viewModelFestival;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        rvFestivals = findViewById(R.id.rv_festivals);
        rvFestivals.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = ((LinearLayoutManager) rvFestivals.getLayoutManager()).findLastCompletelyVisibleItemPosition();
                if (lastVisibleItem == size - 1 && size < 10) {
                    progressBar.setVisibility(View.VISIBLE);
                    fetchData();
                }
            }
        });
        initializeView();
        viewModelFestival = new ViewModelProvider(this).get(ViewModelFestival.class);
        viewModelFestival.getLiveData().observe(this, festivals -> {
            HomeActivity.this.festivals = festivals;
            HomeActivity.this.size = festivals.size();
            festivalAdapter.setFestivalsList(HomeActivity.this.festivals);
            progressBar.setVisibility(View.GONE);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        progressBar.setVisibility(View.VISIBLE);
        lastVisibleItem = ((LinearLayoutManager) rvFestivals.getLayoutManager()).findLastCompletelyVisibleItemPosition();
        if (lastVisibleItem == size - 1 && size < 9) {
            fetchData();
        }
    }

    private void initializeView() {
        progressBar = new ProgressBar(this);
        TextView title = findViewById(R.id.tv_title);
        title.setText(R.string.title_home);
        festivalAdapter = new FestivalAdapter(this, festivals);
        rvFestivals.setLayoutManager(new LinearLayoutManager(this));
        rvFestivals.setAdapter(festivalAdapter);
    }

    private void fetchData() {
        viewModelFestival.updateData();
    }

//    Observer<ArrayList<Festival>> festListUpdateObserver = new Observer<ArrayList<Festival>>() {
//        @Override
//        public void onChanged(ArrayList<Festival> festivals) {
//            HomeActivity.this.festivals = festivals;
//            HomeActivity.this.size = festivals.size();
//            festivalAdapter.setFestivalsList(HomeActivity.this.festivals);
//        }
//    };


}