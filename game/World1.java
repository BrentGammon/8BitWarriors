 

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.TextField;
/**
 * First world for the game and the jungle world. Features simple design and monkeys as a themed enemy
 * 
 * @author Mitchell Rebuck-Watson
 * @version S2 1
 */
public class World1 extends ExtendedWorld
{
   boolean begin;
   private MuteControl muteControl;
   protected int WORLD_WIDTH = 10000;
   protected int WORLD_HEIGHT = 900;
   //private final String gameLevel = "1";
    /**
     * Constructor for objects of class World1.
     * 
     */
    public World1()
    {
        //call to superclass to use centreCameraOn function
        super(600,400, true);
        
        gameLevel = "1";
        Player p = new Player();
        //PowerupDisplay pd = new PowerupDisplay();
        //pd.setPlayer(p);
        //layer1_xoffset = -200;
        //layer1_yoffset = -100;
        layer1 = new GreenfootImage("images/jungleBig.png");
        
        redrawBackground();
        addObject(p,100,826);
        Timer timer = new Timer();
        timer.setTime(0);
        addObject(timer,52,35);
        addObject(new Counter(),55,67);
        muteControl = new MuteControl();
        //muteControl.play();
        addObject(muteControl,490,29);
        addObject(new SaveGame(),530,28);
        addObject(new speed(p),320,67);
        addObject(new Ammo(p),400,67);
        addObject(new Jump(p),470,67);
        //addObject(pd,55,110);
        
        addObject(new Tree(Tree.LARGE),172,650);
        
        addObject(new Tree(Tree.LARGE),586,650);
        addObject(new Tree(Tree.MED),336,811);
        addObject(new Tree(Tree.MED),436,811);
        addObject(new Tree(Tree.MED),536,811);
        addObject(new Tree(Tree.MED),636,811);
        
        
        //addObject(new Spikes(1),982,300);
        //addObject(new Spikes(2),868,300);
        addObject(new TrackEnemy(),2500,650);
        addObject(new Grass(20,1),300,885);
        addObject(new MonkeyEnemy(),700,830);
        addObject(new Grass(20,1),1350,885);
        addObject(new Grass(10,1),2375,735);
        addObject(new WoodLog(),1875,735);
        addObject(new WoodLog(),1975,735);
        addObject(new WoodLog(),2075,735);
        addObject(new PushObject(),1700,750);
        //addObject(new Spikes(0),1500,840);
        //addObject(new Spikes(1),1400,840);
        //addObject(new Spikes(2),1300,840);
        addObject(new DumbEnemy(),1350,750);
        
    }
    
	
	/**
	*Method returns the String value of gameLevel
	*@return String gameLevel
	*/
    public String getLevel()
    {
        return gameLevel;
    }
   
    
    /**
     *When the application has been paused when this World is loaded it will stop the music 
     */
    public void stopped()
    {
        super.stopped();
        muteControl.stop();
    }
    /**
     * When the application has started when this World is loaded it will play the music 
     */
    public void started()
    {
        if (!isPaused()){
            if(!(muteControl.getIsMuted())){
                muteControl.play();
            }
            
        }
    }
}

