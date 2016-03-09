import greenfoot.*;
import javax.swing.*;
/**
 * This is used to allow the player to set the key binding for right
 * 
 * @author Brent Gammon 
 * @version v0.1
 */
public class RightControl extends KeyBindings
{
    /**
     * When the object has been clicked it will ask the player to input a string value this value will be stored as a keybinding for right movement
     */
    public void act() 
    {
       if(Greenfoot.mouseClicked(this))
        {
            String x= Greenfoot.ask("Right Key");
            if(validKey(x)){
                if(!(keyInUse(x))){
                    Player.keyRight = x;
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
