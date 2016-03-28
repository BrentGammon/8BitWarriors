import greenfoot.*;

/**
 * Write a description of class World3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World3 extends ExtendedWorld
{
   boolean begin;
   private MuteControl muteControl;
   //private final String gameLevel = "2";
    /**
     * Constructor for objects of class World2.
     * 
     */
    public World3()
    {
        //call to superclass to use centreCameraOn function
        super(true);
        
        gameLevel = "3";
        
        WORLD_WIDTH = 20000;
        WORLD_HEIGHT = 900;
        Player p = new Player();
        //layer1_xoffset = -200;
        //layer1_yoffset = -100;
        layer1 = new GreenfootImage("images/jungleBig.png");
        
        redrawBackground();
        addObject(p,100,826);
        addObject(new Wall(30),15,779);
        addObject(new Timer(),52,40);
        addObject(new Counter(),55,67);
        muteControl = new MuteControl();
        addObject(muteControl,676,29);
        addObject(new SaveGame(),750,28);
        addObject(new PowerupDisplay(p),204,97);
        
        // add 300 to second value
        //400 to first value from the cam x
        addObject(new Grass(20),301,885);
        addObject(new Grass(20),751,815);
        
        addObject(new WoodLog(),1300,790);
        addObject(new WoodLog(),1300,690);
        addObject(new WoodLog(),1300,590);
        addObject(new WoodLog(),1300,490);
        
        
        addObject(new RangeEnemy(false),1500,530);
        addObject(new Grass(5),1500,590);
        
        addObject(new Grass(5),1000,490);
        
        //addObject(new WoodLog(),800,490);
        //addObject(new WoodLog(),800,440);
        addObject(new WoodLog(),800,390);
        addObject(new WoodLog(),662,310);
        
        addObject(new Grass(10),260,360);
        addObject(new WoodLog(),300,221);
        
        
        //addObject(new WoodLog(),50,190);
        //addObject(new WoodLog(),50,90);
        //addObject(new WoodLog(),30,90);
        
        
         addObject(new Grass(30),1072,152);
         
         
         addObject(new Wall(12),1885,324);
         addObject(new Wall(11),1769,502);
         addObject(new Grass(10),1972,896);
         addObject(new Grass(30),2981,896);
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
        if (!isPaused()){
            if(!(muteControl.getIsMuted())){
                muteControl.play();
            }
            
        }
    }
}
