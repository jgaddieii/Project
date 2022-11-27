package project.example.project;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.project.R;

public class FlappyBush_BitmapControl {
    Bitmap flyingBush;
    Bitmap background;
    Bitmap topCactus;
    Bitmap bottomCactus;

    public FlappyBush_BitmapControl(Resources res) {
        background = BitmapFactory.decodeResource(res, R.drawable.background);
        flyingBush = BitmapFactory.decodeResource(res,R.drawable.tumbleweed);
        topCactus = BitmapFactory.decodeResource(res,R.drawable.cactus_top);
        bottomCactus = BitmapFactory.decodeResource(res,R.drawable.cactus_bottom);
    }


    public Bitmap getTopCactus(){
        return topCactus;
    }
    public Bitmap getBottomCactus(){
        return bottomCactus;
    }
    public int getTubeWidth(){
        return topCactus.getWidth();
    }
    public int getTubeHeight(){
        return topCactus.getHeight();
    }




    public Bitmap getBush(){
    return flyingBush;
}
    public int getBushWidth(){
        return flyingBush.getWidth();
    }
    public int getBushHeight(){
        return flyingBush.getHeight();
    }

    public Bitmap getBackground(){
        return background;
    }
}
