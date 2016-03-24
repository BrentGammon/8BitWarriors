 

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Attack is the super class for all attacking objects 
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
	/**
	*abstract method fire wil be implemented by sub classes
	*/
    public abstract void fire();

}
