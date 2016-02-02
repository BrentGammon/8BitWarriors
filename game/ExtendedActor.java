import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ExtendedActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExtendedActor extends Actor
{
    /**
     * Act - do whatever the ExtendedActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int worldX=-10000;
    private int worldY=-10000;
    private boolean hasFocus=false;
    private boolean ignoreNextMove = false;
    public void act() 
    {
    }
    public void addedToWorld(World world){
        super.addedToWorld(world);
    }
    public boolean isFocus(){
        return hasFocus;
    }
    public void setFocus(){
        World world = getWorld();
        if (world instanceof ExtendedWorld){
            ExtendedWorld eworld = (ExtendedWorld)world;
            eworld.setFocus(this);
        }
    }
    public void setFocus(boolean focus){
        hasFocus = focus;
    }
    public void setLocation(int x,int y){
        if (!ignoreNextMove){
            int newx = x;
            int newy = y;
            if (worldX==-10000){
               // System.out.println("Location Set:"+x+y);
                worldX = x;
                worldY = y;
            }else{
                //System.out.println("moved:"+x+y);
                              
                World world = getWorld();
                if (hasFocus && world instanceof ExtendedWorld){
                    
                    int dx = 0;
                    int dy = 0;
                    //check if the new location will result in actor position outside of buffer
                    ExtendedWorld eworld = (ExtendedWorld)world;
                    if ( eworld.CAMERA_HORIZONAL_BUFFER > x && eworld.getCameraX()>0){
                        dx = getX()-x;
                    }else if(eworld.GAME_WIDTH-eworld.CAMERA_HORIZONAL_BUFFER<x && eworld.getCameraX()+eworld.GAME_WIDTH<eworld.WORLD_WIDTH){
                        dx = getX()-x;
                    }else{
                        ignoreNextMove = true;
                        super.setLocation(x,y);
                    }
                    eworld.transposeCamera(dx,dy);
                }else{
                    super.setLocation(x,y);
                }
            }
        }else{
            ignoreNextMove = false;
            //System.out.println("ignored");
        }
    }
    public void move(int x){
        super.move(x);
    }
}
