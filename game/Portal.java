 

import greenfoot.*;

/**
 * Write a description of class Portal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Portal extends Entity
{
    /**
     * Act - do whatever the Portal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        spawnWorld();
    }    
    
    public void spawnWorld(){
        
        Actor a = getOneIntersectingObject(Player.class);
            if (a != null){
            Greenfoot.setWorld(new World2());
            return;
        
        
        
    }
}
}
