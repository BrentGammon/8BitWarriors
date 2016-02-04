import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Entity
{
    public static final int MOVE_SPEED = 5;
    public static final int JUMP_SPEED = -30;
    public static final int GRAVITY = 2;
    
    private int vertVelocity = 0;
    
    Player(){
        setFocus(true);
    }
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.isKeyDown("LEFT")){
            setRotation(180);
            move(MOVE_SPEED);
        }else if(Greenfoot.isKeyDown("RIGHT")){
            setRotation(0);
            move(MOVE_SPEED);
        }else if(Greenfoot.isKeyDown("DOWN")){
            setRotation(90);
            move(MOVE_SPEED);
        }else if(Greenfoot.isKeyDown("UP")){
            if(onPlatform()){
                System.out.println("Jump");
                moveLocation(0,-1);
                vertVelocity = JUMP_SPEED;
            }
        }
        fall();
    }    
    public void fall(){
        if (!onPlatform()){
            vertVelocity+=GRAVITY;
            if(vertVelocity>0){
                
                for(int i=0;i<vertVelocity;i++){
                    moveLocation(0,1);
                    if (!getIntersectingObjects(Terrain.class).isEmpty()){
                        moveLocation(0,-1);
                        vertVelocity = 0;
                    }
                }
            } else if(vertVelocity<0){
                
                for(int i=0;i>vertVelocity;i--){
                    moveLocation(0,-1);
                    if (!getIntersectingObjects(Terrain.class).isEmpty()){
                        moveLocation(0,1);
                        vertVelocity = 0;
                    }
                }
            }
        }else{
            vertVelocity = 0;
        }
    }
}
