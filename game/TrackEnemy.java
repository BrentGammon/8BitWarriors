import greenfoot.*;
import java.util.*;
/**
 * Write a description of class TrackEnemy here.
 * 
 * @author Brent Gammon 
 * @version 0.1
 */
public class TrackEnemy extends ExtendedActor
{
    private List<Actor>nearObjects;
    private GreenfootImage standing;
    private GreenfootImage left1;
    private GreenfootImage left2;
    private GreenfootImage right1;
    private GreenfootImage right2;
    protected boolean goLeft = false;
    public TrackEnemy()
    {
        standing = new GreenfootImage("stripe standing.png");
        left1 = new GreenfootImage("StripeLeft1.png");
        left2 = new GreenfootImage("StripeLeft2.png");
        right1 = new GreenfootImage("StripeRight1.png");
        right2 = new GreenfootImage("StripeRight2.png");
        setImage(standing);
    }

    /**
     * Act - do whatever the TrackEnemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        int count = 0;
        nearObjects = new ArrayList<Actor>();
        nearObjects = getObjectsInRange(350,Player.class);
        
       if(endPlatform()&&onPlatform()){
            if(nearObjects != null){
                for(Actor x:nearObjects){
                    if(x instanceof Player){
                        count++;
                        System.out.println("Player Near");
                        int playerX = x.getX();
                        int playerY = x.getY();
                        int enemyX = getX();

                        if(playerX>enemyX){
                            if (getImage() == right2){
                                setImage(right1);
                            }
                            else{
                                setImage(right2);
                            }
                            move(1);
                            goLeft = false;
                        }else if(playerX<enemyX){
                            if (getImage() == left2){
                                setImage(left1);
                            }
                            else{
                                setImage(left2);
                            }
                            move(-1);
                            goLeft = true;
                        }
                    }else{
                        setImage(standing);
                    }
                }
            }
            if(count==0){
                setImage(standing);
            }   
        }
       if(!endPlatform()){
            int x = getX();
            int y = getY();
            if(goLeft){
                x=x+3;
                setLocation(x,y);
            }else{
                x=x-3;
                setLocation(x,y);
            }
        }
    }
    
    /**
     * When invoked this will flip the value of goLeft
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
     * Checks if the instance is touching the Terrain
     * @return boolean if touching return true else false
     */
    public boolean onPlatform()
    {
        if(isTouching(Terrain.class)){
            return true;
        }
        return false;
    }

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


}
