import greenfoot.*;

/**
 * Load button that is on the game menu
 * 
 * @author Brent Gammon
 * @version v0.1
 */
public class Load extends MenuItems
{
    /// Add your action code here.
    private GreenfootImage start;
    /**
     * Act - do whatever the Start wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Load(){
        start = new GreenfootImage("images/Graphics/MENUV2/M2LoadGame.png");
        setImage(start);
    }   
    
    public void act() 
    {
       if(Greenfoot.mouseClicked(this)){
          System.out.println("Load button has been clicked");
       }
    }    
}
