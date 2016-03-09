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
   //private final String gameLevel = "1";
    /**
     * Constructor for objects of class World1.
     * 
     */
    public World1()
    {
        //call to superclass to use centreCameraOn function
        super(true);
        
        gameLevel = "1";
        
        WORLD_WIDTH = 20000;
        WORLD_HEIGHT = 900;
        Player p = new Player();
        //layer1_xoffset = -200;
        //layer1_yoffset = -100;
        layer1 = new GreenfootImage("images/jungleBig.png");
        
        redrawBackground();
        addObject(p,100,826);
        addObject(new Timer(),52,40);
        addObject(new Counter(),55,67);
        muteControl = new MuteControl();
        addObject(muteControl,676,29);
        addObject(new SaveGame(),750,28);
        addObject(new PowerupDisplay(p),204,97);
        
        
        //addObject(new Spikes(1),982,300);
        //addObject(new Spikes(2),868,300);
        addObject(new TrackEnemy(),2500,650);
        addObject(new Grass(20),300,885);
        addObject(new MonkeyEnemy(),700,830);
        addObject(new Grass(20),1350,885);
        addObject(new Grass(10),2375,735);
        addObject(new WoodLog(),1875,807);
        addObject(new WoodLog(),1975,807);
        addObject(new WoodLog(),2075,807);
        addObject(new PushObject(),2500,600);
        addObject(new Spikes(0),1500,840);
        addObject(new Spikes(1),1400,840);
        addObject(new Spikes(2),1300,840);
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

