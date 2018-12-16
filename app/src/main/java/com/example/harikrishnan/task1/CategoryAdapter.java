package com.example.harikrishnan.task1;

import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private List<CategoryList> catDetails;
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


    public CategoryAdapter(Context context, List<CategoryList>catDetails) {
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
        final CategoryList categoryList = catDetails.get(position);
        holder.cat_name.setText(categoryList.getName());
        holder.cat_image.setImageResource(categoryList.getImageNo());

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