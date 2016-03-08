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
