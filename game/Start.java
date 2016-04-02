 

import greenfoot.*;
/**
 * Start button for the menu
 * 
 * @author Brent Gammon 
 * @version SP3 2/4/16
 */
public class Start extends MenuItems
{
    private GreenfootImage start;
    private boolean selected = false;
    /**
     * Constructor for the class Start
     */
    public Start(){
        start = new GreenfootImage("images/Graphics/MENUV2/M2StartGame.png");
        setImage(start);
    }
    
    /**
     * * This will checking two states when the mouse is hover on and off the object to change the image 
     * When object is clicked it will load world1
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
