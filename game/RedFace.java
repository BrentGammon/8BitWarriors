import greenfoot.*;

/**
 * The enemy face that is present on the menu
 * 
 * @author Brent Gammon 
 * @version v0.1
 */
public class RedFace extends MenuItems
{
    private GreenfootImage start;
    /**
     * Act - do whatever the Start wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public RedFace(){
        start = new GreenfootImage("images/Graphics/MENUV2/M2RedFace.png");
        setImage(start);
    }
}
