import greenfoot.*;
import java.util.List;
/**
 * Bomb Attack that is thrown from where the source is standing
 * 
 * @author Mitchell Rebuck-Watson
 * @version (a version number or a date)
 */
public class Bomb extends Attack implements IFalling
{
    /** State Variables */
    private boolean lit = false;
    private int fuse = 48,bombFrame=0;
    
    /** Constants */
    private static final int DAMAGE = 3;
    
    private static final GreenfootImage SHEET1 = new GreenfootImage("redExplosionx2.png");
    private static final int SHEET1_H = 4;
    private static final int SHEET1_W = 4;
    private static final int SPRITE1_H = SHEET1.getHeight()/SHEET1_H;
    private static final int SPRITE1_W = SHEET1.getWidth()/SHEET1_W;
    
    private static final GreenfootImage SHEET2 = new GreenfootImage("bomb.png");
    private static final int SHEET2_H = 1;
    private static final int SHEET2_W = 7;
    private static final int SPRITE2_H = SHEET2.getHeight()/SHEET2_H;
    private static final int SPRITE2_W = SHEET2.getWidth()/SHEET2_W;
    
    /**
     * Main constructor
     * 
     * @param direction is the bomb facing left
     * @param source owner of the bomb
     */
    public Bomb(boolean direction, ExtendedActor source){
        super(direction, source);
        setImage(new GreenfootImage(SPRITE2_W,SPRITE2_H));
    }
    /**
     * Act - do whatever the Bomb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        updateSprite();
        if (lit&&fuse>0){
            fuse = Math.max(fuse-1,0);
            if( collideMoveLocation(horzVelocity,vertVelocity) ){
                fuse = 0;
            }
        }else if(lit){
            if (bombFrame == 0 && fuse == 0){
                setImage(new GreenfootImage(SPRITE1_W,SPRITE1_H));
                doDamage();
            }
            bombFrame++;
            if (bombFrame==SHEET1_H*SHEET1_W)die();
        }else{
            setLocation(getSource().getX(), getSource().getY());
        }
    }
    /**
     * Repaint the sprite for the bomb
     */
    public void updateSprite(){
        GreenfootImage bg = getImage();
        bg.clear();
        
        if (fuse>0){
            bg.drawImage(SHEET2,-(SHEET2_W-1-(fuse/8))*SPRITE2_W,0);
            if (getDirection())getImage().mirrorHorizontally();
        }
        else{
            bg.drawImage(SHEET1,-(bombFrame%SHEET1_W)*SPRITE1_W,-(bombFrame/SHEET1_H)*SPRITE1_H);
        }
    }
    /**
     * Launch the bomb
     */
    public void fire(){
        lit = true;
        horzVelocity = getDirection()?-7:7;
        vertVelocity = -20;
        
    }
    /**
     * Do damage to all damageable objects that touch the sprite
     */
    public void doDamage(){
        ExtendedActor source = getSource();
        List<IDamageable> objs = getIntersectingObjects(IDamageable.class);
        for (IDamageable obj: objs){
            if (obj!=source){
                obj.doDamage(source,DAMAGE);
            }
        }
    }
}
