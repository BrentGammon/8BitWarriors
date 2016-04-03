 

import greenfoot.*;
import javax.swing.*;
/**
 * This is used to allow the player to set the key binding for left
 * 
 * @author Brent Gammon
 * @version v0.1
 */
public class LeftControl extends KeyBindings
{
    /**
     * Constructor for LeftControl this sets the image of the object
     */
    public LeftControl()
    {
        setImage("/Settings/left.png");
    }
    /**
     * When the object has been clicked it will ask the player to input a string value this value will be stored as a keybinding for left movement
     */
    public void act() 
    {
       if(Greenfoot.mouseClicked(this))
        {
            String x= Greenfoot.ask("Left Key");
            if(validKey(x)){
                if(!(keyInUse(x))){
                    Player.keyLeft = x;
                }else{
                    JOptionPane.showMessageDialog(null, "Key already in use", "Input a key that is not in use",
                    JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Not a Valid Key", "Input a valid key",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }    
}
