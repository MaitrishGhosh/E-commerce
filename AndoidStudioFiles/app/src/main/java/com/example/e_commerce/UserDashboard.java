package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity {
    private RecyclerView hrv_featured;
    private RecyclerView hrv_best;
    private ArrayList<Arraylist> horizontalList;
    private CustomAdapter horizontalAdapter;
    private CustomAdapter horizontalAdapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            getWindow().getAttributes().layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
        }

        hrv_featured= findViewById(R.id.horizontalRecyclerView_Featured);
        hrv_best= findViewById(R.id.horizontalRecyclerView_BestSell);
        horizontalList = new ArrayList<Arraylist>();
        for (int i = 0; i < MyData.nameArray.length; i++) {
            horizontalList.add(new Arraylist(
                    MyData.nameArray[i],
                    MyData.drawableArray[i],
                    MyData.priceArray[i]
            ));
        }
        horizontalAdapter=new CustomAdapter(horizontalList);
        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        hrv_featured.setLayoutManager(horizontalLayoutManagaer);
        hrv_featured.setAdapter(horizontalAdapter);

        horizontalAdapter2=new CustomAdapter(horizontalList);
        LinearLayoutManager horizontalLayoutManagaer2
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        hrv_best.setLayoutManager(horizontalLayoutManagaer2);
        hrv_best.setAdapter(horizontalAdapter2);
    }
}