 

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
     * Constructor for the class RedFace 
     * when invoked it will set the image for the object
     */
    public RedFace(){
        start = new GreenfootImage("images/Graphics/MENUV2/M2RedFace.png");
        setImage(start);
    }
}
