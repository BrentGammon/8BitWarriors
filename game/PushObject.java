 

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * This objects is able to be pushed by the player when in the world.
 * 
 * @author Brent & Sharaz
 * @version v0.1
 */
public class PushObject extends Moveable implements IFalling
{
    
    public void act() 
    {
        setImage("cube.png");
        isPushed();
        if (collideMoveLocation(0,vertVelocity)&&onPlatform()){
            vertVelocity = 0;
        }
        
        //sharaz,create empty list of actors
       List<Actor> aList = new ArrayList<Actor>();
       //sharaz,return all objects that touch this object and store into list
        aList = getIntersectingObjects(null);
        
        if(aList != null){
            //sharaz,loop all touching objects
            for(Actor a: aList){
                //sharaz,if touching actor is player then..
            if(a instanceof Player){
                
            Player p = (Player) a;
            //p.setLocation(p.getX(), getImage().getHeight()); 
            //p.vertVelocity = 0;
            
            
            //sharaz,if player isnt on platform and touching object, tell object to stop moving
            if(!(p.onPlatform())){
                super.stop = true;
            }
            else{super.stop = false;}
            //sharaz,bug fix- if player wants to jump then mimix pushobject like terrain and let them jump
            if(Greenfoot.isKeyDown("up")){
               p.onPushObject = true;
            }
            else{p.onPushObject = false;}
            
        }
        //sharaz,if touching actor is basic attack, give it a vertical velocity of 0, i.e stop falling(gravity);
        if(a instanceof  BasicAttack){
            BasicAttack b = (BasicAttack) a;
            b.vertVelocity=0;
        }
        }
        }
    }    
}
