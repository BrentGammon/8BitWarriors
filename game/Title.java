package game;

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
     * The constructor of the Title class
     * when invoked it will set the title to the title image
     */
    public Title(){
        start = new GreenfootImage("images/Graphics/MENUV2/M2Title.png");
        setImage(start);
    }  
}
