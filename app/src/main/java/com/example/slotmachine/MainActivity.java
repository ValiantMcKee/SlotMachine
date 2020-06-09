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

    public UpdateFirst updateOne;
    public UpdateSecond updateTwo;
    public UpdateThird updateThree;

    public int count;
    public int count2;
    public int count3;
    public int countPress;

    public Handler handler;
    public Handler handlerTwo;
    public Handler handlerThree;

    public boolean allOn;
    public boolean onOne;
    public boolean onTwo;
    public boolean onThree;


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
        handlerTwo = new Handler();
        handlerThree = new Handler();

        updateOne = new UpdateFirst();
        updateTwo = new UpdateSecond();
        updateThree = new UpdateThird();

        allOn = false;
        onOne = false;
        onTwo = false;
        onThree = false;

        count = 0;
        count2 = 0;
        count3 = 0;
        countPress = 0;

    }

    public void buttonPressed(View v){

        if(countPress == 0) {
            allOn = true;
            handler.post(updateOne);
            handlerTwo.post(updateTwo);
            handlerThree.post(updateThree);
            countPress ++;
        } else if(countPress == 1){
            handler.removeCallbacks(updateOne);
            countPress++;
        } else if(countPress == 2){
            handlerTwo.removeCallbacks(updateTwo);
            countPress++;
        } else if(countPress == 3){
            handlerThree.removeCallbacks(updateThree);
            countPress = 0;
            winCondition();
        }

    }


    private class UpdateFirst implements Runnable{

        public void run() {
            count = (count%3);
            if (count == 0) {
                firstSlot.setImageDrawable(apple);
            } else if (count == 1) {
                firstSlot.setImageDrawable(cherry);
            } else if (count == 2) {
                firstSlot.setImageDrawable(orange);

            }
            handler.postDelayed(updateOne, 200);

            count++;
        }
    }
    private class UpdateSecond implements Runnable{

        public void run() {
            count2 = (count2%3);
            if (count2 == 0) {
                secondSlot.setImageDrawable(apple);
            } else if (count2 == 1) {
                secondSlot.setImageDrawable(cherry);
            } else if (count2 == 2) {
                secondSlot.setImageDrawable(orange);

            }
            handlerTwo.postDelayed(updateTwo, 100);

            count2++;
        }
    }
    private class UpdateThird implements Runnable{

        public void run() {
            count3 = (count3%3);
            if (count3 == 0) {
                thirdSlot.setImageDrawable(apple);
            } else if (count3 == 1) {
                thirdSlot.setImageDrawable(cherry);
            } else if (count3 == 2) {
                thirdSlot.setImageDrawable(orange);

            }
            handlerThree.postDelayed(updateThree, 50);

            count3++;
        }
    }
    public void winCondition(){
        if((firstSlot.getDrawable().equals(secondSlot.getDrawable())) && (firstSlot.getDrawable().equals(thirdSlot.getDrawable()))){

        }
    }




}
