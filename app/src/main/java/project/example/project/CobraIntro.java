package project.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project.R;

public class CobraIntro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cobra_intro);
    }

    public void playButtonClicked(View view){
        Intent intent = new Intent(this, CobraActivity.class);
        startActivity(intent);
    }

    public void backButtonClicked(View view){
        Intent intent = new Intent(this, Selection.class);
        startActivity(intent);
    }
}