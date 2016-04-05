import greenfoot.*;
import java.util.*;
/**
 * This object this the boss enemey for the game, this is able to spawn rocks ontop of the player
 * @author Brent Gammon
 * @version S3 3/4/16
 */
public class BossEnemy extends Entity implements IDamageable
{
    private int health = 10;
    private boolean shield = false;
    private int cooldown = 60;
    private GreenfootImage sprite = new GreenfootImage("boss.png");
    private int rangeBarrer = 5;
    private int thisX;
    private int thisY;
    private boolean spawnShield = false;

    private Healthbar healthbar;
    private int iframes=0;
    private GreenfootSound attackSound = new GreenfootSound("AttackHitSound.wav");
    /**
     * Constructor for BossEnemy
     * @param int x the x position of the object
     * @param int y the y position of the object
     */
    public BossEnemy(int x,int y)
    {
        thisX = x;
        thisY = y;
        setImage(sprite);
    }

    public void addedToWorld(World w){
        healthbar = new Healthbar(health,this,40);
        w.addObject(healthbar,getX(),getY()-10);
    }

    /**
     * Act - do whatever the BossEnemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (getExtendedWorld().isPaused()) return;
        if (iframes>0){

            if(iframes%10<5){
                setImage(SpriteHelper.makeWhite(sprite));
            }else{
                setImage(sprite);
            }
            iframes--;
        }else{
            setImage(sprite);
        }
        List<Actor>actors = getObjectsInRange(500,Player.class);
        if(actors.size()>0){
            Player p = (Player) actors.get(0);
            if(cooldown==60){
                RockPortal portal = new RockPortal();
                getWorld().addObject(portal,p.getX(),p.getY()-200);
            }
        }
        List<EnemyShield> nearObjects = getWorld().getObjects(EnemyShield.class);
        if(nearObjects.size()>0 && spawnShield==false ){
            shield = true;
            spawnShield = true;
            getWorld().addObject(new BossShield(),getX(),getY());
        }
        if(nearObjects.size()==0)
        {
            shield = false;
            List<BossShield> bossShield = getWorld().getObjects(BossShield.class);
            if(bossShield.size()>0){
                BossShield bs = (BossShield) bossShield.get(0);
                bs.removeObject();
            }
        }
        cooldown--;
        if(cooldown ==0){
            cooldown = 60;
        }
    }   

    /**
     * When called this will increment the score counter and add DeadEntity to the world
     * @return a super call to die
     */
    public boolean die(){
        Counter.add(500);
         healthbar.remove();
        getWorld().addObject(new DeadEntity(getImage()),getX(),getY());
        getWorld().addObject(new ScoreIndicator(500), getX(),getY());
        return super.die();
    }

    /**
     * does damage to the Actor attacter
     *@param Actor attacker the object thats damage is occuring 
     *@param int damage  the amount of damage
     */
    public int doDamage(Actor attacker, int damage){
        if(iframes==0){
            if(shield == false){
                health -= damage;
                healthbar.setHealth(health);
                MuteControl.playSound(attackSound);
                iframes = 20;

                if (health<=0) die();
            }
            return damage;
        }else return 0;
    }

    /**
     * Gets the value of thisY
     * @return int thisY
     */
    public int getBossY(){
        return thisY;
    }

    /**
     * Gets the value of the Y position
     * @return int the value of the object Y postition
     */
    public int getBossyy(){
        return getY();
    }

    /**
     * Gets the value of the X position
     * @return int the value of the object X postition
     */
    public int getBossxx(){
        return getX();
    }

    /**
     * Gets the value of thisX
     * @return int thisX
     */
    public int getBossX()
    {
        return thisX;
    }
}
