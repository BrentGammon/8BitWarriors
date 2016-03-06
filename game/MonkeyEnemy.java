import greenfoot.*;
import java.util.List;
/**
 * Write a description of class MonkeyEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MonkeyEnemy extends Entity implements IFalling, IDamageable
{
    private static final int HOP_SPEED = -12;
    private static final int MOVE_SPEED = 3;
    private static final int COOLDOWN = 100;
    private static final int IDLE_COOLDOWN = 100;
    private static final int HEALTH = 1;
    private GreenfootImage rightSp = new GreenfootImage("images/Graphics/Characters/Antagonist Characters/Monkey Enemy.png");;
    private GreenfootImage leftSp;
    
    private BananaProjectile weapon;
    private int cooldown = COOLDOWN;
    private boolean facingLeft = false;
    
    private int idleCooldown = IDLE_COOLDOWN;
    private int health = HEALTH;
    
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
        if (cooldown>0&& cooldown-- == 1){
            weapon = new BananaProjectile(facingLeft,this);
            getWorld().addObject(weapon,getX(),getY());
        }
        if (onPlatform()){
            if (vertVelocity>0) {vertVelocity = 0;}
            horzVelocity = 0;
            List<Player> nearObjects = getObjectsInRange(300,Player.class);
            if (nearObjects.size()>0){
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
                    weapon.setTarget(p);
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
    public int doDamage(Actor a, int dmg){
        System.out.println(a instanceof Player);
        
        System.out.println(dmg);
        if (a instanceof Player){
            health -= dmg;
            System.out.println("Monkey Hit");
            if (health>0) return dmg;
            die();
        }
        return 0;
    }
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
    private void hop(){
        if(onPlatform()){
            vertVelocity = HOP_SPEED;
        }
    }
    public boolean die(){
        getWorld().addObject(new DeadEntity(getImage()),getX(),getY());
        return super.die();
    }
}
