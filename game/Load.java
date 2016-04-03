import greenfoot.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import javax.swing.*;
/**
 * This class will will be used for loading the game infomation from the save file 
 * 
 * @author Brent Gammon
 * @version v0.1
 */
public class Load extends MenuItems
{
    private GreenfootImage start;
    private boolean selected;
    /**
     * Act - do whatever the Start wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Load(){
        start = new GreenfootImage("images/Graphics/MENUV2/M2LoadGame.png");
        setImage(start);
    }  

    /**
     * Checks if the mouse is on the object if so then the image is changed to show the player that they are on the object
     * if clicked then call the load method
     */
    public void act() 
    {
        if(isHovered()){
            if (!selected) getSound().play();
            start = new GreenfootImage("images/Graphics/MENUV2/M2LoadGameON.png");
            selected = true;
            setImage(start);
        }else{
            start = new GreenfootImage("images/Graphics/MENUV2/M2LoadGame.png");
            selected = false;
            setImage(start);
        }
        if(Greenfoot.mouseClicked(this)){
            loadGame();
        }
    }    

    /**
     * This will load data from the file SaveFile.txt
     * @exception FileNotFoundException JOptionPane will appear telling the error to the player
     * @exception IOException JOptionPane will appear telling the error to the player
     */
    public void loadGame()
    {
        String[] data;
        data = new String[8];
        try{
            BufferedReader reader = new BufferedReader(new FileReader("SaveFile.txt"));
            int i = 0;
            String line = reader.readLine();
            while(line != null){
                data[i]=line;
                i++;
                line = reader.readLine();
            }

            reader.close();
            loadDetails(data);
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "Save not found", "Load Error",
                JOptionPane.ERROR_MESSAGE);
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "Corrputed Data", "Load Error",
                JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * This will load a game world and set the keyblindings to the player depending on the string values from the array
     * @param array of String containing data about the items that ate going to be loaded into the game
     */
    private void loadDetails(String[]array)
    {
        String level = array[0];
        String upMove = array[1];
        String leftMove = array[2];
        String rightMove = array[3];
        String attack = array.length>=5?array[4]:null;
        int startTime = Integer.parseInt(array[5]);
        int startScore = Integer.parseInt(array[6]);
        String bomb = array[7];
        
        Player.keyJump = upMove;
        Player.keyLeft = leftMove;
        Player.keyRight = rightMove;
        Player.keyAttack = attack;
        Player.keyBomb = bomb;
        World world = getWorld();
        ExtendedWorld worlds;
        switch (Integer.parseInt(level)){
            case 1:   worlds = new World1();
            break;            
            case 2:   worlds = new World2(startScore,startTime);
            break;
            case 3:   worlds = new World3(startScore,startTime);
            break;
            default:     worlds = new World1();
            break;
        }
        Greenfoot.setWorld(worlds);
    }
}
