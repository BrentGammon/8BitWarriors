import greenfoot.*;
import java.util.*;
/**
 * This is the object that the proal will spawn, this will fall and damage the player
 * 
 * @author Brent Gammon 
 * @version S3 29/03/16
 */
public class RockAttack extends Attack implements IFalling
{
    private boolean direction;
    private ExtendedActor source;
    private static final int DAMAGE = 1;
    /**
     * Act - do whatever the RockAttack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        List <Actor> intersecting = getIntersectingObjects(Actor.class);
        for(Actor a : intersecting){
            if(a instanceof Player){
                doDamage();
            }
        }
    }
    
    
    /**
     * Constructor for RockAttack
     * @param boolean direction what dirctin the obvject is facing
     * @param ExtendedActor source this is the actor that is spawning this object into the world
     */
    public RockAttack(boolean direction, ExtendedActor source)
    {
        super(direction,source);
        this.source = source;
    }
    
    /**
     * This method does not do anything had to implmented so it could extend attack but this is not needed
     */
    public void fire(){}

    /**
     * When the object is not on the platform then the object will fall  
     * @param int g This is the gravity of the object falling
     */
    public void fall(int g){

        vertVelocity+=g;
        if(vertVelocity>0){
            for(int i=0;i<vertVelocity;i++){
                moveLocation(0,1);
            }
        } 
    }

    /**
     * Do damage to all things that can be hurt by weapon
     */
    public void doDamage(){
        List<IDamageable> objs = getIntersectingObjects(IDamageable.class);
        for (IDamageable obj: objs){
            if (obj!=source){
                obj.doDamage(source,DAMAGE);
            }
        }
    }
    
    /**
     * When invoked this method will cause the object to die
     */
    public boolean die(){
        getWorld().addObject(new DeadEntity(getImage()),getX(),getY());
        return super.die();
    }
}
