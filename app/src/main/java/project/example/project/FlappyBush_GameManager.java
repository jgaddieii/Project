package project.example.project;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.Random;

public class FlappyBush_GameManager {
    FlappyBush_FlyingBush bush;
    static int gameState;
    ArrayList<FlappyBush_CactusPickup> cactusPickup;
    Random random;
    int score; //stores the score of current game
    int finalCactus; //the cactus you die on to calculate the final score
    Paint designPaint;

    public FlappyBush_GameManager() {
        bush = new FlappyBush_FlyingBush();
        gameState = 0;
        cactusPickup = new ArrayList<>();
        random = new Random();
        makeNewCactus();
        initScoreVariables();
    }
      public void makeNewCactus(){
          for (int j = 0; j< FlappyBush_AppHolder.cactusCount; j++){
              int tubeX = FlappyBush_AppHolder.scrnWidthX + j* FlappyBush_AppHolder.cactusDistance;
              int upTubeCollectionY = FlappyBush_AppHolder.minCactusPickup_y;
              random.nextInt(FlappyBush_AppHolder.maxCactusPickup_y - FlappyBush_AppHolder.minCactusPickup_y + 1);
              FlappyBush_CactusPickup tubeCollection = new FlappyBush_CactusPickup(tubeX,upTubeCollectionY);
              cactusPickup.add(tubeCollection);
          }
      }
//method to show the cactus' moving on the screen
      public void movingCactus(Canvas can){
          if (gameState == 1){

              if ((cactusPickup.get(finalCactus).getXtube() < bush.getX() + FlappyBush_AppHolder.getBitmapControl().getBushWidth())
              &&(cactusPickup.get(finalCactus).getUpTubeCollection_Y() > bush.getY()
                      || cactusPickup.get(finalCactus).getDownTube_Y() < (bush.getY() +
                      FlappyBush_AppHolder.getBitmapControl().getBushHeight()))){
                  gameState = 2;
                  Context mContext = FlappyBush_AppHolder.gameActivityContext;
                  Intent mIntent = new Intent(mContext, FlappyBush_GameOver.class);
                  mIntent.putExtra("score", score);
                  mContext.startActivity(mIntent);
                  ((Activity)mContext).finish();
              }

              if (cactusPickup.get(finalCactus).getXtube() < bush.getX() - FlappyBush_AppHolder.getBitmapControl().getTubeWidth()){
                  score++;
                  finalCactus++;
                  if (finalCactus > FlappyBush_AppHolder.cactusCount - 1){
                      finalCactus = 0;
                  }
              }
              for (int j = 0; j< FlappyBush_AppHolder.cactusCount; j++){
                  if (cactusPickup.get(j).getXtube()<-FlappyBush_AppHolder.getBitmapControl().getTubeWidth()){
                      cactusPickup.get(j).setXtube(cactusPickup.get(j).getXtube()
                              + FlappyBush_AppHolder.cactusCount * FlappyBush_AppHolder.cactusDistance);
                      int upTubeCollectionY = FlappyBush_AppHolder.minCactusPickup_y +
                              random.nextInt(FlappyBush_AppHolder.maxCactusPickup_y - FlappyBush_AppHolder.minCactusPickup_y +1);
                      cactusPickup.get(j).setUpTubeCollection_Y(upTubeCollectionY);
                      cactusPickup.get(j).setColorTube();
                  }
                 cactusPickup.get(j).setXtube(cactusPickup.get(j).getXtube() - FlappyBush_AppHolder.cactusSpeed);
                  can.drawBitmap(FlappyBush_AppHolder.getBitmapControl().getTopCactus(), cactusPickup.get(j).getXtube(), cactusPickup.get(j).getUpTube_Y(),null);
                  can.drawBitmap(FlappyBush_AppHolder.getBitmapControl().getBottomCactus(), cactusPickup.get(j).getXtube(), cactusPickup.get(j).getDownTube_Y(),null);
              }
              can.drawText("" + score, 620,400, designPaint);
          }
      }
      //shows the bush moving up and down
      public void bushAnimation(Canvas canvas){
          if (gameState == 1){
              if (bush.getY() <(FlappyBush_AppHolder.scrnHeightY - FlappyBush_AppHolder.getBitmapControl().getBushHeight()) || bush.getVelocity()<0 ){
                  bush.setVelocity(bush.getVelocity() + FlappyBush_AppHolder.gravityPull );
                  bush.setY(bush.getY() + bush.getVelocity() );
              }
          }
          canvas.drawBitmap(FlappyBush_AppHolder.getBitmapControl().getBush(), bush.getX(), bush.getY(),null);
    }
    //score variables for scoring
    public void initScoreVariables(){
        score = 0;
        finalCactus = 0;
        designPaint = new Paint();
        designPaint.setColor(Color.YELLOW);
        designPaint.setTextSize(250);
        designPaint.setStyle(Paint.Style.FILL);
        designPaint.setFakeBoldText(true);
        designPaint.setShadowLayer(5.0f, 20.0f,20.0f, Color.BLACK);
    }
}
