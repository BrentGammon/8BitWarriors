import greenfoot.*;

/**
 * Write a description of class EnemyShield here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyShield extends Entity implements IDamageable
{
    private int health = 1;
    /**
     * Act - do whatever the EnemyShield wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //if(health==0){
        //    die();
       // }
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
    
    public int doDamage(Actor attacker, int damage){
        health -= damage;
        //attackSound.play();
        if (health<=0) die();
        return damage;
    }
}
