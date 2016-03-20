import greenfoot.*;
import java.util.List;

/**
 * Players default weapon. Is its own entity for damage system simplicity
 * and is effectively glued to the player.
 * 
 * @author Mitchell Rebuck-Watson
 * @version S2 1
 */
public class BasicAttack extends Attack
{
    /** Constants */
    public static final int ATTACK_TIME = 8;
    private static final int BOOSTED = ATTACK_TIME - 4;
    private static final int DAMAGE = 1;
    private static final int X_OFFSET = 10;
    private static final int Y_OFFSET = 2;
    protected int boostAttack = ATTACK_TIME;
    
    /** State variables */
    private int attackTime = 0;
    private boolean facingLeft = false;
    private ExtendedActor source;
    
    
   
    private static boolean stillAlive;
    
    /**
     * Constructor for Basic Attack
     * 
     * @param direction The direction to face
     * @param source The actor that is using the weapon
     */
    public BasicAttack(boolean direction, ExtendedActor source){
        super(direction,source);
        setImage("Weapons/swordIdle.png");
        this.source = source;
        stillAlive = true;
    }
    /**
     * Perform a swing
     */
    public void fire(){
        if (attackTime==0){
            getWorld().addObject(new BasicSlash(facingLeft, source),getX(),getY());
            if( source instanceof Player && ((Player)source).hasAttackBoost()) attackTime = BOOSTED;
            else attackTime = ATTACK_TIME;
            setImage("Weapons/swordSwing.png");
            if (facingLeft) getImage().mirrorHorizontally();
        }
    }
    /**
     * Extended from Base Actor
     */
    public void act() 
    {
        if (getExtendedWorld().isPaused()) return;
        if(stillAlive){setLocation(source.getX()+ (facingLeft?-X_OFFSET:X_OFFSET),source.getY());}
        if (attackTime>0){
            attackTime--;
            doDamage();
            if (attackTime==0){
                setImage("Weapons/swordIdle.png");
                if (facingLeft) getImage().mirrorHorizontally();
            }
        }
        
    }
    
      public static void stopFind(){
        stillAlive = false;
    }
    
    /**
     * Properly intercept direction setting
     * 
     * @param isLeft direction
     */
    public void setDirection(boolean isLeft){
        if(!isLeft == facingLeft){
            facingLeft = isLeft;
            getImage().mirrorHorizontally();
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
