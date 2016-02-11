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
        addObject(p,100,600);
        addObject(new Grass(),150,800);
        addObject(new Grass(),100,800);
        addObject(new Grass(),150,800);
        addObject(new Grass(),200,800);
        addObject(new Grass(),250,800);
        addObject(new Grass(),300,800);
        addObject(new Grass(),400,800);
        addObject(new Grass(),450,800);
        addObject(new Grass(),500,800);
        addObject(new Grass(),550,800);
        addObject(new Grass(),600,800);
        addObject(new Grass(),650,800);
        addObject(new Grass(),700,800);
        addObject(new Grass(),750,800);
        addObject(new Grass(),800,800);
        addObject(new Grass(),850,800);
        addObject(new Grass(),900,800);
        addObject(new Grass(),950,800);
        
        addObject(new Powerup(1),200,700);
        addObject(new TrackEnemy(),600,600);
        
        centreCameraOn(p);
        
    }
}
