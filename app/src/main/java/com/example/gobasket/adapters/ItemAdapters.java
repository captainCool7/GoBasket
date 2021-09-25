package com.example.gobasket.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gobasket.R;
import com.example.gobasket.model.ItemModel;

import java.util.ArrayList;

public class ItemAdapters extends RecyclerView.Adapter<ItemAdapters.ItemViewHolder> {

    Context context;
    ArrayList<ItemModel> items;

    public ItemAdapters(Context context, ArrayList<ItemModel> items){
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.exclusive_item,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ItemModel item = items.get(position);
        holder.itemImage.setImageResource(item.getImage());
        holder.itemTitle.setText(item.getTitle());
        holder.itemSubtitle.setText(item.getSubTitle());
        holder.itemPrice.setText("$"+ item.getPrice());
//        holder.itemCount.setText(item.getCount()+"");
        holder.addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.setCount(1);
                holder.itemCount.setText(item.getCount()+"");
                holder.addItem.setVisibility(View.GONE);
                holder.addMore.setVisibility(View.VISIBLE);
            }
        });

        holder.itemMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = item.getCount();
                count--;
                if(count==0){
                    holder.addItem.setVisibility(View.VISIBLE);
                    holder.addMore.setVisibility(View.GONE);
                }else {
                    holder.itemCount.setText(count+"");
                }
                item.setCount(count);
            }
        });

        holder.itemAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = item.getCount();
                if(count<99){
                    count++;
                    holder.itemCount.setText(count+"");
                }
                item.setCount(count);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        ImageView itemImage;
        TextView itemTitle;
        TextView itemSubtitle;
        TextView itemPrice;
        TextView itemCount;
        ImageButton addItem;
        LinearLayout addMore;
        ImageButton itemMinus;
        ImageButton itemAdd;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
            itemTitle = itemView.findViewById(R.id.item_title);
            itemSubtitle = itemView.findViewById(R.id.item_subtitle);
            itemPrice = itemView.findViewById(R.id.item_price);
            itemCount = itemView.findViewById(R.id.item_count);
            addItem = itemView.findViewById(R.id.addItem);
            addMore = itemView.findViewById(R.id.addMore);
            itemMinus = itemView.findViewById(R.id.item_minus);
            itemAdd = itemView.findViewById(R.id.item_add);
        }
    }
}
