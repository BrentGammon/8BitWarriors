import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends ExtendedActor
{
    public static final int MOVE_SPEED = 5;
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
            setRotation(270);
            move(MOVE_SPEED);
        }
    }    
    private void fall(){
        
    }
}
