import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.TextField;
/**
 * Write a description of class World1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
        addObject(new PowerupDisplay(p),114,96);
        
        
        addObject(new Grass(20),300,885);
        addObject(new Grass(20),1350,885);
        addObject(new Grass(10),2375,735);
        addObject(new WoodLog(),1875,807);
        addObject(new WoodLog(),1975,807);
        addObject(new WoodLog(),2075,807);
        
        addObject(new DumbEnemy(),696,825);
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

