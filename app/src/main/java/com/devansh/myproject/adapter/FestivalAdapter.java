package com.devansh.myproject.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.devansh.myproject.R;
import com.devansh.myproject.model.Festival;

import java.util.ArrayList;

public class FestivalAdapter extends RecyclerView.Adapter<FestivalAdapter.ViewHolder> {

    private ArrayList<Festival> festivals;
    private Context mContext;

    public FestivalAdapter(Context context, ArrayList<Festival> dataSet) {
        festivals = dataSet;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        viewHolder.name.setText(festivals.get(position).getName());
        viewHolder.desc.setText(festivals.get(position).getDescription());
        Glide.with(mContext)
                .load(festivals.get(position).getUri())
                .into(viewHolder.img);
    }

    @Override
    public int getItemCount() {
        return festivals.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView desc;
        private ImageView img;

        public ViewHolder(View view) {
            super(view);

            name = view.findViewById(R.id.tv_fest_name);
            desc = view.findViewById(R.id.tv_fest_desc);
            img = view.findViewById(R.id.iv_fest_img);
        }

    }

}
