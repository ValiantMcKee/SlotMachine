package com.example.slotmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public LinearLayout line;
    public Drawable cherry;
    public Drawable apple;
    public Drawable orange;
    public ImageView[] imageViews;
    public ImageView firstSlot;
    public ImageView secondSlot;
    public ImageView thirdSlot;
    public UpdateFruit update;
    public int count;
    public Handler handler;
    public boolean on;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstSlot = findViewById(R.id.firstSlot);
        secondSlot = findViewById(R.id.secondSlot);
        thirdSlot = findViewById(R.id.thirdSlot);

        line = findViewById(R.id.linearLayout);

        cherry = getDrawable(R.drawable.cherry);
        apple = getDrawable(R.drawable.unnamed);
        orange = getDrawable(R.drawable.orange);

        imageViews = new ImageView[3];

        handler = new Handler();
        update = new UpdateFruit();

        on = false;

        count = 0;

    }

    public void buttonPressed(View v){

        if (on) {
            on = false;
            handler.removeCallbacks(update);
        } else {
            on = true;
            handler.postDelayed(update, 1000);
        }

    }

        private class UpdateFruit implements Runnable {

            public void run() {
                count = (count%3);
                if (count == 0) {
                    firstSlot.setImageDrawable(apple);
                } else if (count == 1) {
                    firstSlot.setImageDrawable(cherry);
                } else if (count == 2) {
                    firstSlot.setImageDrawable(orange);

                }
                handler.postDelayed(update, 1000);

                count++;
            }
        }




}
