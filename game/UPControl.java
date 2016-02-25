import greenfoot.*;
//mport javax.swing.*;
/**
 * This is used to allow the player to set the key binding for jump UPControl here.
 * 
 * @author Brent Gammon
 * @version v0.1
 */
public class UPControl extends MenuItems
{
    /**
     * Act - do whatever the UPControl wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
       {
          //Player.keyJump = JOptionPane.showInputDialog("Jump Key");
          String x= Greenfoot.ask("Jump Key");
          Player.keyJump = x;
       }
    }    
}
