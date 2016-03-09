import greenfoot.*;

/**
 * DumbEnemy will move left and right while in contact with the terrian.
 * @author Brent Gammon 
 * @version 0.1
 */
public class DumbEnemy extends Entity implements IDamageable,IFalling
{
    private static final int DAMAGE = 1;
    private int health = 2;
    private int speed = 5;
    private int vertVelocity = 0;
    protected boolean goLeft = false;
    private boolean hit = false;
    /**
     * Act - do whatever the DumbEnemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pre ssed in the environment.
     */
    
    public DumbEnemy(){
      
    }
    
    public void act() 
    {
        if (getExtendedWorld().isPaused()) return;
        moving(); 
        /*if player object has interacted with enemy, then remove its weapon, remove player, freeze the timer,
         * and display the gameover image by adding an object of it to the world
        */
        Actor a = getOneIntersectingObject(Player.class);
        if (a != null){
            ((Player)a).doDamage(this,DAMAGE);
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
    
    /**
     * Doe damage to the actor that has been passed into the paramter
     * @param Actor attacker the actor that is going to have damage done to them
     * @param int damage the strength of the damage
     * @return int damage the amount done to the actor
     */
    public int doDamage(Actor attacker, int damage){
        health -= damage;
        if (health<=0){
            die();
        }
        return damage;
    }
    
    /**
     * When called this will increment the score counter and add DeadEntity to the world
     * @return a super call to die
     */
    public boolean die(){
        Counter.add();
        getWorld().addObject(new DeadEntity(getImage()),getX(),getY());
        return super.die();
    }
}
