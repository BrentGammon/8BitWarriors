import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Attack class will be used for when the player is attacking  
 * 
 * @author Brent Gammon 
 * @version (0.1)
 */
public abstract class Attack extends Entity
{
    private boolean direction;
    private ExtendedActor source;
    /**
     * Used for the direction of where the object will spawn agisnt the player
     */
    public Attack(boolean direction, ExtendedActor source){
        this.source = source;
        this.direction = direction;
    }
    public void setDirection(boolean direction){
        this.direction=direction;
    }
    public abstract void fire();

}
