import greenfoot.*;
import java.util.*;
/**
 * This object will spawn ShieldPower when the cooldown allows it
 * 
 * @author Brent Gammon
 * @version S3 29/3/16
 */
public class EnemyShield extends Entity implements IDamageable
{
    private int health = 1;
    private int delay = 100;
    private GreenfootImage sprite = new GreenfootImage("shieldGenerator.png");
    /**
     * Constructor for EnemyShield, sets the sprite for the bject when its in the world
     */
    public EnemyShield(){
        setImage(sprite);
    }

    /**
     * checks if the boss enemey is presented in the world and spawns ShieldPower if true and delay allows it to do so
     */
    public void act() 
    {
        if(delay==100){
            List <Actor> bossList = getWorld().getObjects(BossEnemy.class);
            if(bossList.size()>0){
                ShieldPower sp = new ShieldPower(getX(),getY());
                getWorld().addObject(sp,getX(),getY()-50);
            }
        }
        delay--;
        if(delay<=0){
            delay=100;
        }
    }

    /**
     * When called this will increment the score counter and add DeadEntity to the world
     * @return a super call to die
     */
    public boolean die(){
        Counter.add();
        getWorld().addObject(new DeadEntity(getImage()),getX(),getY());
        return super.die();
    }

    /**
     * Does damage to the actor that has been passed into the paramter
     * @param Actor attacker the actor that is going to have damage done to them
     * @param int damage the strength of the damage
     * @return int damage the amount done to the actor
     */
    public int doDamage(Actor attacker, int damage){
        health -= damage;
        //attackSound.play();
        if (health<=0) die();
        return damage;
    }
}
