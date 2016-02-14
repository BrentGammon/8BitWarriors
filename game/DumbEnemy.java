import greenfoot.*;

/**
 * DumbEnemy will move left and right while in contact with the terrian.
 * 
 * @author Brent Gammon 
 * @version 0.1
 */
public class DumbEnemy extends Entity
{
    private int health = 10;
    private int speed = 5;
    private int vertVelocity = 0;
    protected boolean goLeft = false;
     public static final int GRAVITY = 2; 
    /**
     * Act - do whatever the DumbEnemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        fall();
        moving(); 
        Actor a = getOneIntersectingObject(Player.class);
        if (a != null){
            Greenfoot.setWorld(new World1());
            return;
        }
    }   
    
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

    public void changeDirection()
    {
        if(goLeft){
            goLeft = false;
        }else{
            goLeft = true;
        }
    }

    public void direction()
    {
        if(!goLeft){
            move(1);
        }else{
            move(-1); 
        }
    }
    
    public void fall(){
        if (!onPlatform()){
            vertVelocity+=GRAVITY;
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

    public void getLength()
    {
        System.out.println(getImage().getWidth());
        System.out.println(getImage().getHeight());
    }   
}
