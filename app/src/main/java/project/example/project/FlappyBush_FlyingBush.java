package project.example.project;

public class FlappyBush_FlyingBush {
    private int birdX;
    private int birdY;
    private int velocity;
    public static int maximumFrame;
    public FlappyBush_FlyingBush() {
        birdX = FlappyBush_AppHolder.scrnWidthX /2 - FlappyBush_AppHolder.getBitmapControl().getBushWidth()/2;
        birdY = FlappyBush_AppHolder.scrnHeightY /2 - FlappyBush_AppHolder.getBitmapControl().getBushHeight()/2;
        maximumFrame = 2;
    }

    public int getX(){
        return birdX;
    }
    public int getY(){
        return birdY;
    }
    public void setX(int birdX){
        this.birdX = birdX;
    }
    public void setY(int birdY){
        this.birdY = birdY;
    }
    public int getVelocity(){
        return velocity;
    }
    public void setVelocity(int velocity){
        this.velocity = velocity;
    }
}
