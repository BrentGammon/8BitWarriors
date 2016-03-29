import greenfoot.*;

/**
 * Write a description of class RockPortal here.
 * 
 * @author Brent Gammon 
 * @version S3 29/3/16
 */
public class RockPortal extends Entity
{
    int timer = 20;
    boolean generate = true;
    private GreenfootImage sprite = new GreenfootImage("portal.png"); 
    
    /**
     * Constructor for RockPortal 
     */
    public RockPortal()
    {
      setImage(sprite);  
    }
    
    
    /**
     * Act - do whatever the RockPortal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(timer ==0){
            getWorld().removeObject(this);
        }
        if(generate){
              getWorld().addObject(new RockAttack(true,this),getX(),getY());
              generate = false;
        }
        timer--;
    }    
}
