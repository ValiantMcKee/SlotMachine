package com.example.slotmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public LinearLayout line;
    public Drawable cherry;
    public Drawable apple;
    public Drawable orange;
    public ImageView[] imageViews;
    //public UpdateCount update;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        line = findViewById(R.id.linearLayout);
        cherry = getDrawable(R.drawable.cherry);
        apple = getDrawable(R.drawable.unnamed);
        orange = getDrawable(R.drawable.orange);
        imageViews = new ImageView[3];



        for(int i =0;i<3;i++){
            imageViews[i] = (ImageView) getLayoutInflater().inflate(R.layout.fruit_view,  null);
            imageViews[i].setMinimumHeight(270);
            imageViews[i].setMinimumWidth(270);

            line.addView(imageViews[i]);
        }
        imageViews[0].setImageDrawable(cherry);
        imageViews[1].setImageDrawable(orange);
        imageViews[2].setImageDrawable(apple);

    }
}
