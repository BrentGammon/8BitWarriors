package game;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This objects is able to be pushed by the player when in the world.
 * 
 * @author Brent & Sharaz
 * @version v0.1
 */
public class PushObject extends Moveable implements IFalling
{
    /**
     * The act method will check if its falling and if its being pushed as these are the two states
     */
    public void act() 
    {
        isPushed();
        if (collideMoveLocation(0,vertVelocity)&&onPlatform()){
            vertVelocity = 0;
        }
    }    
}
