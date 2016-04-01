 

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
    public static final int DAMAGE = 1;
    private GreenfootImage standing;
    private GreenfootImage left1;
    private GreenfootImage left2;
    private GreenfootImage right1;
    private GreenfootImage right2;
    private int health = 3;
    protected boolean goLeft = false;
    
    private int iframes = 0;

    private int vertVelocity = 0;

    private boolean dazed = false;
    private int dazedCounter = 0;
    private int standCounter = 0;
    private boolean stand = false;
    
    private Healthbar healthbar;
    private GreenfootSound attackSound = new GreenfootSound("AttackHitSound.wav");
    public TrackEnemy()
    {
        standing = new GreenfootImage("stripe standing.png");
        left1 = new GreenfootImage("StripeLeft1.png");
        left2 = new GreenfootImage("StripeLeft2.png");
        right1 = new GreenfootImage("StripeRight1.png");
        right2 = new GreenfootImage("StripeRight2.png");
        setImage(standing);
    }
    public void addedToWorld(World w){
        healthbar = new Healthbar(health,this,40);
        w.addObject(healthbar,getX(),getY()-10);
    }
    public int doDamage(Actor attacker, int damage){
        if( iframes==0 ){
            Attack src = (Attack)getOneIntersectingObject(Attack.class);
            collideMoveLocation(0,-1);
            horzVelocity = src==null?0:src.getDirection()?-4:4;
            health -= damage;
            healthbar.setHealth(health);
            MuteControl.playSound(attackSound);
            vertVelocity = -8;
            iframes = 20;
            if (health<=0) die();
            return damage;
        }
        else return 0;
    }

    /**
     * This contains the movement logic for TrackEnemy
     * When player is inrange it will move towards the player 
     * if it reaches the end of platform then it will move away and wait
     */
    public void act() 
    {
        if (getExtendedWorld().isPaused()) return;
        int count = 0;
        List<Player> nearObjects = new ArrayList<Player>();
        nearObjects = getObjectsInRange(350,Player.class);
        if (iframes>0){
            setImage(goLeft?left1:right1);
            if(iframes%10<5){
                setImage(SpriteHelper.makeWhite(goLeft?left1:right1));
            }else{
                setImage(goLeft?left1:right1);
            }
            iframes--;
        }else{
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
        }

        Actor a = getOneIntersectingObject(Player.class);
        if (a != null){
            ((Player)a).doDamage(this,DAMAGE);
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
     * When called this will increment the score counter and add DeadEntity to the world
     * @return a super call to die
     */
    public boolean die(){
        Counter.add(50);
        healthbar.remove();
        getWorld().addObject(new ScoreIndicator(50), getX(),getY());
        getWorld().addObject(new DeadEntity(getImage()),getX(),getY());
        getWorld().addObject(new ScoreIndicator(1), getX(),getY());
        return super.die();
    }
}

