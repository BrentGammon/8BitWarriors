import greenfoot.*;

/**
 * Write a description of class RangeEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RangeEnemy extends Entity implements IFalling
{
    private boolean facingLeft;
    private int cooldown = 45;
    private BulletAttack weapon;
    public RangeEnemy(boolean facingLeft){
        this.facingLeft = facingLeft;
    }
    
    /**
     * Act - do whatever the RangeEnemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (cooldown==45){
            weapon = new BulletAttack(facingLeft,this);
            getWorld().addObject(weapon,getX(),getY());
        }
        
        cooldown--;
        if(cooldown==0){
            cooldown=45;
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
