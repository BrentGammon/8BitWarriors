import greenfoot.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import javax.swing.*;
/**
 * This class allows the player to save what level they are on and their personal key bindings
 * 
 * @author Brent Gammon
 * @version v0.1
 */
public class SaveGame extends MenuItems
{
    public SaveGame()
    {
        GreenfootImage image = new GreenfootImage("images/saveIcon.png");
        setImage(image);
    }
    
    /**
     * Act - do whatever the SaveGame wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            saveGame();
        }
    }  

    /**
     * This function will save the following items to a external text file called SaveFile.txt
     * level that the player is currently on, values for the keybindings jump,left,right
     * @exception if an error has occured when trying to save the data to the text file
     */
    public void saveGame(){
        System.out.println("Saving the game!");
        ExtendedWorld world =(ExtendedWorld) getWorld();
        try{
            FileWriter writer = new FileWriter("SaveFile.txt");

            //level
            writer.write(world.getLevel());
            writer.write("\r\n");
            //upkey
            writer.write(upKey(Player.keyJump));           
            writer.write("\r\n");
            //leftkey
            writer.write(leftKey(Player.keyLeft));
            writer.write("\r\n");
            //rightkey
            writer.write(rightKey(Player.keyRight));
            writer.write("\r\n");
            //attackkey
            writer.write(Player.keyAttack!=null? Player.keyAttack: "x");
            writer.write("\r\n");

            
            writer.close();
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error in saving game", e.toString(),
                JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * Checks the value for the player jump movement if the player hasn't changed the value then the default will be returned else the value will be returned
     * @param String upKey The value that is used for the jump action
     * @return String value of the keyboard key to complete the action 
     */
    public String upKey(String upKey)
    {
        if(upKey==null){
            return "Space";
        }
        return upKey;
    }

    /**
     * Checks the value for the player left movement if the player hasn't changed the value then the default will be returned else the value will be returned
     * @param String leftKey The value that is used for the left action
     * @return String value of the keyboard key to complete the action 
     */
    public String leftKey(String leftKey)
    {
        if(leftKey==null){
            return "Left";
        }
        return leftKey;
    }

    /**
     * Checks the value for the player right movement if the player hasn't changed the value then the default will be returned else the value will be returned
     * @param String rightKey The value that is used for the right action
     * @return String value of the keyboard key to complete the action 
     */    
    public String rightKey(String rightKey)
    {
        if(rightKey==null){
            return "Right";
        }
        return rightKey;
    }

}
