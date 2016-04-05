import greenfoot.*;

/**
 * The object will act as a banner for the pause menu
 * 
 * @author Brent Gammon 
 * @version SP3 5/4/16
 */
public class MenuButton extends MenuItems
{
    /**
     * Constructor for MenuButton sets the image for the object
     */
    public MenuButton(){
        GreenfootImage image = new GreenfootImage("images/PAUSE/backbutton.png");
        setImage(image);
    }
    
    /**
     *if this item is clicked then the menu world will be set as the current loaded world
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new Menu());
        }
    }    
}
