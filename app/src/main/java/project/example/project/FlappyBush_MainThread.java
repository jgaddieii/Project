package project.example.project;

import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.SurfaceHolder;

public class FlappyBush_MainThread extends Thread{
    SurfaceHolder mySurfaceHolder;
    long timeSpent;
    long kickOffTime;
    long pause = 30;
    boolean Running;
    private static Canvas canvas;

    public FlappyBush_MainThread(SurfaceHolder surfaceHolder) {
        this.mySurfaceHolder = surfaceHolder;
        Running = true;
    }
    public boolean isRunning(){
        return  Running;
    }
    public void setIsRunning(boolean state){
        Running = state;
    }
    @Override
    public void run() {
        while (Running){
            kickOffTime = SystemClock.uptimeMillis();
            canvas = null;
            try{

               synchronized (mySurfaceHolder){
                   canvas = mySurfaceHolder.lockCanvas();
                   canvas.drawBitmap(FlappyBush_AppHolder.getBitmapControl().getBackground(),0,0,null);
                   FlappyBush_AppHolder.getGameManager().bushAnimation(canvas);
                   FlappyBush_AppHolder.getGameManager().movingCactus(canvas);
               }
            }catch (Exception ex){
                ex.printStackTrace();
            }
            finally {
                if (canvas != null){
                    try {
                        mySurfaceHolder.unlockCanvasAndPost(canvas);
                    }catch (Exception ex){
                        ex.printStackTrace();
                    }
                }
            }
            timeSpent = SystemClock.uptimeMillis() - kickOffTime;
            if (timeSpent < pause){
                try {
                    Thread.sleep(pause - timeSpent);
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
            }
        }
    }
}
