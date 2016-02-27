import greenfoot.*;

/**
 * Image of the player face that is present on the menu
 * 
 * @author Brent Gammon 
 * @version v0.1
 */
public class PlayerFace extends MenuItems
{
    private GreenfootImage start;
    /**
     * Constuctor of the class PlayerFace
     * When invoked it will set the image for the object
     */
    public PlayerFace(){
        start = new GreenfootImage("images/Graphics/MENUV2/M2PlayerFace.png");
        setImage(start);
    }
}
