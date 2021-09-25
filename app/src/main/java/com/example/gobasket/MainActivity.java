package com.example.gobasket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.LinearLayout;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.gobasket.adapters.GroceriesAdapter;
import com.example.gobasket.adapters.ItemAdapters;
import com.example.gobasket.data_provider.DataProvider;
import com.example.gobasket.model.ItemModel;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageSlider imageSlider;
    RecyclerView exclusiveRecyclerView;
    RecyclerView GroceriesRecyclerView;
    RecyclerView bestSellingRecyclerView;
    ArrayList<ItemModel> items;
    ArrayList<ItemModel> grocery_items;
    ArrayList<ItemModel> bestSelling_item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageSlider = findViewById(R.id.imageSlider);
        exclusiveRecyclerView = findViewById(R.id.exclusive_offer_RV);
        GroceriesRecyclerView = findViewById(R.id.groceries_RV);
        bestSellingRecyclerView = findViewById(R.id.best_selling_RV);
        initImageSlider();
        initExclusiveRecyclerView();
        initGroceriesRecyclerView();
        initBestSellingRecyclerView();
    }

    private void initImageSlider(){
        ArrayList<SlideModel> images = new ArrayList<>();
        images.add(new SlideModel(R.drawable.slide1,null));
        images.add(new SlideModel(R.drawable.slide1,null));
        images.add(new SlideModel(R.drawable.slide1,null));

        imageSlider.setImageList(images);
    }

    private void initExclusiveRecyclerView(){
        items = new ArrayList<>();
        items= DataProvider.getExclusiveOfferData();
        ItemAdapters adapter = new ItemAdapters(this,items);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        exclusiveRecyclerView.setLayoutManager(manager);
        exclusiveRecyclerView.setAdapter(adapter);
    }

    private void initGroceriesRecyclerView(){
        grocery_items = new ArrayList<>();
        grocery_items = DataProvider.getGroceriesData();
        GroceriesAdapter adapter = new GroceriesAdapter(this, grocery_items, new GroceriesAdapter.ItemClickListener() {
            @Override
            public void onItemClick(ItemModel item) {
                Log.e("error",item.getTitle()+" "+item.getSubTitle());
                Intent i = new Intent(MainActivity.this,DetailPage.class);
                i.putExtra("img",item.getLargeImage());
                i.putExtra("title",item.getTitle());
                i.putExtra("subtitle",item.getSubTitle());

                startActivity(i);
            }
        });
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        GroceriesRecyclerView.setLayoutManager(manager);
        GroceriesRecyclerView.setAdapter(adapter);
    }

    private void initBestSellingRecyclerView(){
        bestSelling_item = new ArrayList<>();
        bestSelling_item= DataProvider.getBestSellingData();
        ItemAdapters adapter = new ItemAdapters(this,bestSelling_item);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        bestSellingRecyclerView.setLayoutManager(manager);
        bestSellingRecyclerView.setAdapter(adapter);
    }
}