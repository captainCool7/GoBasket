package com.example.gobasket.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gobasket.R;
import com.example.gobasket.model.ItemModel;

import java.util.ArrayList;

public class GroceriesAdapter extends RecyclerView.Adapter<GroceriesAdapter.GrocerieHolder> {
    Context context;
    ArrayList<ItemModel> items;
    private ItemClickListener mItemClickListener;

    public GroceriesAdapter(Context context, ArrayList<ItemModel> items,ItemClickListener itemClickListener){
        this.context = context;
        this.items = items;
        this.mItemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public GroceriesAdapter.GrocerieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.groceries_item,parent,false);
        return new GroceriesAdapter.GrocerieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GrocerieHolder holder, int position) {

        ItemModel item = items.get(position);
        holder.itemTitle.setText(item.getTitle());
        holder.itemImage.setImageResource(item.getImage());
        holder.itemLayout.setCardBackgroundColor(item.getColor());
        holder.itemView.setOnClickListener(view ->{
            mItemClickListener.onItemClick(item);
        });
    }

    public interface ItemClickListener{
        void onItemClick(ItemModel items);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class GrocerieHolder extends RecyclerView.ViewHolder{
        ImageView itemImage;
        TextView itemTitle;
        CardView itemLayout;

        public GrocerieHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.grocery_item_image);
            itemTitle = itemView.findViewById(R.id.grocery_item_title);
            itemLayout = itemView.findViewById(R.id.grocery_item);
        }
    }
}
