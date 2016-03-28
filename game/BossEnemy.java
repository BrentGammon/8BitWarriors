import greenfoot.*;
import java.util.*;
/**
 * Write a description of class BossEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossEnemy extends Entity implements IDamageable
{
    private int health = 10;
    private boolean shield = false;
    private int cooldown = 60;
    /**
     * Act - do whatever the BossEnemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        List<Actor>actors = getObjectsInRange(300,Player.class);

        if(actors.size()>0){
            Player p = (Player) actors.get(0);
            if(cooldown==60){
                //BulletAttack weapon = new BulletAttack(true,this);
                //getWorld().addObject(weapon,getX(),getY());
                RockPortal portal = new RockPortal();
                //getWorld().addObject(portal,p.getRealX(),p.getRealY()-20);
                getWorld().addObject(portal,p.getX(),p.getY()-200);
            }
        }
        
        List<EnemyShield> nearObjects = new ArrayList<EnemyShield>();
        nearObjects = getObjectsInRange(350,EnemyShield.class);

        if(nearObjects.size()>0){
            for(Actor x: nearObjects){
                if(x instanceof EnemyShield){
                    shield = true;
                }
            }

        }else{
            shield = false;
        }
        cooldown--;
        if(cooldown ==0){
            cooldown = 60;
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

    public int doDamage(Actor attacker, int damage){
        if(shield == false){
            health -= damage;
            //attackSound.play();
            if (health<=0) die();

        }
        return damage;
    }
}
