 

import greenfoot.*;

/**
 * Basic one way platform that can be stood on but not collided with from the bottom or sides
 * @author Mitchell Rebuck Watson
 * @version S2 1
 */
public class WoodLog extends Terrain implements IPlatform
{
	/**
	*Constructor for WoodLog sets the image of the object
	*/
    public WoodLog(){
        setImage("Terrain/logbase.png");
    }
    public WoodLog(int size){
        
        if (size <= 1) setImage("Terrain/logbase.png");
        else{
            GreenfootImage unit = new GreenfootImage("Terrain/logbase.png");
            GreenfootImage ext = new GreenfootImage("Terrain/logbase.png");
        }
        setImage("Terrain/logbase.png");
    }
    private int getTop(){
        return getY()-(getHeight()/2);
    }
    @Override
    public boolean canSupportEntity(Entity e){
        return e.getY()+(e.getHeight()/2) <= getTop();
    }
	
	
    public boolean bottomIsCollidable(){
        return false;
    }
}
 