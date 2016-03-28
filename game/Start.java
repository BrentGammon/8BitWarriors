 

import greenfoot.*;
/**
 * Start button for the menu
 * 
 * @author Brent Gammon 
 * @version v0.1
 */
public class Start extends MenuItems
{
    private GreenfootImage start;
    private boolean selected = false;
    public Start(){
        start = new GreenfootImage("images/Graphics/MENUV2/M2StartGame.png");
        setImage(start);
    }
    
    /**
     * Checks if the mouse is on the object if so then the image is changed to show the player that they are on the object
     * if clicked to change the world to the first level
     */
    public void act() 
    {
        if(isHovered()){
            if (!selected) getSound().play();
                start = new GreenfootImage("images/Graphics/MENUV2/M2StartGameON.png");
                selected = true;
                setImage(start);
        }else{
            start = new GreenfootImage("images/Graphics/MENUV2/M2StartGame.png");
            selected = false;
            setImage(start);
        }
        if(Greenfoot.mouseClicked(this)){
            World1 world1 = new World1();
            Greenfoot.setWorld(world1);
        }
    }    
}
