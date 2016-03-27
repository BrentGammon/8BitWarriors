import greenfoot.*;
import java.util.*;
/**
 * Write a description of class BulletAttack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BulletAttack extends Attack
{
   private boolean direction;
   private int removeTimer = 90;
    private ExtendedActor source;
       private static final int DAMAGE = 1;
    public BulletAttack(boolean direction,ExtendedActor source){
        super(direction,source);
        this.direction = direction; 
        this.source = source;
    }
    /**
     * Act - do whatever the BulletAttack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        fire();
        doDamage();
        timer();
        
    }    
    
    public void timer(){
        removeTimer--;
        if(removeTimer==0){
            getWorld().removeObject(this);
        }
    }
    
    public void fire(){
        if(direction){
            moveLocation(5,0);
        }else{
            moveLocation(-5,0);
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
}
