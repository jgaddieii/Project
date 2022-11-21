package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Selection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        Button snakeBtn = (Button) findViewById(R.id.go_to_snake);
        snakeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent snakeIntro = new Intent(Selection.this, SnakeIntro.class);
                startActivity(snakeIntro);
            }
        });

        Button ticBtn = (Button) findViewById(R.id.go_to_tic);
        ticBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ticIntro = new Intent(Selection.this, TicIntro.class);
                startActivity(ticIntro);
            }
        });
    }
}