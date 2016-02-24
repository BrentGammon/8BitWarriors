import greenfoot.*;

/**
 * Returns to the main menu
 * 
 * @author Brent Gammon 
 * @version v0.1
 */
public class Home extends MenuItems
{
    /**
     * Act - do whatever the Home wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            World world = getWorld();
            Menu menu = new Menu();
            Greenfoot.setWorld(menu);
        }
    }    
}
