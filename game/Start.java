import greenfoot.*;

/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends MenuItems
{
    private GreenfootImage start;
    /**
     * Act - do whatever the Start wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Start(){
        start = new GreenfootImage("images/Graphics/MENUV2/M2StartGame.png");
        setImage(start);
    }
    
    
    public void act() 
    {
        // Add your action code here.
         if(Greenfoot.mouseClicked(this))
       {
          World world = getWorld();
          World1 world1 = new World1();
          Greenfoot.setWorld(world1);
       }
    }    
}
