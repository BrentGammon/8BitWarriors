 

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
    protected static final int HOP_SPEED = -12;
    protected static final int MOVE_SPEED = 3;
    protected static final int COOLDOWN = 100;
    protected static final int IDLE_COOLDOWN = 100;
    protected static final int HEALTH = 4;
    /** Sprites */
    protected GreenfootImage rightSp = new GreenfootImage("images/Graphics/Characters/Antagonist Characters/Monkey Enemy.png");
    protected GreenfootImage leftSp;
    /** Weapon variables */
    protected BananaProjectile weapon;
    protected int cooldown = COOLDOWN;
    /** State variables */
    protected boolean facingLeft = false;
    protected int idleCooldown = IDLE_COOLDOWN;
    protected int health = HEALTH;
    
    private int iframes = 0;
    private SuperMonkeyEnemy boss;
    private GreenfootSound attackSound = new GreenfootSound("AttackHitSound.wav");
    
    /**
     * Constructor for Monkey Enemy
     */
    public MonkeyEnemy(){
        leftSp = new GreenfootImage(rightSp);
        leftSp.mirrorHorizontally();
        setImage(rightSp);
    }
    public MonkeyEnemy(SuperMonkeyEnemy boss){
        rightSp = new GreenfootImage("images/Graphics/Characters/Antagonist Characters/Monkey Enemy Minion.png");
        leftSp = new GreenfootImage(rightSp);
        leftSp.mirrorHorizontally();
        setImage(rightSp);
        this.boss = boss;
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
        if (iframes>0){
            if(iframes%10<5){
                setImage(SpriteHelper.makeWhite(facingLeft?leftSp:rightSp));
            }else{
                setImage(facingLeft?leftSp:rightSp);
            }
            iframes--;
        }else{
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
        }
        if (weapon!=null) weapon.setDirection(facingLeft);
        if (collideMoveLocation(horzVelocity,vertVelocity))horzVelocity = 0;
    }
    /*
     * can only be hurt by player
     */
    public int doDamage(Actor a, int dmg){
        if( iframes==0 ){
            if (a instanceof Player){
                cooldown = COOLDOWN;
                health -= dmg;
                iframes = 20;
                vertVelocity = -8;
                attackSound.play();
                if (health>0) return dmg;
                die();
            }
            return dmg;
        }else return 0;
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
        Counter.add(140);
        getWorld().addObject(new ScoreIndicator(140), getX(),getY());
        if (weapon != null) weapon.die();
        if (boss != null) boss.minionDeath(this);
        getWorld().addObject(new DeadEntity(getImage()),getX(),getY());
        return super.die();
    }
}
