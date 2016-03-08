import greenfoot.*;
import javax.swing.*;
/**
 * Write a description of class AttackControl here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AttackControl extends KeyBindings
{
    public AttackControl()
    {
        setImage("swordKey.png");

    }

    /**
     * Act - do whatever the AttackControl wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            String x= Greenfoot.ask("Attack Key");
            if(validKey(x)){
                if(!(keyInUse(x))){
                    Player.keyAttack = x;
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
