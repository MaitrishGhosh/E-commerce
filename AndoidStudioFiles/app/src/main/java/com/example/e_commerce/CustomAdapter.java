package com.example.e_commerce;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.e_commerce.Item.SelectedItem;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private ArrayList<Arraylist> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewPrice;
        ImageView imageViewIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = itemView.findViewById(R.id.itemname);
            this.imageViewIcon = itemView.findViewById(R.id.image);
            this.textViewPrice = itemView.findViewById(R.id.itemprice);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    //ssToast.makeText(v.getContext(), " Item Clicked", Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(v.getContext(), SelectedItem.class);
                    v.getContext().startActivity((intent));
                }
            });
        }
    }

    public CustomAdapter(ArrayList<Arraylist> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);

        return new MyViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewName;
        TextView textViewPrice = holder.textViewPrice;
        ImageView imageView = holder.imageViewIcon;

        textViewName.setText(dataSet.get(listPosition).getName());
        imageView.setImageResource(dataSet.get(listPosition).getImage());
        textViewPrice.setText("$ " +dataSet.get(listPosition).getPrice());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }}