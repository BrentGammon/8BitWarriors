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
     * Act - do whatever the Start wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public PlayerFace(){
        start = new GreenfootImage("images/Graphics/MENUV2/M2PlayerFace.png");
        setImage(start);
    }
}
