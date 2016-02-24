import greenfoot.*;

/**
 * This is used to allow the player to set the key binding for right
 * 
 * @author Brent Gammon 
 * @version v0.1
 */
public class RightControl extends Actor
{
    /**
     * Act - do whatever the RightControl wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
         if(Greenfoot.mouseClicked(this))
       {
          //Player.keyJump = JOptionPane.showInputDialog("Jump Key");
          String x= Greenfoot.ask("Right Key");
          Player.keyRight = x;
       }
    }    
}
