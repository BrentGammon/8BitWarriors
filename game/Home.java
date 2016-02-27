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
     * When the object has been clicked it will load the menu world
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
