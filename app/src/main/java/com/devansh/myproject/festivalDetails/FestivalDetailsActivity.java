package com.devansh.myproject.festivalDetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.devansh.myproject.appUtils.AppUtils;
import com.devansh.myproject.R;
import com.devansh.myproject.festivalDetails.fragment.FestivalDetailFragment;
import com.devansh.myproject.home.model.Festival;
import com.devansh.myproject.home.viewmodel.ViewModelFestival;

import java.util.ArrayList;


public class FestivalDetailsActivity extends AppCompatActivity {

    TextView title;
    ImageView backBtn;
    Button previous;
    Button next;
    ArrayList<Festival> festival = new ArrayList<>();
    int position;
    Bundle bundle;
    Context mContext;
    ViewModelFestival viewModelFestival;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_festival_details);
        festival = (ArrayList<Festival>) getIntent().getSerializableExtra(AppUtils.FESTIVAL);
        position = getIntent().getIntExtra(AppUtils.POSITION,0);
        bundle = new Bundle();
        mContext = this;
        binding();
        clickEventSetup();
        viewModelFestival = new ViewModelProvider(this).get(ViewModelFestival.class);
        viewModelFestival.getMutableLiveData().observe(this,festListObserver);
        loadFestival();
    }

    Observer<ArrayList<Festival>> festListObserver = new Observer<ArrayList<Festival>>() {
        @Override
        public void onChanged(ArrayList<Festival> festivals) {
            FestivalDetailsActivity.this.festival = festivals;
        }
    };

    private void binding() {
        title = findViewById(R.id.tv_title);
        backBtn = findViewById(R.id.iv_back);
        previous = findViewById(R.id.previous);
        next = findViewById(R.id.next);
        backBtn.setVisibility(View.VISIBLE);
    }

    private void changeButtonVisibility() {
        if (position == 0) {
            previous.setVisibility(View.GONE);
            next.setVisibility(View.VISIBLE);
        } else if (position == festival.size()-1){
            previous.setVisibility(View.VISIBLE);
            next.setVisibility(View.GONE);
        } else {
            previous.setVisibility(View.VISIBLE);
            next.setVisibility(View.VISIBLE);
        }
    }

    private void clickEventSetup() {
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position--;
                loadFestival();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position++;
                loadFestival();
            }
        });
    }

    private void loadFestival() {
        if(position >= festival.size()-1 && festival.size() < 10)
        {
            viewModelFestival.updateData();
        }
        changeButtonVisibility();
        bundle.putInt(AppUtils.POSITION,position);
        bundle.putSerializable(AppUtils.FESTIVAL,festival.get(position));
        title.setText(festival.get(position).getName());
        FestivalDetailFragment fragment = new FestivalDetailFragment();
        fragment.setArguments(bundle);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.festival_fragment,fragment)
        .commit();

    }
}