 

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.TextField;
/**
 * Write a description of class World2 here.
 * 
 * @author (Viktor) 
 * @version (1.2v)
 */
public class World2 extends ExtendedWorld
{
   boolean begin;
   private MuteControl muteControl;
   //private int startScore;
   //private int startTime;
   //private final String gameLevel = "2";
    /**
     * Constructor for objects of class World2.
     * 
     */
    public World2(int score, int time)
    {
        //call to superclass to use centreCameraOn function
        super(true);
        startScore = score;
        startTime = time;
        
        Timer timer = new Timer();
        timer.setTime(time);
        Counter counter = new Counter();
        counter.setValue(score);
        counter.updateImage();
        
        addObject(timer,52,35);
        addObject(counter,55,67);
        
        
        gameLevel = "2";
        
        WORLD_WIDTH = 20000;
        WORLD_HEIGHT = 900;
        Player p = new Player();
        //PowerupDisplay pd = new PowerupDisplay();
        //pd.setPlayer(p);
        //layer1_xoffset = -200;
        //layer1_yoffset = -100;
        layer1 = new GreenfootImage("images/jungleBig.png");
        
        redrawBackground();
        addObject(p,100,826);
       
        muteControl = new MuteControl();
        muteControl.play();
        addObject(muteControl,300,16);
        addObject(new SaveGame(),450,16);
        
        addObject(new speed(p),320,67);
        addObject(new Ammo(p),400,67);
        addObject(new Jump(p),470,67);
        
        
        //addObject(pd,122,40);
        addObject(new Grass(20,2),301,885);
        addObject(new Grass(20,2),1350,885);
        addObject(new DumbEnemy(),700,825);
        addObject(new DumbEnemy(),696,825);
        //addObject(new Moveable(), 500, 500);
    }
    
    //gets the game level and returns it
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
    //     
    //     public int getStartScore(){
    //         return startScore;
    //     }
    //     
    //     public int getStartTime(){
    //         return startTime;
    //     }
    
   
}

