package com.devansh.myproject.festivalDetails;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.devansh.myproject.appUtils.AppUtils;
import com.devansh.myproject.R;
import com.devansh.myproject.festivalDetails.fragment.FestivalDetailFragment;
import com.devansh.myproject.home.model.Festival;

import java.util.ArrayList;


public class FestivalDetailsActivity extends AppCompatActivity {

    TextView title;
    ImageView backBtn;
    Button previous;
    Button next;
    ArrayList<Festival> festival;
    int position;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_festival_details);
        festival = (ArrayList<Festival>) getIntent().getSerializableExtra(AppUtils.FESTIVAL);
        position = getIntent().getIntExtra(AppUtils.POSITION,0);
        bundle = new Bundle();
        binding();
        clickEventSetup();
        loadFestival();
    }

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