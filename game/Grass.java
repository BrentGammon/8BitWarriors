import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Grass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
