import greenfoot.*;
import javax.swing.*;
/**
 * Write a description of class UPControl here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UPControl extends Actor
{
    /**
     * Act - do whatever the UPControl wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
       {
          Player.keyJump = JOptionPane.showInputDialog("Jump Key");
          
       }
    }    
}
