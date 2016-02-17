import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PhysicsTestWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PhysicsTestWorld extends ExtendedWorld
{

    /**
     * Constructor for objects of class PhysicsTestWorld.
     * 
     */
    public PhysicsTestWorld()
    {
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
        
        

        
        addObject(new TrackEnemy(),600,100);
        addObject(new DumbEnemy(),50,500);
    }
}
