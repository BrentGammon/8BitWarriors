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
     * Constructor for Home this sets the image of the object
     */
    public Home()
    {
        setImage("/Settings/homebutton.png");
    }
    /**
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
