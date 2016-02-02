import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World1 extends ExtendedWorld
{

    /**
     * Constructor for objects of class World1.
     * 
     */
    public World1()
    {
        WORLD_WIDTH = 1920;
        Player p = new Player();
        fullBackground = new GreenfootImage("images/bliss.jpg");
        redrawBackground();
        addObject(p,100,100);
        addObject(new Terrain(),300,300);
        addObject(new Terrain(),100,300);
        
    }
}
