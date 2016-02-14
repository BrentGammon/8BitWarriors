import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Attack here.
 * 
 * @author Brent Gammon 
 * @version (a version number or a date)
 */
public class Attack extends Entity
{
    private boolean direction;
    
    public Attack(boolean direction){
        this.direction = direction;
    }
    
    /**
     * Act - do whatever the Attack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(direction){
            move(5);
        }else{
            move(-5);
        }
        
        if(isTouching(TrackEnemy.class)){
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
