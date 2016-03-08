import greenfoot.*;
//mport javax.swing.*;
/**
 * This is used to allow the player to set the key binding for jump UPControl here.
 * 
 * @author Brent Gammon
 * @version v0.1
 */
public class UPControl extends MenuItems
{
    /**
     *The act method will check if the object has been clicked by the mouse 
	 *Stores the answer from the ask to store the value to keybinding
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
       {
          String x= Greenfoot.ask("Jump Key");
          Player.keyJump = x;
       }
    }    
}
