package game;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Class represents any Moving object that actually is in the world. Has velocity and contains methods that
 * impliment collision
 * 
 * @author Mitchell Rebuck-Watson 
 * @version S2 1
 */
public abstract class Entity extends ExtendedActor
{
    //http://codereview.stackexchange.com/questions/26697/best-way-to-get-the-smallest-possible-integer-ratio-between-two-numbers
    /** Object velocity*/
    protected int vertVelocity=0;
    protected int horzVelocity=0;

    /**
     * Returns the objects current horizontal velocity
     * 
     * @return horizontal velocity
     */
    public int getHorzVelocity(){
        return horzVelocity;
    }
    /**
     * Returns the objects current vertical velocity
     * 
     * @return vertical velocity
     */
    public int getVertVelocity(){
        return vertVelocity;
    }
    /**
     * Checks whether or not the actor has reached the end of the platform it is currently on
     * 
     * @return is the bottom center position of the actor empty
     */
    public boolean endPlatform()
    {
        int xPost = getX()+5;
        Actor actor = getOneObjectAtOffset(0,getImage().getHeight()/2,Terrain.class);
        if(actor instanceof Terrain){
            return true;
        }else{
            return false;
        }
    }
    /**
     * Checks whether there is space in the direction specified direction
     * 
     * @return is there any Terrain one pixel in direction
     */
    public boolean directionBlocked(String direction){
        final int ow = getWidth()/2;
        final int oh = getHeight()/2;
        int x = direction.equals("left")?-ow-1:ow+1;
        for (int i=-oh+1;i<oh;i++){
                //getWorld().addObject(new Particle(2),x+getX(),i+getY());
                if (getOneObjectAtOffset(x,i,Terrain.class)!=null ){
                    return true;
                }
            }
        return false;
    }
    /**
     * Checks whether there is any space above the actor.
     * 
     * @return is there any terrain one pixel above
     */
    public boolean upBlocked(){
        final int ow = getWidth()/2;
        final int oh = getHeight()/2;
        int y = -oh-1;
        for (int i=-ow+1;i<ow;i++){
            Actor a = getOneObjectAtOffset(i,y,Terrain.class);
            Terrain t = (Terrain)a;
            if (a!=null && !(t instanceof IPlatform)){
                return true;
            }
        }
        return false;
    }
    /**
     * Is the entity on a platform. Is false when the entity is moving upwards
     * 
     * @return is touching platform
     */
    public boolean onPlatform()
    {
        //
        if (vertVelocity<0) return false;
        final int o = getWidth()/2;
        
        for (int i=-o;i<-o+getWidth();i++){
            //getWorld().addObject(new Particle(2),i+getX(),getHeight()/2+getY()+1);
            Actor a = getOneObjectAtOffset(i,getHeight()/2+1,Terrain.class);
            Terrain t = (Terrain)a;
            if (a!=null && t.canSupportEntity(this)){
                return true;
            }
        }
        return false;
    }  

    /**
     * Attempt to move location by specified amount and resolve any resulting collisions
     * basic algorith was learned from http://gamedev.stackexchange.com/questions/18302/2d-platformer-collisions
     * but has been significantly changed for use in a 2d platformer
     * 
     * @param dx change in x position
     * @param dy change in y position
     * 
     * @return whether the entity collided or not
     */
    public boolean collideMoveLocation(int dx, int dy){
        //move enity
        moveLocation(dx,dy);
        List<Terrain> c = getIntersectingObjects(Terrain.class);
        //if actually moved and collided with something
        if (c.size()>0&&(dx!=0||dy!=0)){
            //for every Terrain thats collided with
            for (Terrain t:c){
                // if terrain is a platform and entity is moving up skip ignore it
                if (t instanceof IPlatform && dy<=0) continue;
                // set sub unit to jump object when attempting to uncollide (move in the inverse of direction travelled
                int cx = dx!=0?dx/Math.abs(dx):1;
                int cy = dy!=0?dy/Math.abs(dy):1;
                
                //store current position
                int x = getX();
                int y = getY();
                //find y penetration (move vertically till free
                int ypen = 0;
                while (intersects(t)){
                    ypen++;
                    //System.out.println("cx: "+cx+", cy: "+cy+", x: "+getX()+", y: "+getY());
                    moveLocation(0,-cy);
                }
                //if was actually moving sideways ( need to check horizontal pen )
                if (dx!=0 && !(t instanceof IPlatform) ){
                    //store position at end of ypen test and move back
                    int ypen_x = getX();
                    int ypen_y = getY();
                    setLocation(x,y);
                    
                    //find x penetration
                    int xpen = 0;
                    while (intersects(t)){
                        xpen++;
                        //System.out.println("cx: "+cx+", cy: "+cy+", x: "+getX()+", y: "+getY());
                        moveLocation(-cx,0);
                    }
                    
                    System.out.println("Collision! xpen"+xpen+" dx"+dx+" ypen"+ypen+" dy"+dy);
                    // if x penetration was greater than distance moved (thats invalid) and ypenetration was
                    // less than x penetration and the y penetration was valid
                    // resolve in y dimension
                    if ( xpen>Math.abs(dx) && (ypen<xpen) || ypen<=Math.abs(dy) ) setLocation(ypen_x,ypen_y);
                    //if x penetration is also invalid leave object in collided state
                    else if ( xpen>Math.abs(dx)){
                        System.out.println("Could not resolve x");
                        setLocation(x,y);
                    }
                }else if ( ypen>Math.abs(dy) ){
                    //if ypenetration was invalid move leave object in collided state
                    setLocation(x,y);
                    System.out.println("Could not resolve y");
                }else System.out.println("Collision! ypen"+ypen+" dy"+dy);
            }
            return true;
        }
        return false;
    }
    /**
     * Apply gravity to the entities vertical velocity. Will set vertical velocity to 0 if it is on a platform
     * 
     * @param g Gravity to apply
     */
    public void fall(int g){
        if (!onPlatform()){
            vertVelocity+=g;
        }else{
            vertVelocity = 0;
        }
    }
    /**
     * Kill this entity
     * 
     * @return did the entity die successfully
     */
    public boolean die(){
        //remove this entity from the world
        getWorld().removeObject(this);
        return true;
    }
}
