import greenfoot.*;

/**
 * Super class for the menu elements used for ordering the subclasses
 * 
 * @author Brent Gammon
 * @version v0.1
 */


public class MenuItems extends UI
{
   private GreenfootSound menuHover;
   public MenuItems()
   {
       menuHover = new GreenfootSound("MenuHover.wav");
       
    }
    
   public GreenfootSound getSound()
   {
       return menuHover;
    }
}
