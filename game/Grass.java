 

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Variable size grass block
 * 
 * @author Mitchell Rebuck-Watson
 * @version S2 2
 */
public class Grass extends Terrain
{
    /**
     * Act - do whatever the Grass wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage unit = new GreenfootImage("Terrain/grass.png");
    public Grass(){
        setImage(unit);
    }
    /**
     * Constructor for Grass
     * 
     * @param width How many times to repeat grass sprite
     */
    public Grass(int width){
        int unitWidth = unit.getWidth();
        GreenfootImage self = new GreenfootImage(unitWidth*width,unit.getHeight());
        for(int x=0;x<width;x++){
            self.drawImage(unit,x*unitWidth,0);
        }
        setImage(self);
        
    }
    public void act() 
    {
        // Add your action code here.
        
    }    
}
