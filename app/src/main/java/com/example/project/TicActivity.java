package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TicActivity extends AppCompatActivity {

    private TicBoard ticBoard;
    private Button playAgainBtn;
    private Button homeBtn;
    private TextView playerDisplay;
    private String[] playerNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic);

        playAgainBtn = findViewById(R.id.play_again);

        homeBtn = findViewById(R.id.home_btn);

        playerDisplay = findViewById(R.id.player_display);

        playAgainBtn.setVisibility(View.GONE);
        homeBtn.setVisibility(View.GONE);

        ticBoard = findViewById(R.id.ticBoard);

        playerNames = getIntent().getStringArrayExtra("player_names");

        if (playerNames != null) {
            playerDisplay.setText((playerNames[0] + "'s Turn!"));
        }

        ticBoard.setUpGame(playAgainBtn, homeBtn, playerDisplay, playerNames);
    }

    public void playAgainButtonClicked(View view){
        ticBoard.playAgain();
        ticBoard.invalidate();
    }

    public void homeButtonClicked(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}