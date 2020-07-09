package com.example.e_commerce.Item;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.e_commerce.Arraylist;
import com.example.e_commerce.CustomAdapter;
import com.example.e_commerce.MyData;
import com.example.e_commerce.R;
import com.example.e_commerce.UserDashboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectedItem extends AppCompatActivity {

    private RecyclerView hrv_color;
    private ArrayList<Integer> colorList;
    private ColorAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_item);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            getWindow().getAttributes().layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
        }

        ImageSlider slider = findViewById(R.id.imageSlider);
        List<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.dummy_img));
        imageList.add(new SlideModel(R.drawable.dummy_img));
        imageList.add(new SlideModel(R.drawable.dummy_img));

        slider.setImageList(imageList,true);

        //Strike through in case of discounted price
        TextView actualPrice = findViewById(R.id.itemActualPrice);
        actualPrice.setPaintFlags(actualPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        hrv_color = findViewById(R.id.selectedItemColour);
        colorList = new ArrayList<Integer>();
        colorList.addAll(Arrays.asList(MyData.colours));
        adapter=new ColorAdapter(colorList);
        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        hrv_color.setLayoutManager(horizontalLayoutManagaer);
        hrv_color.setAdapter(adapter);

    }
    int prevId = -1;
    public void openDashboard(View view){
        Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
        startActivity(intent);
    }

    public void onPressed(View view){
        if(prevId == -1){
            prevId = view.getId();
            view.setElevation(5f);
            view.setBackgroundResource(R.color.buybtn);
        }
        else if(prevId == view.getId()){
            return;
        }
        else {
            View temp = findViewById(prevId);
            temp.setElevation(0f);
            temp.setBackgroundResource(R.color.btndefault);

            view.setBackgroundResource(R.color.buybtn);
            view.setElevation(5f);
            prevId = view.getId();
        }
    }
}