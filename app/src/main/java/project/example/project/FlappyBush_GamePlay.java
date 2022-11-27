package project.example.project;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class FlappyBush_GamePlay extends SurfaceView implements SurfaceHolder.Callback {
    FlappyBush_MainThread mainThread;
    public FlappyBush_GamePlay(Context context) {
        super(context);
        SurfaceHolder myHolder = getHolder();
        myHolder.addCallback(this);
        mainThread = new FlappyBush_MainThread(myHolder);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (FlappyBush_AppHolder.getGameManager().gameState ==0){
            FlappyBush_AppHolder.getGameManager().gameState = 1;
        }else {
            //nothing
        }
        FlappyBush_AppHolder.getGameManager().bush.setVelocity(FlappyBush_AppHolder.jumpSpeed);
        return  true;
    }
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mainThread.setIsRunning(true);
        mainThread.start();
    }
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

        boolean retry = true;
        while (retry){
            try {
                mainThread.setIsRunning(false);
                mainThread.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            retry = false;
        }
    }
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}

}
