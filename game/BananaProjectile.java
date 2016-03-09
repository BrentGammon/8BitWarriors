import greenfoot.*;
import java.util.List;
/**
 * Fancy Banana Entity that is launched at a target. 
 * 
 * @author Mitchell Rebuck-Watson
 * @version S2 1
 */
public class BananaProjectile extends Attack implements IFalling
{   
    /** Constants */
    public static final int LIFE = 100;
    public static final int MOVE_SPEED = 12;
    public static final int X_OFFSET = -8;
    public static final int Y_OFFSET = -22;
    public static final int DAMAGE = 1;
    
    /** Sprite */
    private static final GreenfootImage SPRITE = new GreenfootImage("images/Projectiles/banana.png");
    
    /** State variables */
    private boolean damaging = false;
    private boolean facingLeft;
    private boolean thrown = false;
    private ExtendedActor target,source;
    private int life = LIFE;
    private int GRAVITY = 2;
    /**
     * Constructor for BananaProjectile
     * 
     * @param facingLeft Is the Actor holding it facing left
     * @param source The actor using the weapon
     */
    BananaProjectile(boolean facingLeft, ExtendedActor source){
        super(facingLeft,source);
        setImage(new GreenfootImage(SPRITE));
        if(facingLeft) getImage().mirrorHorizontally();
        this.facingLeft = facingLeft;
        this.target = target;
        this.source = source;
    }
    /**
     * Set the target for this weapon
     * 
     * @param a The Extended actor to be targeted
     */
    public void setTarget(ExtendedActor a){
        target = a;
    }
    /**
     * Throws the banana
     */
    public void fire(){
        //get targets position and our position
        int targetX = target.getX();
        int targetY = target.getY();
        int x = getX();
        int y = getY();
        
        //get distance between target and self
        int dx = targetX - x;
        int dy = targetY - y;
        
        //calculate time of travel with constant horz velocity
        int travelTime = Math.abs(dx)/MOVE_SPEED;
        
        //solve for vertical velocity
        vertVelocity = travelTime * -GRAVITY /2;
        horzVelocity = dx>0?MOVE_SPEED:-MOVE_SPEED;
        
        //set self to thrown
        thrown = true;
        damaging = true;
    }
    /**
     * Act - do whatever the BananaProjectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (getExtendedWorld().isPaused()) return;
        if (thrown){
            if (--life<=0) die();
            else{
                
                if(collideMoveLocation(horzVelocity, vertVelocity)||onPlatform()){
                    horzVelocity = 0;
                    damaging = false;
                }
                if (damaging){
                    if (doDamage()) die();
                    else turn(facingLeft?-20:20);
                }
                
               
                
            }   
        }else{
            setLocation(source.getX()+ (facingLeft?-X_OFFSET:X_OFFSET),source.getY()+Y_OFFSET);
        }
    }
    /**
     * Does damage to all things that touch the bananna
     */
    public boolean doDamage(){
        List<IDamageable> objs = getIntersectingObjects(IDamageable.class);
        for (IDamageable obj: objs){
            if (obj == target && obj.doDamage(source,DAMAGE)>0){
                return true;
            }
        }
        return false;
    }
    /**
     * Implementation of IFalling
     */
    public void fall(int g){
        if(thrown) super.fall(g);
    }
    /*
     * Properly set direction of image when do 
     */
    public void setDirection(boolean f){
        if (!f && facingLeft)getImage().mirrorHorizontally();
        facingLeft = f;
    }
    
}
