package com.devansh.myproject.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

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
    int size;
    int lastVisibleItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        context = this;
        onItemClicked = this;
        rvFestivals = findViewById(R.id.rv_festivals);
        rvFestivals.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) rvFestivals.getLayoutManager();
                lastVisibleItem = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                if(lastVisibleItem == size-1 && size < 9 ) {
                    fetchData();
                }

            }
        });
        initializeView();
        viewModelFestival = new ViewModelProvider(this).get(ViewModelFestival.class);
        viewModelFestival.getMutableLiveData().observe(this,festListUpdateObserver);
    }

    private void initializeView() {
        TextView title = findViewById(R.id.tv_title);
        title.setText("Home");
        festivalAdapter = new FestivalAdapter(context, festivals);
        festivalAdapter.setOnItemClickedListener(onItemClicked);
        rvFestivals.setLayoutManager(new LinearLayoutManager(context));
        rvFestivals.setAdapter(festivalAdapter);
    }

    private void fetchData() {
        viewModelFestival.updateData();
    }

    Observer<ArrayList<Festival>> festListUpdateObserver = new Observer<ArrayList<Festival>>() {
        @Override
        public void onChanged(ArrayList<Festival> festivals) {
            HomeActivity.festivals = festivals;
            HomeActivity.this.size = festivals.size();
            festivalAdapter.setFestivalsList(HomeActivity.festivals);
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