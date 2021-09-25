package com.example.gobasket.data_provider;

import com.example.gobasket.R;
import com.example.gobasket.model.ItemModel;

import java.util.ArrayList;

public class DataProvider {
    public static ArrayList<ItemModel> getExclusiveOfferData(){
        ArrayList<ItemModel> list = new ArrayList<>();
        list.add(new ItemModel("Organic Bananas","7pcs, Priceg", R.drawable.oragnic_banana,4.99f));
        list.add(new ItemModel("Red Apples","1kg,Priceg", R.drawable.red_apple,4.99f));
        list.add(new ItemModel("Organic Bananas","7pcs, Priceg", R.drawable.oragnic_banana,4.99f));
        list.add(new ItemModel("Red Apples","1kg,Priceg", R.drawable.red_apple,4.99f));
        return list;
    }

    public static ArrayList<ItemModel> getGroceriesData(){
        ArrayList<ItemModel> list = new ArrayList<>();
        list.add(new ItemModel("Pulses","1kg,Price",R.drawable.pulses_x,R.color.lightOrange,R.drawable.pulses_2x));
        list.add(new ItemModel("Rice","1kg,Price",R.drawable.rice_x,R.color.lightGreen,R.drawable.rice));
        return list;
    }

    public static ArrayList<ItemModel> getBestSellingData(){
        ArrayList<ItemModel> list = new ArrayList<>();
        list.add(new ItemModel("Bell Pepper Red","7pcs,Priceg", R.drawable.bellpepper,4.99f));
        list.add(new ItemModel("Ginger","1kg,Priceg", R.drawable.ginger,4.99f));
        list.add(new ItemModel("Bell Pepper Red","7pcs,Priceg", R.drawable.bellpepper,4.99f));
        list.add(new ItemModel("Ginger","1kg,Priceg", R.drawable.ginger,4.99f));
        return list;
    }
}
