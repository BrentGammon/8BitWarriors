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
    /**
     * Constructor for objects of class World1.
     * 
     */
    public World1()
    {
        //call to superclass to use centreCameraOn function
        super(true);
        
        
        WORLD_WIDTH = 1920;
        Player p = new Player();
        //layer1_xoffset = -200;
        //layer1_yoffset = -100;
        layer1 = new GreenfootImage("images/jungleBig.png");
        
        redrawBackground();
        addObject(p,100,100);
        addObject(new Grass(6),135,300);
        addObject(new Grass(11),600,300);
        addObject(new Wall(),190,240);
        // for(int i =50;i<=950;i+=50){
            // if(!(i==300||i==350)){
                // addObject(new Grass(),i,300);
            // }
        // }
        addObject(new Grass(20),450,600);
        // for(int i =50;i<=1100;i+=50){
                // addObject(new Grass(),i,600);
        // }
        
        

        addObject(new Timer(),100,150);
        addObject(new Powerup(1),200,100);
        addObject(new PowerupDisplay(),170,100);
        addObject(new TrackEnemy(),600,100);
        addObject(new TrackEnemy(),650,100);
        addObject(new TrackEnemy(),700,100);
        
        addObject(new DumbEnemy(),50,500);
        //addObject(new MuteControl(),700,500);
       addObject(new Moving(), 300, 450);
        /*if(begin){
            addObject(new MuteControl(),700,50);
        }*/
        //addObject(new MuteControl(),700,50);
        addObject(new Counter(),100,50);
        muteControl = new MuteControl();
        addObject(muteControl,700,50);
       // addObject(new UPControl(),100,20);
        
       // addObject(new TextField("", 20),100,100);
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

