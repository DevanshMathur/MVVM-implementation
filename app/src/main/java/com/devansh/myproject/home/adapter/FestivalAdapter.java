package com.devansh.myproject.home.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.devansh.myproject.R;
import com.devansh.myproject.home.model.Festival;

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

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        viewHolder.id.setText(String.valueOf(position+1));
        viewHolder.name.setText("Name : " +festivals.get(position).getName());
        viewHolder.place.setText("Place : "+festivals.get(position).getPlace());
        String desc = festivals.get(position).getDescription();
        if(desc.length() > 60) {
            desc = desc.substring(0, 60)+"...";
        }
        viewHolder.desc.setText(desc);
        Glide.with(mContext)
                .load(festivals.get(position).getUri())
                .into(viewHolder.img);
        viewHolder.festival.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickedListener.itemClicked(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return festivals.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView id;
        private TextView name;
        private TextView place;
        private TextView desc;
        private ImageView img;
        private CardView festival;

        public ViewHolder(View view) {
            super(view);
            id = view.findViewById(R.id.tv_fest_id);
            name = view.findViewById(R.id.tv_fest_name);
            place = view.findViewById(R.id.tv_fest_place);
            desc = view.findViewById(R.id.tv_fest_desc);
            img = view.findViewById(R.id.iv_fest_img);
            festival = view.findViewById(R.id.cv_festival);
        }

    }
    public void setOnItemClickedListener(OnItemClicked onItemClickedListener) {
        this.onItemClickedListener = onItemClickedListener;
    }

    private OnItemClicked onItemClickedListener;

    public interface OnItemClicked {
        void itemClicked(int position);
    }

}
