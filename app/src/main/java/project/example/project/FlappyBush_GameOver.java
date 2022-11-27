package project.example.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project.R;

public class FlappyBush_GameOver extends AppCompatActivity {

    Button playAgainButton;
    Button homeButton;
    TextView gameScore,gameBest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flappy_bush_game_over);
        playAgainButton = findViewById(R.id.playagainbtn);
        int scoreCount = getIntent().getExtras().getInt("score");
        SharedPreferences pref = getSharedPreferences("myStoragePreference",0);
        int scoreBest = pref.getInt("scoreBest",0);
        SharedPreferences.Editor edit = pref.edit();
        if (scoreCount > scoreBest){
            scoreBest = scoreCount;
            edit.putInt("scoreBest",scoreBest);
            edit.apply();
        }
        gameScore = findViewById(R.id.scoreDisplay);
        gameBest = findViewById(R.id.BestScore);
        gameScore.setText("" + scoreCount);
        gameBest.setText("" + scoreBest);


//        playAgainButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent myIntent = new Intent(FlappyBush_GameOver.this,FlappyIntro.class);
//                startActivity(myIntent);
//            }
//        });
//        homeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent myIntent = new Intent(FlappyBush_GameOver.this,MainActivity.class);
//                startActivity(myIntent);
//            }
//        });
    }
    public void playAgain(View view){
        Intent intent = new Intent(this, FlappyIntro.class);
        finish();
        startActivity(intent);
    }
    public void homeButtonClicked(View view){
        Intent intent = new Intent(this, Selection.class);
        startActivity(intent);
    }
}