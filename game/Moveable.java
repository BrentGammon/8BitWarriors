package game;

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
                    int playerX = x.getX();
                    int playerY = x.getY();
                    int objectX = getX();
                    if(playerX>objectX){
                        if(isTouching(Player.class)){
                            move(-10);
                        }
                    }else if(playerX<objectX){
                        if(isTouching(Player.class)){
                            move(10);
                        }
                    }
                }
            }
        }
    }
    
    /**
     * When the object is not on the platform then the object will fall  
     * @param int g This is the gravity of the object falling
     */
    public void fall(int g){
        if (!onPlatform()){
            vertVelocity+=g;
            if(vertVelocity>0){
                for(int i=0;i<vertVelocity;i++){
                    moveLocation(0,1);
                    if (!getIntersectingObjects(Terrain.class).isEmpty()){
                        vertVelocity = 0;
                    }
                }
            } else if(vertVelocity>0){
                for(int i=0;i>vertVelocity;i--){
                    moveLocation(0,-1);
                    if (!getIntersectingObjects(Terrain.class).isEmpty()){
                        vertVelocity = 0;
                    }
                }
            }
        }else{
            vertVelocity = 0;
        }
    }
}
