import greenfoot.*;
/**
 * Setting Wall terrain in the game.
 * 
 * @authors Brent Gammon
 * @version S3 3/4/16
 */
public class Wall extends Terrain
{
    private GreenfootImage unit = new GreenfootImage("Terrain/grass.png");
    private GreenfootImage unit3 = new GreenfootImage("Terrain/brick.png");
    private GreenfootImage unit4 = new GreenfootImage("Terrain/level2wall.png");
    
	/**
	*Constructor  for Wall
	*@param int length the height of the wall
	*@param int levelDesign sets the image for wall in the world
	*/
    public Wall(int length,int levelDesign){
        if(levelDesign==3){
            unit = unit3;
        }
        if(levelDesign==2){
            
            unit = unit4;
        }
        int unitHeight = unit.getHeight();
        GreenfootImage self = new GreenfootImage(unit.getWidth(),unitHeight*length);
        for(int x=0;x<length;x++){
            self.drawImage(unit,0,x*unitHeight);
        }
        setImage(self);
    }
}
