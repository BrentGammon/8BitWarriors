import greenfoot.*;
import java.util.*;
/**
 * This object will move towards the boss enemey and visually shows to the player that the boss shiled is being powered
 * 
 * @author Brent Gammon 
 * @version SP3 1/4/16
 */
public class ShieldPower extends Entity
{
    private boolean findCoords = true;
    private int bossX;
    private int bossY;
    private int thisY;
    private int thisX;
    /**
     * Contructor for ShieldPower
     * @param int x the object x position
     * @param int y the object y position
     */
    public ShieldPower(int x, int y){
        thisY = y;
        thisX = x;
    }

    /**
     * This method checks where the boss enemy in the world
     * Moves the object towards the enemy 
     * if it intersects the remove it from the world
     */    
    public void act() 
    {
        List <Actor> bossList = getWorld().getObjects(BossEnemy.class);
        if(bossList.size()>0){
            BossEnemy be = (BossEnemy)bossList.get(0);
            bossY = be.getY();
            bossX = be.getX();
        }    
        findBoss();
        List <Actor> remove = getWorld().getObjects(BossEnemy.class);
        if(remove.size()>0){
            BossEnemy bb = (BossEnemy)remove.get(0);
            if(intersects(bb)){
                getWorld().removeObject(this);
            }
        }
    }

    /**
     * This method moves the object towards the boss enemy in the world
     */
    private void findBoss(){
        int xx = getX();
        int yy = getY();
        int tryX=0;
        int tryY=0;
        if(xx<bossX){
            tryX= 5;
        }else{
            tryX=-5;
        }
        if(yy<bossY){
            tryY=5;
        }else{
            tryY=-5;
        }
        moveLocation(tryX,tryY);
    }
}
