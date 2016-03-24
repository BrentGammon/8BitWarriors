package game;

import greenfoot.*;

/**
 * This is used to allow the player to set the key binding for right
 * 
 * @author Brent Gammon 
 * @version v0.1
 */
public class RightControl extends MenuItems
{
    /**
     * Act - do whatever the RightControl wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * When the object has been clicked it will ask the player to input a string value this value will be stored as a keybinding for right movement
     */
    public void act() 
    {
       if(Greenfoot.mouseClicked(this))
       {
          String x= Greenfoot.ask("Right Key");
          Player.keyRight = x;
       }
    }    
}
