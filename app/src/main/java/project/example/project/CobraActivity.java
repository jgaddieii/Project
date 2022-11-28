package project.example.project;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.app.Activity;


public class CobraActivity extends Activity {
    CobraEngine cobraEngine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        cobraEngine = new CobraEngine(this, size);
        setContentView(cobraEngine);
    }

    @Override
    protected void onResume() {
        super.onResume();
        cobraEngine.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        cobraEngine.pause();
    }

}
