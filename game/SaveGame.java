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
 * @version S3 5/4/16
 */
public class SaveGame extends MenuItems
{
    /**
     * Contructor for SaveGame
     * This will set the image for the object
     */
    public SaveGame()
    {
        GreenfootImage image = new GreenfootImage("images/PAUSE/savebutton.png");
        setImage(image);
    }
    
    /**
     * This will check if the object has been activited by a click event 
     * this will then save the game
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
            
            //level start time
            writer.write(Integer.toString(world.getStartTime()));
            writer.write("\r\n");
            //level start score
            writer.write(Integer.toString(world.getStartScore()));
            writer.write("\r\n");
            writer.write(Player.keyBomb!=null? Player.keyBomb: "C");
           
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
