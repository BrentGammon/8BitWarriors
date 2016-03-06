import greenfoot.*;
import java.util.*;
/**
 * TrackEnemy will move towards the player when they are in range.
 * 
 * @author Brent Gammon 
 * @version 0.5
 */
public class TrackEnemy extends Entity implements IFalling, IDamageable
{
    public static final int GRAVITY = 2; 
    private GreenfootImage standing;
    private GreenfootImage left1;
    private GreenfootImage left2;
    private GreenfootImage right1;
    private GreenfootImage right2;
    private int health = 1;
    protected boolean goLeft = false;

    private int vertVelocity = 0;

    private boolean dazed = false;
    private int dazedCounter = 0;
    private int standCounter = 0;
    private boolean stand = false;
    public TrackEnemy()
    {
        standing = new GreenfootImage("stripe standing.png");
        left1 = new GreenfootImage("StripeLeft1.png");
        left2 = new GreenfootImage("StripeLeft2.png");
        right1 = new GreenfootImage("StripeRight1.png");
        right2 = new GreenfootImage("StripeRight2.png");
        setImage(standing);
    }

    public int doDamage(Actor attacker, int damage){
        health -= damage;
        if (health<=0) die();
        return damage;
    }

    /**
     * Act - do whatever the TrackEnemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (getExtendedWorld().isPaused()) return;
        // Add your action code here.

        //fall();
        int count = 0;
        List<Player> nearObjects = new ArrayList<Player>();
        nearObjects = getObjectsInRange(350,Player.class);
        if(stand==false){
            if(dazed == false){
                if(endPlatform()&&onPlatform()){
                    if(nearObjects != null){
                        for(Actor x:nearObjects){
                            if(x instanceof Player){
                                count++;
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
                                    move(5);
                                    goLeft = false;
                                }else if(playerX<enemyX){
                                    if (getImage() == left2){
                                        setImage(left1);
                                    }
                                    else{
                                        setImage(left2);
                                    }
                                    move(-5);
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
            }
        }

        //Dazed Code 
        if(!endPlatform()){
            dazed = true;
            stand=false;
        }
        
        if(dazed){
            if(dazedCounter>50){
                stand=true;
            }
        }

        if(stand){
            standCounter++;
            setImage(standing);
            if(standCounter>25){
                stand=false;
                dazed=false;
                standCounter=0;
                dazedCounter=0;
            }
        }
        //if dazed move the other way
        if(stand==false){
            if(dazed){
                dazedCounter++;
                if(goLeft){
                    move(5);
                    if (getImage() == right2){
                        setImage(right1);
                    }
                    else{
                        setImage(right2);
                    }
                }else{
                    move(-5);
                    if (getImage() == left2){
                        setImage(left1);
                    }
                    else{
                        setImage(left2);
                    }
                }
            }
        }

        Actor a = getOneIntersectingObject(Player.class);
        if (a != null){
            Greenfoot.setWorld(new World1());
            return;

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

    /**
     * Checks if TrackEnemy is on the terrain
     * @return boolean true if TrackEnemy is on the terrain
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

    public boolean die(){
        getWorld().addObject(new DeadEntity(getImage()),getX(),getY());
        return super.die();
    }
}

