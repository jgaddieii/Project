package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SnakeIntro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snake_intro);
    }

    public void backButtonClicked(View view){
        Intent intent = new Intent(this, Selection.class);
        startActivity(intent);
    }
}