import greenfoot.*;

/**
 * This is used to allow the player to set the key binding for left
 * 
 * @author Brent Gammon
 * @version v0.1
 */
public class LeftControl extends MenuItems
{
    /**
     * Act - do whatever the LeftControl wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
         if(Greenfoot.mouseClicked(this))
       {
          //Player.keyJump = JOptionPane.showInputDialog("Jump Key");
          String x= Greenfoot.ask("Left Key");
          Player.keyLeft = x;
       }
    }    
}
