package game;

import greenfoot.*;
import java.util.List;
/**
 * Simple Monkey Enemy that spawns bananas to throw and hops around
 * 
 * @author Mitchell Rebuck-Watson
 * @version S2 1
 */
public class MonkeyEnemy extends Entity implements IFalling, IDamageable
{
    /** Constants */
    private static final int HOP_SPEED = -12;
    private static final int MOVE_SPEED = 3;
    private static final int COOLDOWN = 100;
    private static final int IDLE_COOLDOWN = 100;
    private static final int HEALTH = 1;
    /** Sprites */
    private GreenfootImage rightSp = new GreenfootImage("images/Graphics/Characters/Antagonist Characters/Monkey Enemy.png");;
    private GreenfootImage leftSp;
    /** Weapon variables */
    private BananaProjectile weapon;
    private int cooldown = COOLDOWN;
    /** State variables */
    private boolean facingLeft = false;
    private int idleCooldown = IDLE_COOLDOWN;
    private int health = HEALTH;
    
    private GreenfootSound attackSound = new GreenfootSound("AttackHitSound.wav");
    
    /**
     * Constructor for Monkey Enemy
     */
    public MonkeyEnemy(){
        leftSp = new GreenfootImage(rightSp);
        leftSp.mirrorHorizontally();
        setImage(rightSp);
    }
    /**
     * Act - do whatever the MonkeyEnemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (getExtendedWorld().isPaused()) return;
        //if cooldown is still counting and about to reach 0 then spawn new banana
        if (cooldown>0&& cooldown-- == 1){
            weapon = new BananaProjectile(facingLeft,this);
            getWorld().addObject(weapon,getX(),getY());
        }
        // if not currently in the air
        if (onPlatform()){
            //if was falling stop
            if (vertVelocity>0) {vertVelocity = 0;}
            // stop horizontal speed
            horzVelocity = 0;
            List<Player> nearObjects = getObjectsInRange(300,Player.class);
            // if player is near
            if (nearObjects.size()>0){
                //reset idle cooldown
                idleCooldown = IDLE_COOLDOWN;
                Player p = nearObjects.get(0);
                //if player is further right than monkey
                if (p.getX()>getX()){
                    setImage(rightSp);
                    facingLeft = false;
                    horzVelocity=MOVE_SPEED;
                }else{
                    setImage(leftSp);
                    facingLeft = true;
                    horzVelocity= -MOVE_SPEED;
                }
                hop();
                if (weapon!=null){
                    //tell weapon what to attack
                    weapon.setTarget(p);
                    //if in range throw banana
                    if (getDistanceTo(p)<250){
                        weapon.fire();
                        weapon = null;
                        cooldown = COOLDOWN;
                    }
                }
            }else idle();
        }
        if (weapon!=null) weapon.setDirection(facingLeft);
        if (collideMoveLocation(horzVelocity,vertVelocity))horzVelocity = 0;
    }
    /*
     * can only be hurt by player
     */
    public int doDamage(Actor a, int dmg){
        if (a instanceof Player){
            health -= dmg;
            attackSound.play();
            if (health>0) return dmg;
            die();
        }
        return dmg;
    }
    /**
     * Perform idle behavior logic
     */
    private void idle(){
        if (idleCooldown-- <= 0){
            idleCooldown = IDLE_COOLDOWN;
            if(Greenfoot.getRandomNumber(2) == 0){
                horzVelocity=MOVE_SPEED;
            } else{
                horzVelocity=-MOVE_SPEED;
            }
            hop();
        }
    }
    /**
     * Makes the monkey hop upwards
     */
    private void hop(){
        if(onPlatform()){
            vertVelocity = HOP_SPEED;
        }
    }
    /**
     * On death increment score and spawn new Dead entity
     */
    public boolean die(){
        Counter.add();
        if (weapon != null) weapon.die();
        getWorld().addObject(new DeadEntity(getImage()),getX(),getY());
        return super.die();
    }
}
