package com.example.harikrishnan.task1;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private List<Movie> catDetails;
    private Context context;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView cat_name;
        public ImageView cat_image;
        public LinearLayout linearLayout;

        public MyViewHolder(View view ) {
            super(view);
            cat_image = view.findViewById(R.id.catImage);
            cat_name = view.findViewById(R.id.catName);
            linearLayout = view.findViewById(R.id.linearlayout);



        }
    }


    public MoviesAdapter(Context context, List<Movie>catDetails) {
        this.catDetails = catDetails;
        this.context = context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_list, parent, false);



        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final Movie movie = catDetails.get(position);
        holder.cat_name.setText(movie.getName());
        holder.cat_image.setImageResource(movie.getImageNo());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,Questions.class);
                intent.putExtra("catNumber",position);
                context.startActivity(intent);
            }
        });




    }

    @Override
    public int getItemCount() {
        return catDetails.size();
    }
}