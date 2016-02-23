import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class World1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World1 extends ExtendedWorld
{
   // private GreenfootSound backgroundMusic = new GreenfootSound("lilwayne.wav");
   boolean begin;
 
    /**
     * Constructor for objects of class World1.
     * 
     */
    public World1()
    {
        WORLD_WIDTH = 1920;
        Player p = new Player();
        
        layer3 = new GreenfootImage("images/bliss.jpg");
        
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
    }
    
    public void started()
    {
        addObject(new MuteControl(),700,50);
        
    }
    
    /*public void stopped()
    {
        removeObject(MuteControl);
    }*/
}

