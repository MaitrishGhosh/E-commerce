package com.example.e_commerce.Item;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.e_commerce.Arraylist;
import com.example.e_commerce.R;

import java.util.ArrayList;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.MyViewHolder>{

    private ArrayList<Integer> dataSet;
    static View prev;
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView itemColor;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.itemColor = itemView.findViewById(R.id.itemColor);
            itemView.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v)
                {
                    //Toast.makeText(v.getContext(), " Item Clicked", Toast.LENGTH_SHORT).show();
                    if(prev!=null) prev.setAlpha(1f);
                    v.setAlpha(0.5f);
                    prev = v;
                }
            });
        }
    }

    public ColorAdapter(ArrayList<Integer> data) {
        this.dataSet = data;
    }

    @Override
    public ColorAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.color, parent, false);

        return new ColorAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ColorAdapter.MyViewHolder holder, final int listPosition) {

        ImageView color = holder.itemColor;
        color.setBackgroundColor(dataSet.get(listPosition));
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
