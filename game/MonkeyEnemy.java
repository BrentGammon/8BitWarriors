import greenfoot.*;
import java.util.List;
/**
 * Write a description of class MonkeyEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MonkeyEnemy extends Entity implements IFalling
{
    private static final int HOP_SPEED = -12;
    private static final int MOVE_SPEED = 3;
    private static final int COOLDOWN = 100;
    
    private GreenfootImage rightSp = new GreenfootImage("images/Graphics/Characters/Antagonist Characters/Monkey Enemy.png");;
    private GreenfootImage leftSp;
    
    private BananaProjectile weapon;
    private int cooldown = COOLDOWN;
    private boolean facingLeft = false;
    MonkeyEnemy(){
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
        if (cooldown>0&& cooldown-- == 1){
            weapon = new BananaProjectile(facingLeft,this);
            getWorld().addObject(weapon,getX(),getY());
        }
        if (onPlatform()){
            if (vertVelocity>0) vertVelocity = 0;
            List<Player> nearObjects = getObjectsInRange(450,Player.class);
            if (nearObjects.size()>0){
                Player p = nearObjects.get(0);
                //if player is further right than monkey
                if (p.getX()>getX()){
                    horzVelocity=MOVE_SPEED;
                }else{
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
            }
        }
        
        collideMoveLocation(horzVelocity,vertVelocity);
    }
    
    private void hop(){
        if(onPlatform()){
            vertVelocity = HOP_SPEED;
        }
    }
}
