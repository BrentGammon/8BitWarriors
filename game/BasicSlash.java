 

import greenfoot.*;
import java.util.List;
/**
 * Entity emitted by a sword when swung that does damage
 * 
 * @author Mitchell Rebuck-Watson
 * @version S2 1
 */
public class BasicSlash extends Entity
{
    /** Constants */
    public static final int BASE_SPEED = 10;
    public static final int DAMAGE = 1;
    private static final GreenfootImage img = new GreenfootImage("Projectiles/blueSlash1.png");
    
    private static final GreenfootImage SHEET = new GreenfootImage("redExplosion.png");
    private static final int SHEET_H = 4;
    private static final int SHEET_W = 4;
    private static final int SPRITE_H = SHEET.getHeight()/SHEET_H;
    private static final int SPRITE_W = SHEET.getWidth()/SHEET_W;
    
    /** State variables */
    private ExtendedActor source;
    private int speed;
    private int life = 5;
    private boolean hit = false;
    private int frame = 0;
    /**
     * Constructor for BasicSlash
     */
    public BasicSlash(boolean goLeft, ExtendedActor source){
        int boost = source instanceof Entity? ((Entity)source).getHorzVelocity():0;
        speed = goLeft? -BASE_SPEED+boost: BASE_SPEED+boost;
        this.source = source;
        setImage(new GreenfootImage(img));
        
        if (goLeft) getImage().mirrorHorizontally();
    }
    public void act() 
    {
        if (getExtendedWorld().isPaused()) return;
        if (hit){
            hit();
        }else if(life-->0){
            if(life<3) getImage().scale(getWidth()/2, getHeight());
            int unit = speed>0?1:-1;
            for(int i=0;i<Math.abs(speed)&&!doDamage();i++){
                moveLocation(unit,0);
            }
            
        }else if(doDamage()){}
        else die();
    }
    public boolean doDamage(){
        List<IDamageable> objs = getIntersectingObjects(IDamageable.class);
        for (IDamageable obj: objs){
            if (obj != source && obj.doDamage(source,DAMAGE)>0){
                hit = true;
                setImage(new GreenfootImage(SPRITE_H,SPRITE_W));
                frame = 0;
                return true;
            }
        }
        return false;
    }
    public void fire(){
        
    }
    /**
     * Perform hit animation
     * 
     * @return has died
     */
    public boolean hit(){
        getImage().clear();
        getImage().drawImage(SHEET,-(frame%SHEET_W)*SPRITE_W,-(frame/SHEET_H)*SPRITE_H);
        frame++;
        if (frame>5*5) return super.die();
        return false;
    }
}
