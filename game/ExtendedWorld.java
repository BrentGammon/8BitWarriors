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
    protected int WORLD_HEIGHT = 1000;
    protected int WORLD_WIDTH = 20000;
    protected int GRAVITY = 2;
    public static final int GAME_HEIGHT = 600;
    public static final int GAME_WIDTH = 800;
    public static final int GAME_SPEED = 50;
    public static final int CAMERA_HORIZONAL_BUFFER = 300;
    public static final int CAMERA_VERTICAL_BUFFER = 150;
    
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
        
        //do gravity
        List<IFalling> actors = getObjects(IFalling.class);
        for(IFalling actor:actors){
            actor.fall(GRAVITY);
        }
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
        getBackground().fill();
        getBackground().drawImage(fullBackground,-cameraX, -cameraY);
    }
    public void transposeCamera(int x, int y){
        cameraX-=x;
        cameraY-=y;
        for (Object obj:getObjects(ExtendedActor.class)){
            if(!((ExtendedActor)obj).isFocus())((ExtendedActor)obj).setLocation(((ExtendedActor)obj).getX()+x,((ExtendedActor)obj).getY()+y);
        }
       redrawBackground();

    }
    public void centreCameraOn(ExtendedActor obj){
        int x = obj.getX();
        int y = obj.getY();
        int cx = GAME_WIDTH/2;
        int cy = GAME_HEIGHT/2;
        transposeCamera(cx-x, cy-y);
        System.out.println(" "+obj.isFocus()+cx+cy);
        if(obj.isFocus()) obj.setWindowLocation(cx,cy);
        
    }
}
