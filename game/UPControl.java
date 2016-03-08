import greenfoot.*;
import javax.swing.*;
/**
 * This is used to allow the player to set the key binding for jump UPControl here.
 * 
 * @author Brent Gammon
 * @version v0.1
 */
public class UPControl extends KeyBindings
{
    /**
     *The act method will check if the object has been clicked by the mouse 
	 *Stores the answer from the ask to store the value to keybinding
     */
    public void act() 
    {
       if(Greenfoot.mouseClicked(this))
        {
            String x= Greenfoot.ask("Jump Key");
            if(validKey(x)){
                if(!(keyInUse(x))){
                    Player.keyJump = x;
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
