package com.example.snakeforproject;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.app.Activity;


public class SnakeActivity extends Activity {
    SnakeEngine snakeEngine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        snakeEngine = new SnakeEngine(this, size);
        setContentView(snakeEngine);
    }
    @Override
    protected void onResume() {
        super.onResume();
        snakeEngine.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        snakeEngine.pause();
    }

}

