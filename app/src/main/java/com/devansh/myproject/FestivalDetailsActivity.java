package com.devansh.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.devansh.myproject.model.Festival;

public class FestivalDetailsActivity extends AppCompatActivity {

    TextView title;
    TextView name;
    TextView description;
    ImageView image;
    ImageView backBtn;
    Button fetchBtn;
    Festival festival;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_festival_details);
        festival = getIntent().getParcelableExtra(AppUtils.FESTIVAL);
        binding();
        setData();
    }

    private void binding() {
        title = findViewById(R.id.tv_title);
        name = findViewById(R.id.tv_name);
        description = findViewById(R.id.tv_description);
        image = findViewById(R.id.iv_image);
        backBtn = findViewById(R.id.iv_back);
        fetchBtn = findViewById(R.id.btn_fetch_data);
        fetchBtn.setVisibility(View.GONE);
        backBtn.setVisibility(View.VISIBLE);
    }

    private void setData() {
        title.setText(festival.getName());
        name.setText(festival.getName());
        description.setText(festival.getDescription());
        Glide.with(this)
                .load(festival.getUri())
                .placeholder(R.drawable.india)
                .into(image);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}