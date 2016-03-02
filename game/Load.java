import greenfoot.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import javax.swing.*;
/**
 * This class will will be used for loading the game inforamtion from the save file 
 * 
 * @author Brent Gammon
 * @version v0.1
 */
public class Load extends MenuItems
{
    private GreenfootImage start;
    /**
     * Act - do whatever the Start wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Load(){
        start = new GreenfootImage("images/Graphics/MENUV2/M2LoadGame.png");
        setImage(start);
    }   

    public void act() 
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null){
            Actor actor = mouse.getActor();
            if(actor!=null){
                if(actor.equals(this)){
                    start = new GreenfootImage("images/Graphics/MENUV2/M2LoadGameON.png");
                    setImage(start);
                }else{
                    start = new GreenfootImage("images/Graphics/MENUV2/M2LoadGame.png");
                    setImage(start);
                }
            }
        } 
        if(Greenfoot.mouseClicked(this)){
            loadGame();
        }
    }    
    
    /**
     * 
     */
    public void loadGame()
    {
        String[] data;
        data = new String[4];
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
        
        Player.keyJump = upMove;
        Player.keyLeft = leftMove;
        Player.keyRight = rightMove;
        
        World world = getWorld();
        ExtendedWorld worlds;
        switch (Integer.parseInt(level)){
            case 1:   worlds = new World1();
                        break;
           //UNCOMMENT WHEN LEVELS ARE IMPLEMENTED INTO THR GAME             
           // case "2":   World2 world = new World2();
           //             break;
           // case "3":   World3 world = new World3();
           //             break;
           default:     worlds = new World1();
                        break;
        }
        Greenfoot.setWorld(worlds);
    }
}
