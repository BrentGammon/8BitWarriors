import greenfoot.*;

/**
 * Write a description of class Wall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wall extends Terrain
{
    private GreenfootImage unit = new GreenfootImage("Terrain/grass.png");
    
    
    public Wall(int length){
        int unitHeight = unit.getHeight();
        
        GreenfootImage self = new GreenfootImage(unit.getWidth(),unitHeight*length);
        for(int x=0;x<length;x++){
            self.drawImage(unit,0,x*unitHeight);
        }
        //self.rotate(90);
        setImage(self);
        
    }
}
