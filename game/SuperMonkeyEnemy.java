import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
/**
 * More powerful version of monkey enemy
 * 
 * @author Mitchell Rebuck-Watson
 * @version S3 1
 */
public class SuperMonkeyEnemy extends Entity implements IFalling, IDamageable
{
    /** Constants */
    public static final int HOP_SPEED = -8;
    public static final int MOVE_SPEED = 5;
    public static final int COOLDOWN = 40;
    public static final int IDLE_COOLDOWN = 200;
    public static final int MINION_COOLDOWN = 500;
    public static final int HEALTH = 2;
    /** Sprites */
    protected GreenfootImage rightSp = new GreenfootImage("images/Graphics/Characters/Antagonist Characters/Super Monkey Enemy.png");
    protected GreenfootImage leftSp;
    /** Weapon variables */
    protected BananaProjectile weapon;
    protected int cooldown = COOLDOWN;
    private int minionCooldown = MINION_COOLDOWN;
    /** State variables */
    protected boolean facingLeft = false;
    protected int idleCooldown = IDLE_COOLDOWN;
    protected int health = HEALTH;
    private int iframes =0;
    
    private List<MonkeyEnemy> minions;
    private GreenfootSound attackSound = new GreenfootSound("AttackHitSound.wav");
    
    /**
     * Constructor for Monkey Enemy
     */
    public SuperMonkeyEnemy(){
        minions = new ArrayList<MonkeyEnemy>();
        
        leftSp = new GreenfootImage(rightSp);
        leftSp.mirrorHorizontally();
        setImage(rightSp);
    }
    protected void addedToWorld(World w){
        MonkeyEnemy m1, m2;
        m1 = new MonkeyEnemy(this);
        m2 = new MonkeyEnemy(this);
        w.addObject(m1,getX()+Greenfoot.getRandomNumber(20)-10,getY());
        w.addObject(m2,getX()+Greenfoot.getRandomNumber(20)-10,getY());
        minions.add(m1);
        minions.add(m2);
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
        if (iframes>0){
            if(iframes%10<5){
                setImage(SpriteHelper.makeWhite(facingLeft?leftSp:rightSp));
            }else{
                setImage(facingLeft?leftSp:rightSp);
            }
            iframes--;
        }else{
            // if not currently in the air
            if (onPlatform()){
                if (minionCooldown>0)minionCooldown--;
                
                //if was falling stop
                if (vertVelocity>0) {vertVelocity = 0;}
                // stop horizontal speed
                horzVelocity = 0;
                List<Player> nearObjects = getObjectsInRange(400,Player.class);
                // if player is near
                if (minions.size()==0&&nearObjects.size()>0){
                    //reset idle cooldown
                    idleCooldown = IDLE_COOLDOWN;
                    Player p = nearObjects.get(0);
                    if (Greenfoot.getRandomNumber(minions.size()*2+1)==0) spawnMinion();
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
        if (idleCooldown==1)hop();
        if (idleCooldown-- <= 0){
            idleCooldown = IDLE_COOLDOWN;
            if (Greenfoot.getRandomNumber(minions.size()*2)==0) spawnMinion();
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
        Counter.add(300);
        getWorld().addObject(new ScoreIndicator(300), getX(),getY());
        if (weapon != null) weapon.die();
        getWorld().addObject(new DeadEntity(getImage()),getX(),getY());
        return super.die();
    }
    
    private void spawnMinion(){
        if (minionCooldown==0){
            minionCooldown = MINION_COOLDOWN;
            MonkeyEnemy m = new MonkeyEnemy(this);
            minions.add(m);
            getWorld().addObject(m,getX()+Greenfoot.getRandomNumber(20)-10,getY());
        }
    }
    
    public void minionDeath(MonkeyEnemy m){
        minions.remove(m);
    }
}

