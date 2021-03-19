package com.example.movieapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adaptery extends RecyclerView.Adapter<com.example.movieapp.Adaptery.MyViewHolder> {


    private Context mContext;
    private List<com.example.movieapp.MoviesModelClass> mData;

    public Adaptery(Context mContext, List<com.example.movieapp.MoviesModelClass> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        v = inflater.inflate(R.layout.movie_item, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name.setText(mData.get((position)).getTitle());
        holder.avgvote.setText(mData.get(position).vote_average);
        holder.popularity.setText(mData.get(position).getPopularity());

        //using glide library to display image

        Glide.with(mContext)
                .load("https://image.tmdb.org/t/p/w500/"+mData.get(position).getPoster_path())
                .into(holder.img);


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView name;
        TextView popularity;
        TextView avgvote;
        ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            name = itemView.findViewById(R.id.title);
            popularity= itemView.findViewById(R.id.popularity);
           avgvote= itemView.findViewById(R.id.vote_avg);
            img = itemView.findViewById(R.id.imageView);
        }
    }
}
