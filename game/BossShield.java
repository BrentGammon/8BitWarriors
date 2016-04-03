import greenfoot.*;
import java.util.*;
/**
 * Shield prevents the player from touching the boss enemy
 * 
 * @author Brent Gammon 
 * @version S3 29/3/16
 */
public class BossShield extends Entity
{
    private GreenfootImage sprite = new GreenfootImage("bossShield.png");
    
    /**
     * Constructor for BossShield, sets the image for the object
     */
    public BossShield(){
        setImage(sprite);
    }
    
    /**
     * this will check if the player is touching the shield if so then move them away
     */
    public void act() 
    {
        List <Player> player = getWorld().getObjects(Player.class);
        if(player.size()>0){
            Player play = (Player)player.get(0);
            if(this.isTouching(Player.class)){
                int playerX = play.getX();
                int playerY = play.getY();
                if(playerX<this.getX()){
                    play.move(-10);
                }else{
                    play.move(10);
                }
            }
        }    
   }
    
    /**
     * when called this will remove the object from the world
     */
    public void removeObject(){
        getWorld().removeObject(this);
    }
}
