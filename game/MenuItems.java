 

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
   
   public boolean isHovered()
   {
       MouseInfo mouse = Greenfoot.getMouseInfo();
       if (mouse != null) return getWorld().getObjectsAt(mouse.getX(), mouse.getY(),MenuItems.class).contains(this);
       return false;
   }
}
