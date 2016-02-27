import greenfoot.*;
import java.util.List;

/**
 * Write a description of class BasicAttack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BasicAttack extends Attack
{
    private static final int ATTACK_TIME = 8;
    private static final int DAMAGE = 1;
    private static final int X_OFFSET = 10;
    private static final int Y_OFFSET = 2;
    
    private int attackTime = 0;
    private boolean facingLeft = false;
    private ExtendedActor source;
    public BasicAttack(boolean direction, ExtendedActor source){
        super(direction,source);
        setImage("Weapons/swordIdle.png");
        this.source = source;
    }
    public void fire(){
        if (attackTime==0){
            getWorld().addObject(new BasicSlash(facingLeft, source),getX(),getY());
            attackTime = ATTACK_TIME;
            setImage("Weapons/swordSwing.png");
            if (facingLeft) getImage().mirrorHorizontally();
        }
    }
    public void act() 
    {
        setLocation(source.getX()+ (facingLeft?-X_OFFSET:X_OFFSET),source.getY());
        if (attackTime>0){
            attackTime--;
            doDamage();
            if (attackTime==0){
                setImage("Weapons/swordIdle.png");
                if (facingLeft) getImage().mirrorHorizontally();
            }
        }
    }
    public void setDirection(boolean isLeft){
        if(!isLeft == facingLeft){
            facingLeft = isLeft;
            getImage().mirrorHorizontally();
        }
    }
    public void doDamage(){
        List<IDamageable> objs = getIntersectingObjects(IDamageable.class);
        for (IDamageable obj: objs){
            if (obj!=source) obj.doDamage(source,DAMAGE);
        }
    }
}
