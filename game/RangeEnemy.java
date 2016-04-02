import greenfoot.*;

/**
 * This class will damage the player by shooting arrows in the direction that it is facing
 * 
 * @author Brent Gammon 
 * @version S3 29/3/16
 */
public class RangeEnemy extends Entity implements IFalling, IDamageable
{
    private boolean facingLeft;
    private int health = 3;
    private int cooldown = 45;
    private BulletAttack weapon;
    private GreenfootImage sprite = new GreenfootImage("Graphics/Characters/Antagonist Characters/Enemywithbow.png");
    private Healthbar healthbar;
    /**
     * The constructor of RangeEnemy
     * @param boolean facingLeft the direction that the object is facing
     */
    public RangeEnemy(boolean facingLeft){
        if(facingLeft==false){
            sprite.mirrorHorizontally();
        }
        setImage(sprite);
        this.facingLeft = facingLeft;
    }
    public void addedToWorld(World w){
        healthbar = new Healthbar(health,this,40);
        w.addObject(healthbar,getX(),getY()-10);
    }
    /**
     * This will cause the object to fire its weapon when its able to do so 
     */
    public void act() 
    {
        if (cooldown==45){
            weapon = new BulletAttack(facingLeft,this);
            getWorld().addObject(weapon,getX()-7,getY()+7);
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
    
    /**
     * When called this will increment the score counter and add DeadEntity to the world
     * @return a super call to die
     */
    public boolean die(){
        //scoreboard incremented by one
        Counter.add(100);
        healthbar.remove();
        getWorld().addObject(new DeadEntity(getImage()),getX(),getY());
        getWorld().addObject(new ScoreIndicator(100), getX(),getY());
        return super.die();
    }
    
    /**
     * Doe damage to the actor that has been passed into the paramter
     * @param Actor attacker the actor that is going to have damage done to them
     * @param int damage the strength of the damage
     * @return int damage the amount done to the actor
     */
    public int doDamage(Actor attacker, int damage){
        health -= damage;
        // MuteControl.playSound(attackSound);
        healthbar.setHealth(health);
        if (health<=0){
            die();
        }
        return damage;
    }
}
