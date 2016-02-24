import greenfoot.*;

/**
 * Write a description of class PlayerFace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
