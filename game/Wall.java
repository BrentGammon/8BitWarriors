import greenfoot.*;

/**
 * Setting Wall terrain in the game.
 * 
 * @authors Mitchell Rebuck Watson, Mati
 * @version 0.2
 */
public class Wall extends Terrain
{
    private GreenfootImage unit = new GreenfootImage("Terrain/grass.png");
    private GreenfootImage unit3 = new GreenfootImage("Terrain/brick.png");
    
    public Wall(int length,int levelDesign){
        if(levelDesign==3){
            unit = unit3;
        }
        
        
        int unitHeight = unit.getHeight();
        
        GreenfootImage self = new GreenfootImage(unit.getWidth(),unitHeight*length);
        for(int x=0;x<length;x++){
            self.drawImage(unit,0,x*unitHeight);
        }
        //self.rotate(90);
        setImage(self);
        
    }
}
