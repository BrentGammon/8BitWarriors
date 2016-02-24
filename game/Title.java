import greenfoot.*;

/**
 * The game title that is present on the menu
 * 
 * @author Brent Gammon
 * @version v0.1
 */
public class Title extends MenuItems
{
    private GreenfootImage start;
    /**
     * Act - do whatever the Start wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Title(){
        start = new GreenfootImage("images/Graphics/MENUV2/M2Title.png");
        setImage(start);
    }  
}
