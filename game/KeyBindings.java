import greenfoot.*;
import javax.swing.*;
/**
 * Write a description of class KeyBindings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class KeyBindings extends MenuItems
{
    private final String[] validBindings = {"q","w","e","r","t","y","u","i","o","p","[","]","a","s","d","f","g","h","j","k","l",";","'","#","/",".","m","n","b","v","c","x","z","LEFT","left","RIGHT","right","UP","up","DOWN","down"};
    
    
    
    public boolean validKey(String key){
        boolean valid = false;
        for(int i=0;i<validBindings.length;i++){
            if(validBindings[i].equals(key)){
                valid = true;
            }
        }
        return valid;
    }
    
    public boolean keyInUse(String key){
        if(Player.keyJump.equals(key))return true;
        if(Player.keyLeft.equals(key))return true;
        if(Player.keyRight.equals(key))return true;
        if(Player.keyAttack.equals(key))return true;
        return false;
    }
    
    
}
