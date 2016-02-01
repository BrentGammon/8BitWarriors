import greenfoot.*;
import java.awt.Point;
/**
 * Write a description of class ExtendedWorld here.
 * 
 * @author Mitchell 
 * @version Sprint1 0.1
 */
public class ExtendedWorld extends World
{
    public static int WORLD_HEIGHT;
    public static int WORLD_WIDTH;
    public static final int GAME_HEIGHT = 400;
    public static final int GAME_WIDTH = 600;
    public static final int GAME_SPEED = 50;
    private int cameraX = 0;
    private int cameraY = 0;
    /**
     * Constructor for objects of class ExtendedWorld.
     * 
     */
    public ExtendedWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(GAME_WIDTH, GAME_HEIGHT, 1); 
        WORLD_HEIGHT = getWorldHeight();
        WORLD_WIDTH = getWorldWidth();
    }
    /**
     * Called Every tick of the world BEFORE any objects are so per tick
     * operations can be performed here
     */
    public void act(){
        //set game speed every tick so it cant be changed by the slider
        Greenfoot.setSpeed(GAME_SPEED);
    }
    public int getWorldHeight(){
        return 1000;
    }
    public int getWorldWidth(){
        return 20000;
    }
    public Point getCameraOrigin(){
        return new Point(cameraX,cameraY);
    }
    public void setCameraOrigin(Point p){
        cameraX = (int)p.getX();
        cameraY = (int)p.getY();
    }
    public void setCameraOrigin(int x, int y){
        cameraX = x;
        cameraY = y;
    }
    public void transposeCamera(Integer x, Integer y){
        if (x!=null) cameraX+=x;
        if (y!=null) cameraY+=y;
    }
    public void centreCameraOn(ExtendedActor obj){
        
    }
}
