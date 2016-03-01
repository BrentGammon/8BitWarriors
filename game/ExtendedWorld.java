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
    protected int WORLD_END = WORLD_HEIGHT;
    protected int WORLD_WIDTH = 20000;
    protected int GRAVITY = 2;
    public static final int GAME_HEIGHT = 600;
    public static final int GAME_WIDTH = 800;
    public static final int GAME_SPEED = 45;
    public static final int CAMERA_HORIZONAL_BUFFER = 300;
    public static final int CAMERA_VERTICAL_BUFFER = 150;

    protected int timeLimit = 99999;
    
    protected GreenfootImage layer1;
    protected int layer1_xoffset = 0;
    protected int layer1_yoffset = 0;
    protected boolean layer1_ytile = true;
    protected GreenfootImage layer2;
    protected int layer2_xoffset = 0;
    protected int layer2_yoffset= 0;
    protected boolean layer2_ytile = true;
    protected GreenfootImage layer3;
    protected int layer3_xoffset = 0;
    protected int layer3_yoffset = 0;
    protected boolean layer3_ytile = true;
    protected GreenfootImage layer4;
    protected int layer4_xoffset = 0;
    protected int layer4_yoffset = 0;
    protected boolean layer4_ytile = true;

    private ExtendedActor focus;
    private int cameraX = 0;
    private int cameraY = 0;

    private boolean useCamera;
    
    ///////////used for saving
    protected String gameLevel;
    /**
     * Constructor for objects of class ExtendedWorld.
     * 
     */
    public ExtendedWorld(boolean useCamera)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(GAME_WIDTH, GAME_HEIGHT, 1,false); 
        WORLD_HEIGHT = getWorldHeight();
        WORLD_WIDTH = getWorldWidth();

        this.useCamera = useCamera;
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
        if(useCamera){
            centreCameraOn(focus);
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
        GreenfootImage bg = getBackground();
        bg.fill();
        if (layer1!=null){
            if(layer1_ytile){
                int y = layer1_yoffset;
                int x = layer1_xoffset;
                for (int i = x;i<GAME_WIDTH;i+=layer1.getWidth()){
                    bg.drawImage(layer1,i,y);
                }
                
            }else{
                bg.drawImage(layer1,0,0);
            }
            
        }
        if (layer2!=null){
            if(layer2_ytile){
                int y = layer2_yoffset -cameraY/3;
                int x = layer2_xoffset -cameraX/3;
                for (int i = x;i<GAME_WIDTH;i+=layer2.getWidth()){
                    bg.drawImage(layer2,i,y);
                }
                
            }else{
                bg.drawImage(layer2,-cameraX/3, -cameraY/3);
            }
        }
        if (layer3!=null){
            if(layer3_ytile){
                int y = layer3_yoffset -cameraY/2;
                int x = layer3_xoffset -cameraX/2;
                for (int i = x;i<GAME_WIDTH;i+=layer3.getWidth()){
                    bg.drawImage(layer3,i,y);
                }
                
            }else{
                bg.drawImage(layer3,-cameraX/3, -cameraY/3);
            }
        }
        if (layer4!=null){
            if(layer4_ytile){
                int y = layer4_yoffset -cameraY;
                int x = layer4_xoffset -cameraX;
                for (int i = x;i<GAME_WIDTH;i+=layer4.getWidth()){
                    bg.drawImage(layer4,i,y);
                }
                
            }else{
                bg.drawImage(layer4,-cameraX, -cameraY);
            }
        }

    }

    public void transposeCamera(int x, int y){
        int dx = cameraX-x<0?cameraX:x;
        int dy = cameraY-y<0?cameraY:y;
        cameraX-=dx;
        cameraY-=dy;
        if(dy!=0||dx!=0) for(Object obj:getObjects(ExtendedActor.class)){
            ((ExtendedActor)obj).setLocation(((ExtendedActor)obj).getX()+dx,((ExtendedActor)obj).getY()+dy);
        }
        
        redrawBackground();

    }

    public void centreCameraOn(ExtendedActor obj){
        int x = obj.getX();
        int y = obj.getY();
        int cx = GAME_WIDTH/2;
        int cy = GAME_HEIGHT/2;
        transposeCamera(cx-x, cy-y);


    }

     /**
     * THis method when invoked will 
     * @return String 
     */
    protected String getLevel()
    {
        return gameLevel;
    }
    
   
    //public String getLevel()
    //{
        
    //}
}
