import greenfoot.*;
import java.util.*;
/**
 * Write a description of class BulletAttack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BulletAttack extends Attack implements IDamageable
{
    private boolean direction;
    private int removeTimer = 90;
    private ExtendedActor source;
    private static final int DAMAGE = 1;
    private GreenfootImage sprite = new GreenfootImage("Graphics/Characters/Antagonist Characters/arrow.png");
    private int health = 1;
    public BulletAttack(boolean direction,ExtendedActor source){
        super(direction,source);
        this.direction = direction; 
        this.source = source;
        setImage(sprite);
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
     * Doe damage to the actor that has been passed into the paramter
     * @param Actor attacker the actor that is going to have damage done to them
     * @param int damage the strength of the damage
     * @return int damage the amount done to the actor
     */
    public int doDamage(Actor attacker, int damage){
        health -= damage;
        //attackSound.play();
        if (health<=0){
            die();
        }
        return damage;
    }

    /**
     * When called this will increment the score counter and add DeadEntity to the world
     * @return a super call to die
     */
    public boolean die(){
        //scoreboard incremented by one
        Counter.add();
        getWorld().addObject(new DeadEntity(getImage()),getX(),getY());
        return super.die();
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
