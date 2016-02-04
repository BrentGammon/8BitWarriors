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
        addObject(new Grass(),50,300);
        addObject(new Grass(),100,300);
        addObject(new Grass(),150,300);
        addObject(new Grass(),200,300);
        addObject(new Grass(),250,300);
        addObject(new Grass(),300,300);
        addObject(new Grass(),400,300);
        addObject(new Grass(),450,300);
        addObject(new Grass(),500,300);
        addObject(new Grass(),550,300);
        addObject(new Grass(),600,300);
        addObject(new Grass(),650,300);
        addObject(new Grass(),700,300);
        addObject(new Grass(),750,300);
        addObject(new Grass(),800,300);
        addObject(new Grass(),850,300);
        addObject(new Grass(),900,300);
        addObject(new Grass(),950,300);
        
        
        addObject(new TrackEnemy(),600,100);
        
    }
}
