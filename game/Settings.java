import greenfoot.*;

/**
 * The button for the settings om the menu
 * 
 * @author Brent Gammon
 * @version v0.1
 */
public class Settings extends MenuItems
{
    private GreenfootImage start;
    /**
     * Act - do whatever the Start wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Settings(){
        start = new GreenfootImage("images/Graphics/MENUV2/M2Settings.png");
        setImage(start);
    }   
    
    public void act() 
    {
       if(Greenfoot.mouseClicked(this)){
          System.out.println("Settings has been clicked");
       }
    }    
}
