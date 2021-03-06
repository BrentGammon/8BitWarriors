 

import greenfoot.*;
/**
 * The button for the settings on the menu
 * 
 * @author Brent Gammon
 * @version v0.1
 */
public class Settings extends MenuItems
{
    private GreenfootImage start;
    private boolean selected = false;
    /**
     * Contructor for Settings
     * When object is created it will set the image for that object
     */
    public Settings(){
        start = new GreenfootImage("images/Graphics/MENUV2/M2Settings.png");
        setImage(start);
    }   
    
    /**
     * Checks if the mouse is on the object if so then the image is changed to show the player that they are on the object
     * if clicked to change the world to the settings menu
     */
    public void act() 
    {
        if(isHovered()){
            if (!selected) getSound().play();
                start = new GreenfootImage("images/Graphics/MENUV2/M2SettingsON.png");
                selected = true;
                setImage(start);
        }else{
            start = new GreenfootImage("images/Graphics/MENUV2/M2Settings.png");
            selected = false;
            setImage(start);
        }
        if(Greenfoot.mouseClicked(this)){
            World world = getWorld();
            MenuSettings world1 = new MenuSettings();
            Greenfoot.setWorld(world1);
        }
    }    
}
