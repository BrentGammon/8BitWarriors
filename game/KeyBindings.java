import greenfoot.*;
import javax.swing.*;
/**
 * This class contains methods to check if the string value that the player has entered is vaild to use to change the keybinding
 * 
 * @author Brent Gammon
 * @version v0.1
 */
public abstract class KeyBindings extends MenuItems
{
    private final String[] validBindings = {"q","w","e","r","t","y","u","i","o","p","[","]","a","s","d","f","g","h","j","k","l",";","'","#","/",".","m","n","b","v","c","x","z","LEFT","left","RIGHT","right","UP","up","DOWN","down"};
    /**
     * Checks in the string parameter is valid by checking if it is validBindings array
     * @param String key the string that is going to be checked
     * @return boolean if the string key is a valued value to use
     */
    public boolean validKey(String key){
        boolean valid = false;
        for(int i=0;i<validBindings.length;i++){
            if(validBindings[i].equals(key)){
                valid = true;
            }
        }
        return valid;
    }
    
    /**
     * Checks if the key is not ready in use by another key binding 
     * @param String key the string value this is going to be checked
     * @return boolean if the value is being used
     */
    public boolean keyInUse(String key){
        if(Player.keyJump.equals(key))return true;
        if(Player.keyLeft.equals(key))return true;
        if(Player.keyRight.equals(key))return true;
        if(Player.keyAttack.equals(key))return true;
        return false;
    }
}
