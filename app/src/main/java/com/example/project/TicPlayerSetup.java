package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TicPlayerSetup extends AppCompatActivity {

    private EditText player1;
    private EditText player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_player_setup);

        player1 = findViewById(R.id.playerName1);
        player2 = findViewById(R.id.playerName2);
    }

    public void submitButtonClicked (View view){
        String playerName1 = player1.getText().toString();
        String playerName2 = player2.getText().toString();

        Intent intent = new Intent(this, TicActivity.class);
        intent.putExtra("player_names", new String[] {playerName1, playerName2});
        startActivity(intent);
    }
}