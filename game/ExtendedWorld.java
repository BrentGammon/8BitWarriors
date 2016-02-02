import greenfoot.*;
import java.awt.Point;
import java.util.List;
/**
 * Write a description of class ExtendedWorld here.
 * 
 * @author Mitchell 
 * @version Sprint1 0.1
 */
public class ExtendedWorld extends World
{
    protected int WORLD_HEIGHT =1000;
    protected int WORLD_WIDTH = 20000;
    public static final int GAME_HEIGHT = 400;
    public static final int GAME_WIDTH = 600;
    public static final int GAME_SPEED = 70;
    public static final int CAMERA_HORIZONAL_BUFFER = 100;
    public static final int CAMERA_VERTICAL_BUFFER = 100;
    
    protected GreenfootImage fullBackground;
    private ExtendedActor focus;
    private int cameraX = 0;
    private int cameraY = 0;
    /**
     * Constructor for objects of class ExtendedWorld.
     * 
     */
    public ExtendedWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(GAME_WIDTH, GAME_HEIGHT, 1,false); 
        fullBackground = getBackground();
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
    public void setFocus(ExtendedActor obj){
        focus = obj;
    }
    public int getWorldHeight(){
        return WORLD_HEIGHT;
    }
    public int getWorldWidth(){
        return WORLD_WIDTH;
    }
    public Point getCameraOrigin(){
        return new Point(cameraX,cameraY);
    }
    public int getCameraX(){
        return cameraX;
    }
    public int getCameraY(){
        return cameraY;
    }
    public void setCameraOrigin(Point p){
        cameraX = (int)p.getX();
        cameraY = (int)p.getY();
    }
    public void setCameraOrigin(int x, int y){
        cameraX = x;
        cameraY = y;
    }
    public void redrawBackground(){
        getBackground().drawImage(fullBackground,-cameraX, -cameraY);
    }

    public void transposeCamera(int x, int y){
        cameraX-=x;
        cameraY-=y;
        for (Object obj:getObjects(ExtendedActor.class)){
            System.out.println("transposing to"+ (((ExtendedActor)obj).getX()+x)+" "+(((ExtendedActor)obj).getY()+y) );
            ((ExtendedActor)obj).setLocation(((ExtendedActor)obj).getX()+x,((ExtendedActor)obj).getY()+y);
        }
        System.out.println(cameraX);
       redrawBackground();

    }
    public void centreCameraOn(ExtendedActor obj){
        
    }
}
