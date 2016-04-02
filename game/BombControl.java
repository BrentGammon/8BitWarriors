import greenfoot.*;
import javax.swing.*;
/**
 * This is used to allow the player to set the key binding for attack
 * 
 * @author Mitchell Rebuck-Watson
 * @version S3 1
 */
public class BombControl extends KeyBindings
{
    /**
     * Construtor for AttackControl
     * Will set the image of the object
     */
    public BombControl()
    {
        setImage("/Settings/Bomb.png");
    }

    /**
    * When the object has been clicked it will ask the player to input a string value this value will be stored as a keybinding for attack
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            String x= Greenfoot.ask("Bomb Key");
            if(validKey(x)){
                if(!(keyInUse(x))){
                    Player.keyBomb = x;
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
