import greenfoot.*;
import java.util.*;
/**
 * Write a description of class RockAttack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
        List <Actor> intersecting = getIntersectingObjects(Grass.class);
        if(intersecting.size()>0){
            //if(intersects(Grass.class)){
               doDamage();
                die();
            //}
        }

    }  

    public RockAttack(boolean direction, ExtendedActor source)
    {
        super(direction,source);
        this.source = source;
        //this.direction = direction;

    }

    public void fire()
    {

    }

    /**
     * When the object is not on the platform then the object will fall  
     * @param int g This is the gravity of the object falling
     */
    public void fall(int g){
        if (!onPlatform()){
            vertVelocity+=g;
            if(vertVelocity>0){
                for(int i=0;i<vertVelocity;i++){
                    moveLocation(0,1);
                    if (!getIntersectingObjects(Terrain.class).isEmpty()){
                        vertVelocity = 0;
                    }
                }
            } else if(vertVelocity>0){
                for(int i=0;i>vertVelocity;i--){
                    moveLocation(0,-1);
                    if (!getIntersectingObjects(Terrain.class).isEmpty()){
                        vertVelocity = 0;
                    }
                }
            }
        }else{
            vertVelocity = 0;
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

    public boolean die(){
        getWorld().addObject(new DeadEntity(getImage()),getX(),getY());
        return super.die();
    }
}
