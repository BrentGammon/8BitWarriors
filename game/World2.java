import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.TextField;
/**
 * Write a description of class World1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World2 extends ExtendedWorld
{
   boolean begin;
   private MuteControl muteControl;
   //private final String gameLevel = "1";
    /**
     * Constructor for objects of class World1.
     * 
     */
    public World2()
    {
        //call to superclass to use centreCameraOn function
        super(true);
        
        gameLevel = "2";
        
        WORLD_WIDTH = 20000;
        WORLD_HEIGHT = 900;
        Player p = new Player();
        //layer1_xoffset = -200;
        //layer1_yoffset = -100;
        layer1 = new GreenfootImage("images/jungleBig.png");
        
        redrawBackground();
        addObject(p,100,826);
        addObject(new Timer(),52,16);
        addObject(new Counter(),133,16);
        muteControl = new MuteControl();
        addObject(muteControl,300,16);
        addObject(new SaveGame(),450,16);
        addObject(new PowerupDisplay(p),122,40);
        
        
        addObject(new Grass(20),301,885);
        addObject(new Grass(20),1350,885);
        addObject(new DumbEnemy(),700,825);
        addObject(new DumbEnemy(),696,825);
    }
    
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
        if (!isPaused())    muteControl.play();
    }
}
