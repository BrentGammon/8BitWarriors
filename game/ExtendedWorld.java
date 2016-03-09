import greenfoot.*;
import java.awt.Point;
import java.awt.Color;
import java.util.List;
/**
 * This class is the base class for any world that needs to scroll. It extends the base World class in several
 * ways  and enables extended functionality to ExtendedActors. 
 * 
 * @author Mitchell 
 * @version Sprint2 0.2
 */
public class ExtendedWorld extends World
{
    /** Dimentions of the world. Only serves to bind the world within the camera and paint the backround */
    protected static int WORLD_HEIGHT = 900;
    protected static int WORLD_END = WORLD_HEIGHT;
    protected static int WORLD_WIDTH = 20000;
    
    /** The gravity applied to every IFalling actor */
    protected int GRAVITY = 2;
    
    /** Dimensions of the screen */
    protected static  int GAME_HEIGHT = 600;
    protected static  int GAME_WIDTH = 800;
    
    /** The speed to lock the world at */
    public static final int GAME_SPEED = 45;

    /** The time at which the game will kill the player */
    protected int timeLimit = 99999;
    
    /** 
     * Used to store the background images each image scrolls at a different rate in relation to the camera
     * with layer 1 completely static and layer 2 moving realtime.
     * layerx_offsets decide the offset at which to paint the background
     * layerx_ytile decides whether or not to tile the background horizontally
    */
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

    /** The Actor to center the camera on */
    private ExtendedActor focus;
    
    /** The current top left position of the camera */
    private int cameraX = 0;
    private int cameraY = 0;
    
    /** Toggle the camera on or off */
    private boolean useCamera;
    
    /** Used to pause the game */
    private boolean paused = false;
    
    //debug stuff
    public boolean drawGrid = false;
    public int gridx = 50;
    public int gridy = 50;
    
    /** a unique idenifier that is used in the save file to represent the world.*/
    protected String gameLevel;
    
    private static boolean stillAlive;
    /**
     * Constructor for objects of class ExtendedWorld.
     */
    public ExtendedWorld(boolean useCamera)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(GAME_WIDTH, GAME_HEIGHT, 1,false); 
        WORLD_HEIGHT = getWorldHeight();
        WORLD_WIDTH = getWorldWidth();

        this.useCamera = useCamera;
        setPaintOrder();
    }
    
    /**
     * Constructor for objects of class ExtendedWorld.
     */
    public ExtendedWorld(int menuHeight,int menuLength,boolean useCamera)
    {    
        super(menuHeight, menuLength, 1,false); 
    }

    /**
     * Called Every tick of the world BEFORE any objects are so per tick
     * operations can be performed here
     */
    public void act(){
        //set game speed every tick so it cant be changed by the slider
        //Greenfoot.setSpeed(GAME_SPEED);
        if (paused) return;
        //do gravity
        List<IFalling> actors = getObjects(IFalling.class);
        for(IFalling actor:actors){
            actor.fall(GRAVITY);
        }
        if(useCamera && focus!=null){
            centreCameraOn(focus);
        }
        redrawBackground();
    }
    
    /** Sets the focus of the world
     * 
     * @param obj ExtendedActor to focus on
    */
    public void setFocus(ExtendedActor obj){
        focus = obj;
    }

    /** Get the height of the world
     * 
     * @return World Height
    */
    public int getWorldHeight(){
        return WORLD_HEIGHT;
    }

    /** Get the width of the world
     * 
     * @return World width
    */
    public int getWorldWidth(){
        return WORLD_WIDTH;
    }
    
    /** Get the current camera X point of the world
     * 
     * @return Camera X position
    */
    public int getCameraX(){
        return cameraX;
    }

    /** Get the current camera Y point of the world
     * 
     * @return Camera Y position
    */
    public int getCameraY(){
        return cameraY;
    }
    
    /**Set the Camera position
     * 
     * @param x Desired X coordinates for the camera
     * @param y Desired Y coordinates for the camera
    */
    public void setCamera(int x, int y){
        //move the camera by the difference between the current position and the desired location
        transposeCamera(cameraX-x,cameraY-y);
    }
    
    /** Composite the background images onto the world background
    */
    public void redrawBackground(){
        //fetch background
        GreenfootImage bg = getBackground();
        //set draw color to white then clear the background
        bg.setColor(Color.WHITE);
        bg.fill();
        
        //if layer1 is set
        if (layer1!=null){
            //if layer1 tiles
            if(layer1_ytile){
                int y = layer1_yoffset;
                int x = layer1_xoffset;
                //tile background till draw origin is off screen
                for (int i = x;i<GAME_WIDTH;i+=layer1.getWidth()){
                    bg.drawImage(layer1,i,y);
                }
                
            }else{
                //draw background image onto world background
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
        
        if (drawGrid){
            bg.setColor(Color.WHITE);
            for ( int x = gridx-cameraX%gridx; x<GAME_WIDTH && x+cameraX<WORLD_WIDTH; x+=gridx ){
                bg.drawLine(x,0,x,GAME_HEIGHT);
            }
            
            for ( int y = gridy-cameraY%gridy; y<GAME_HEIGHT && y+cameraY<WORLD_HEIGHT; y+=gridy ){
                bg.drawLine(0,y,GAME_WIDTH,y);
            }
        }
        
        bg.setColor(Color.RED);
        bg.drawString("cam x: "+cameraX+" y:"+cameraY,20,20);
        if (paused) bg.drawString("PAUSED",200,200);
      
    }

    /**
     *  Move the camera along by the given x and across by the given y.
     *  
     *  @param x horizonal distance to move the camera positive is left
     *  @param y vertical distance io move the camera positive is up
    */
    public void transposeCamera(int x, int y){
        // if camera would have ended negative set distance to move the amount so camera reaches 0
        int dx = cameraX-x<0?cameraX:x;
        //if camera would have ended off the right of the world set distance to move the amount so camera
        //reaches world size
        dx = cameraX-dx> WORLD_WIDTH-GAME_WIDTH? -((WORLD_WIDTH-GAME_WIDTH) - cameraX):dx;
        
        //same as x
        int dy = cameraY-y<0?cameraY:y;
        dy = cameraY-dy> WORLD_HEIGHT-GAME_HEIGHT? -((WORLD_HEIGHT-GAME_HEIGHT) - cameraY):dy;
        
        //update camera values
        cameraX-=dx;
        cameraY-=dy;
        
        //if the camera is moving in some direction move every object by camera amount
        if(dy!=0||dx!=0) for(Object obj:getObjects(ExtendedActor.class)){
            ((ExtendedActor)obj).setLocation(((ExtendedActor)obj).getX()+dx,((ExtendedActor)obj).getY()+dy);
        }
        
        //redraw background
        redrawBackground();

    }

    /**
     * Moves the camera so that the object is at the center of focus.
     * 
     * @param obj ExtendedActor to focus on
    */
    public void centreCameraOn(ExtendedActor obj){
        // get objects positions
        int x = obj.getX();
        int y = obj.getY();
        
        //calculate center of screen
        int cx = GAME_WIDTH/2;
        int cy = GAME_HEIGHT/2;
        
        //move the actor
        transposeCamera(cx-x, cy-y);

    }

    /**
     * This method when invoked will return the identifier for the level
     * @return String The current level identifier
     */
    protected String getLevel()
    {
        return gameLevel;
    }
    
    /**
     * Set Order at which to paint objects in the world.
    */
    public void setPaintOrder(){
        // draw order is left is top. anything not mentioned is drawn under.
        super.setPaintOrder(UI.class,Attack.class,Player.class,Entity.class);
    }
    
    /**
     * Is the world currenly paused or not.
     * 
     * @return is the world paused
    */
    public boolean isPaused(){
        return paused;
    }

}
