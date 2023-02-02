package com.example.movingbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    RelativeLayout myLayout;
    Button button;
    RelativeLayout.LayoutParams params;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            button = new Button(this);
            button.setText(R.string.click);
            button.setBackgroundColor(Color.YELLOW);

            params = new RelativeLayout.LayoutParams(500, 500);
            params.leftMargin = 10;
            params.topMargin = 100;

            myLayout = new RelativeLayout(this);
            myLayout.addView(button, params);

            setContentView(myLayout);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    moveButton(view);
                }
            });

        }

    private void moveButton(View view) {

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int window_height = displayMetrics.heightPixels;
        int window_width = displayMetrics.widthPixels;
        Log.d("moveButton", "displayMetrics:" + window_width +"x"+ window_height);

        Random random = new Random();
        int random_width = random.nextInt(window_width - 500);
        int random_height = random.nextInt(window_height - 1000);

        Log.d("moveButton", "random:" + random_width +":"+ random_height);
        params.leftMargin = random_width;
        params.topMargin = random_height;

        myLayout.updateViewLayout(view, params);
    }

    }
