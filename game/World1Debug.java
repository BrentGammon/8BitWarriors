 

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.TextField;
/**
 * World that will be removed in final sprint. Serves only as a testbed for entities
 * 
 * @author Mitchell Rebuck-Watson
 * @version S2 1
 */
public class World1Debug extends ExtendedWorld
{
   boolean begin;
   private MuteControl muteControl;
   //private final String gameLevel = "1";
    /**
     * Constructor for objects of class World1.
     * 
     */
    public World1Debug()
    {
        //call to superclass to use centreCameraOn function
        super(true);
        
        gameLevel = "1";
        WORLD_WIDTH = 1920;
        Player p = new Player();
        //PowerupDisplay pd = new PowerupDisplay();
        //pd.setPlayer(p);
        layer1 = new GreenfootImage("images/jungleBig.png");
        redrawBackground();
        
        
        addObject(new Counter(),55,67);
        muteControl = new MuteControl();
        addObject(muteControl,700,50);
        addObject(new SaveGame(),750,50);
        addObject(new Timer(),52,35);
        //addObject(pd,170,100);
        addObject(p,100,100);
        
        addObject(new speed(p),320,67);
        addObject(new Ammo(p),400,67);
        addObject(new Jump(p),470,67);
       
        
        addObject(new Grass(6,1),135,300);
        addObject(new Grass(11,1),600,300);
        addObject(new PushObject(),190,240);
        // for(int i =50;i<=950;i+=50){
            // if(!(i==300||i==350)){
                // addObject(new Grass(),i,300);
            // }
        // }
        addObject(new Grass(20,1),450,600);
        
        // for(int i =50;i<=1100;i+=50){
                // addObject(new Grass(),i,600);
        // }
        
        

        
        addObject(new Powerup(1),200,100);
        addObject(new Powerup(0),300,500);
        
        addObject(new TrackEnemy(),600,100);
        addObject(new TrackEnemy(),650,100);
        addObject(new TrackEnemy(),700,100);
        addObject(new MonkeyEnemy(),800,100);
        
        addObject(new DumbEnemy(),50,500);
        //addObject(new MuteControl(),700,500);
        //addObject(new Moving(), 300, 450);
        /*if(begin){
            addObject(new MuteControl(),700,50);
        }*/
        //addObject(new MuteControl(),700,50);
        
       // addObject(new UPControl(),100,20);
        
        // addObject(new TextField("", 20),100,100);
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
        muteControl.stop();
    }
    /**
     * When the application has started when this World is loaded it will play the music 
     */
    public void started()
    {
        muteControl.play();
    }
    
    
}

