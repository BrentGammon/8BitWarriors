import greenfoot.*;

/**
 * The background and wrapper for the hud elements
 * 
 * @author Mitchell Rebuck-Watson
 * @version S3 1
 */
public class Hud extends UI
{
    private Counter score;
    private Timer time;
    private BombCounter bomb;
    private Jump jump;
    private Ammo attack;
    private speed speed;
    private GreenfootImage hudBase;
    private int initScore, initTime;
    private Player player;
    /**
     * Main Constructor
     * 
     * @param initScore the score to initialise to
     * @param initTime the time to initialise to
     * @param player player object
     */
    public Hud(int initScore, int initTime,Player player){
        this.initScore = initScore;
        this.initTime = initTime;
        this.player = player;
        hudBase = new GreenfootImage("HUD/hudbad3.png");
        setImage(new GreenfootImage(hudBase));
    }
    @Override
    public void addedToWorld(World w){
        score = new Counter();
        time = new Timer();
        bomb = new BombCounter();
        jump = new Jump(player);
        attack = new Ammo(player);
        speed = new speed(player);
        score.setValue(initScore);
        time.setTime(initTime);
        
        getWorld().addObject(time,getX()+18,getY()-30);
        getWorld().addObject(score,getX()+18,getY()+10);
        getWorld().addObject(bomb,getX()+60,getY()+40);
        
        getWorld().addObject(jump,getX()-71,getY()+43);
        getWorld().addObject(attack,getX()-44,getY()+43);
        getWorld().addObject(speed,getX()-18,getY()+41);
    }
    /**
     * Act - do whatever the Hud wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
