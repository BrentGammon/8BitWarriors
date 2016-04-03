
import greenfoot.*;
import java.util.*;
/**
 * This is the super class for Moveable objects in the game. All objects that are pushable by the player will extend this class
 * 
 * @author Brent & Sharaz
 * @version v0.1
 */
public abstract class Moveable extends Entity
{ 
    //sharaz, if player not on platform(jumps and land on object), stop moving
    protected boolean stop = false;
    /**
     * This method will get the player coordinates and when the player touches the object it will calulate the movement that the objects needs to do from those values  
     */
    public void isPushed()
    {

        List<Player> nearObjects = new ArrayList<Player>();
        nearObjects = getObjectsInRange(350,Player.class);
        if(nearObjects!=null){
            for(Actor x:nearObjects){
                if(x instanceof Player){
                    Player p = (Player) x;
                    int playerX = x.getX();
                    int playerY = x.getY();
                    int objectX = getX();
                    //sharaz, !stop ensures that object doesnt move when player jumps and lands on it - bug fix
                    if(playerX>objectX && !stop){
                        if(isTouching(Player.class)){
                            //sharaz, fix bug - when player has speed boost, object moves relative to player speed using its horizontal velocity
                            collideMoveLocation((p.horzVelocity),0);
                        }
                    }
                    else if(playerX<objectX && !stop){
                        if(isTouching(Player.class)){

                            collideMoveLocation((p.horzVelocity),0);
                        }
                    }
                }
            }
        }
    }
}
