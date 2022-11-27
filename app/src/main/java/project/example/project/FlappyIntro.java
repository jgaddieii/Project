package project.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.project.R;

public class FlappyIntro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flappy_intro);
        FlappyBush_AppHolder.assign(this.getApplicationContext());
    }

    public void backButtonClicked(View view){
        Intent intent = new Intent(this, Selection.class);
        startActivity(intent);
    }

    public void startGame(View view){
        Intent intent = new Intent(this, FlappyBush_GameActivity.class);
        finish();
        startActivity(intent);
    }
}