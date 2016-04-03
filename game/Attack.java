 

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
	*Contructor for Attack
	*@param boolean direction the value of the driction of the object
	*@param ExtendedActor source the actor that spawned this object
	*/
    public Attack(boolean direction, ExtendedActor source){
        this.source = source;
        this.direction = direction;
    }
	
	/**
	*returns the object that created this object
	*@return ExtendedActor source the actor that spawned this object
	*/
    public ExtendedActor getSource(){
        return source;
    }
	
	/**
	*Sets the value of the instance variable direction
	*@param boolean direction the value to stored
	*
	*/
    public void setDirection(boolean direction){
        this.direction=direction;
    }
	
	/**
	* returns the value of the instance variable direction
	*@return boolean direction returns the value of direction 
	*
	*/
    public boolean getDirection(){
        return direction;
    }
	/**
	*abstract method fire wil be implemented by sub classes
	*/
    public abstract void fire();

}
