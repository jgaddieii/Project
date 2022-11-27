package project.example.project;

import java.util.Random;

public class FlappyBush_CactusPickup {
    private int xTube; // this will hold the X coordinate
    private int upTubeCollection_Y;
    private Random rand;
    private int colorTube;
    public FlappyBush_CactusPickup(int xTube, int upTubeCollection_Y){
        this.xTube = xTube;
        this.upTubeCollection_Y = upTubeCollection_Y;
        rand = new Random();
    }


    public void setColorTube(){
        colorTube = rand.nextInt(2);
    }
    public int getColorTube(){
        return colorTube;
    }

    public int getUpTubeCollection_Y(){
        return upTubeCollection_Y;
    }
    public int getXtube(){
        return xTube;
    }
    public int getUpTube_Y(){
        return upTubeCollection_Y - FlappyBush_AppHolder.getBitmapControl().getTubeHeight();
    }
    public int getDownTube_Y(){
        return upTubeCollection_Y + FlappyBush_AppHolder.cactusSpace;
    }
    public void setXtube(int x_Tube){
        this.xTube = x_Tube;
    }
    public void setUpTubeCollection_Y(int upTubeCollection_Y){
        this.upTubeCollection_Y = upTubeCollection_Y;
    }
}
