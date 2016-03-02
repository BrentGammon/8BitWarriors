import greenfoot.*;
import java.util.List;
/**
 * Write a description of class BananaProjectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BananaProjectile extends Attack implements IFalling
{   
    public static final int LIFE = 100;
    public static final int MOVE_SPEED = 12;
    public static final int X_OFFSET = -8;
    public static final int Y_OFFSET = -22;
    public static final int DAMAGE = 1;
    
    private static final GreenfootImage SPRITE = new GreenfootImage("images/Projectiles/banana.png");
    
    private boolean damaging = false;
    private boolean facingLeft;
    private boolean thrown = false;
    private ExtendedActor target,source;
    private int life = LIFE;
    private int GRAVITY = 2;
    
    BananaProjectile(boolean facingLeft, ExtendedActor source){
        super(facingLeft,source);
        setImage(new GreenfootImage(SPRITE));
        if(facingLeft) getImage().mirrorHorizontally();
        this.facingLeft = facingLeft;
        this.target = target;
        this.source = source;
    }
    public void setTarget(ExtendedActor a){
        target = a;
    }
    public void fire(){
        int targetX = target.getX();
        int targetY = target.getY();
        int x = getX();
        int y = getY();
        
        int dx = targetX - x;
        int dy = targetY - y;
        
        int travelTime = Math.abs(dx)/MOVE_SPEED;
        
        vertVelocity = travelTime * -GRAVITY /2;
        horzVelocity = dx>0?MOVE_SPEED:-MOVE_SPEED;
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
    public boolean doDamage(){
        List<IDamageable> objs = getIntersectingObjects(IDamageable.class);
        for (IDamageable obj: objs){
            if (obj == target && obj.doDamage(source,DAMAGE)>0){
                return true;
            }
        }
        return false;
    }
    public void fall(int g){
        if(thrown) super.fall(g);
    }
    public void setDirection(boolean f){
        if (!f && facingLeft)getImage().mirrorHorizontally();
        facingLeft = f;
    }
    
}
