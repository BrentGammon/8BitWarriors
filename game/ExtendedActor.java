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
    private boolean locationSet=false;
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
            int dx = 0;
            int dy = 0;
            boolean doMove = false;
            boolean doCameraMove = false;
            if (locationSet){
                //System.out.println("moved:"+x+y);
                              
                World world = getWorld();
                ExtendedWorld eworld = (ExtendedWorld)world;
                if (hasFocus && world instanceof ExtendedWorld){
                    
                    
                    //check if the new location will result in actor position outside of buffer
                    
                    //if actor is within left buffer area and camera isnt at the left wall
                    if ( eworld.CAMERA_HORIZONAL_BUFFER > x && eworld.getCameraX()>0){
                        //we are moving the camera
                        doCameraMove = true;
                        
                        //keep character still
                        newx = getX();
                        //set vertical panning disntance the same as movement distance.
                        dx = newx-x;
                        //if actor is within right buffer area and camera isnt at the right wall
                    }else if(eworld.GAME_WIDTH-eworld.CAMERA_HORIZONAL_BUFFER<x && eworld.getCameraX()+eworld.GAME_WIDTH<eworld.getWorldWidth()){
                        //we are moving the camera
                        doCameraMove = true;
                        //keep character still
                        newx = getX();
                        //set vertical panning disntance the same as movement distance.
                        dx = newx-x;
                    }else{
                        //we are moving the character
                        doMove = true;
                        ignoreNextMove = true;
                    }
                    
                    if ( eworld.CAMERA_VERTICAL_BUFFER > y && eworld.getCameraY()>0){
                        //we are moving the camera
                        doCameraMove = true;
                        
                        //keep character still
                        newy = getY();
                        //set vertical panning disntance the same as movement distance.
                        dy = newy-y;
                        //if actor is within right buffer area and camera isnt at the right wall
                    }else if(eworld.GAME_HEIGHT-eworld.CAMERA_VERTICAL_BUFFER<y && eworld.getCameraY()+eworld.GAME_HEIGHT<eworld.getWorldHeight()){
                        //we are moving the camera
                        doCameraMove = true;
                        //keep character still
                        newy = getY();
                        //set vertical panning disntance the same as movement distance.
                        dy = newy-y;
                    }else{
                        //we are moving the character
                        doMove = true;
                        ignoreNextMove = true;
                    }
                    
                }else{
                    doMove = true;
                }
                if(doMove)super.setLocation(newx,newy);
                if(doCameraMove)eworld.transposeCamera(dx,dy);
            }else{
                locationSet = true;
                worldX = x;
                worldY = y;
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
