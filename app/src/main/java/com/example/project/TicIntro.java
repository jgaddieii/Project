package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class TicIntro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_intro);
    }

    public void playButtonClicked(View view){
        Intent intent = new Intent(this, TicPlayerSetup.class);
        startActivity(intent);
    }
}