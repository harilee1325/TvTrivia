package com.example.harikrishnan.task1;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<CategoryList> catDetails = new ArrayList<>();
    private RecyclerView recyclerView;
    private CategoryAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        recyclerView =findViewById(R.id.recycler_view);



        mAdapter = new CategoryAdapter(this,catDetails);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareCategoryData();
    }

    private void prepareCategoryData() {
        CategoryList categoryList = new CategoryList("Breaking Bad",R.drawable.breakingbadcat);
        catDetails.add(categoryList);

        categoryList = new CategoryList("Friends",R.drawable.newfriendscat);
        catDetails.add(categoryList);

        categoryList = new CategoryList("Game of thrones",R.drawable.gameofthronescat);
        catDetails.add(categoryList);

        categoryList = new CategoryList("How i met your mother",R.drawable.newhimymcat);
        catDetails.add(categoryList);



        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}