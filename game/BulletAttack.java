import greenfoot.*;
import java.util.*;
/**
 * This object gets spawned by the rangeEnemy. This obejct can damage the player
 * 
 * @author Brent Gammon 
 * @version SP3 1/4/16
 */
public class BulletAttack extends Attack implements IDamageable
{
    private boolean direction;
    private int removeTimer = 90;
    private ExtendedActor source;
    private static final int DAMAGE = 1;
    private GreenfootImage sprite = new GreenfootImage("Graphics/Characters/Antagonist Characters/arrow.png");
    private int health = 1;
    /**
     * Constructor for BulletAttack
     * @param boolean direction the dirction that the object will travel
     * @param ExtendedActor source the acotr that spawned this object
     */
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
          if (getExtendedWorld().isPaused()) return;
        fire();
        doDamage();
        remove();
    }    

    /**
     * This method checks the value of removeTimer if this equals to 0 then the obejcts gets removed
     */
    public void remove(){
        removeTimer--;
        if(this.isTouching(Wall.class)||this.isTouching(Grass.class)){
            getWorld().removeObject(this);
        }else
        if(removeTimer==0){
            getWorld().removeObject(this);
        }
    }

    /**
     * Move the location of the object 
     * direction depends on the value of the instance variable direction
     */
    public void fire(){
        if(!direction){
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
        if(attacker instanceof Player){
            if (health<=0){
                die();
            }
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
            if (obj instanceof Player){
                obj.doDamage(source,DAMAGE);
            }
        }
    }
}
