 

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Attack class will be used for when the player is attacking  
 * 
 * @author Brent Gammon 
 * @version (0.1)
 */
public class debugShot extends Entity
{
    private boolean direction;
    /**
     * Used for the direction of where the object will spawn agisnt the player
     */
    public debugShot(boolean direction,ExtendedActor source){
        this.direction = direction;
    }
    
    /**
     * Act - do whatever the Attack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (getExtendedWorld().isPaused()) return;
        if(direction){
            move(5);
        }else{
            move(-5);
        }
        if(isTouching(TrackEnemy.class)){
            Counter counter =(Counter) getWorld().getObjects(Counter.class).get(0);
            counter.add();
            World world = getWorld();
            List<TrackEnemy>holds = new ArrayList<TrackEnemy>();
            holds=getIntersectingObjects(TrackEnemy.class);
            for(Actor x:holds){
                if(x instanceof TrackEnemy){
                    world.removeObject(x);
                }
            }
        }   
        if(isTouching(DumbEnemy.class)){
            Counter counter =(Counter) getWorld().getObjects(Counter.class).get(0);
            counter.add();
            World world = getWorld();
            List<DumbEnemy>holds = new ArrayList<DumbEnemy>();
            holds=getIntersectingObjects(DumbEnemy.class);
            for(Actor x:holds){
                if(x instanceof DumbEnemy){
                    world.removeObject(x);
                }
            }
        }  
    }
}
