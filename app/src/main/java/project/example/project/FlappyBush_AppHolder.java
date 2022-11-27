package project.example.project;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class FlappyBush_AppHolder {
    static FlappyBush_BitmapControl bitmapControl;
    static FlappyBush_GameManager gameManager;
    static int scrnWidthX;
    static int scrnHeightY;
    static int gravityPull;
    static int jumpSpeed;
    static int cactusSpace;
    static int cactusCount;
    static int cactusSpeed;
    static int minCactusPickup_y;
    static int maxCactusPickup_y;
    static int cactusDistance;
    static Context gameActivityContext;


    public static void assign(Context context){
        mapScreenSize(context);
        bitmapControl = new FlappyBush_BitmapControl(context.getResources());
        holdGameVariables();
        gameManager = new FlappyBush_GameManager();
    }

    private static void mapScreenSize(Context context){
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display dsp = manager.getDefaultDisplay();
        DisplayMetrics dMetrics = new DisplayMetrics();
        dsp.getMetrics(dMetrics);
        int width = dMetrics.widthPixels;
        int height = dMetrics.heightPixels;
        FlappyBush_AppHolder.scrnWidthX = width;
        FlappyBush_AppHolder.scrnHeightY = height;
    }

    public static void holdGameVariables(){
        FlappyBush_AppHolder.gravityPull = 5;
        FlappyBush_AppHolder.jumpSpeed = -40;
        FlappyBush_AppHolder.cactusSpace = 650;
        FlappyBush_AppHolder.cactusCount = 2;
        FlappyBush_AppHolder.cactusSpeed = 24;
        FlappyBush_AppHolder.minCactusPickup_y = (int)(FlappyBush_AppHolder.cactusSpace / 2.0);
        FlappyBush_AppHolder.maxCactusPickup_y = FlappyBush_AppHolder.scrnHeightY - FlappyBush_AppHolder.minCactusPickup_y - FlappyBush_AppHolder.cactusSpace;
        FlappyBush_AppHolder.cactusDistance = FlappyBush_AppHolder.scrnWidthX *2/3;

    }

    public static FlappyBush_BitmapControl getBitmapControl(){
        return bitmapControl;
    }
    public static FlappyBush_GameManager getGameManager(){
        return  gameManager;
    }
}
