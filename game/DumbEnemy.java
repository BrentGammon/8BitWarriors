import greenfoot.*;

/**
 * DumbEnemy will move left and right while in contact with the terrian.
 * 
 * @author Brent Gammon 
 * @version 0.1
 */
public class DumbEnemy extends Entity implements IDamageable,IFalling
{
    private int health = 2;
    private int speed = 5;
    private int vertVelocity = 0;
    protected boolean goLeft = false;
    
    private boolean hit = false;
    /**
     * Act - do whatever the DumbEnemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pre ssed in the environment.
     */
    public void act() 
    {
        moving(); 
        Actor a = getOneIntersectingObject(Player.class);
        if (a != null){
            Greenfoot.setWorld(new World1());
            return;
        }
    }   
    
    /**
     * This will check the results of different logic methods to see what movment the object should do under certain scenario
     */
    public void moving()
    {
        if(onPlatform()&&!isAtEdge()&&endPlatform()){
            direction();
        }
        if(onPlatform()&&!isAtEdge()&&!endPlatform()){
            changeDirection();
            direction();
        }
        if(onPlatform()&&isAtEdge()&&endPlatform()){
            changeDirection();
            direction();
        }
    }
    
    /**
     * When invoked it will flip the boolean value for goLeft
     */
    public void changeDirection()
    {
        if(goLeft){
            goLeft = false;
        }else{
            goLeft = true;
        }
    }
    
    /**
     * Move the object 1 pixel direction will depend on the value of goLeft
     */
    public void direction()
    {
        if(!goLeft){
            move(1);
        }else{
            move(-1); 
        }
    }
    
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

    public int doDamage(Actor attacker, int damage){
        health -= damage;
        if (health<=0)die();
        return damage;
    }
    
    public boolean die(){
        getWorld().addObject(new DeadEntity(getImage()),getX(),getY());
        return super.die();
    }
}
