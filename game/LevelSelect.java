package game;

import greenfoot.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import javax.swing.*;
/**
 * The Level Select component on the menu
 * 
 * @author Brent Gammon 
 * @version v0.1
 */
public class LevelSelect extends MenuItems
{
    private GreenfootImage start;
    public LevelSelect(){
        start = new GreenfootImage("images/Graphics/MENUV2/M2LevelSelect.png");
        setImage(start);
    }

    /**
     * Checks if the mouse is on the object if so then the image is changed to show the player that they are on the object
     * if the object is clicked then go into the level select menu
     */
    public void act() 
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null){
            Actor actor = mouse.getActor();
            if(actor!=null){
                if(actor.equals(this)){
                    start = new GreenfootImage("images/Graphics/MENUV2/M2LevelSelectON.png");
                    setImage(start);
                }else{
                    start = new GreenfootImage("images/Graphics/MENUV2/M2LevelSelect.png");
                    setImage(start);
                }
            }
        }
        if(Greenfoot.mouseClicked(this)){
            LevelSelectMenu select = new LevelSelectMenu(getLevelAccess());
            Greenfoot.setWorld(select);
        }
    }    
    
    /**
     * When invoke this will load the save file and grap the value of the level that the player has saved at and will return it
     * @return String returns the valuefof tje save level on the external file
     * @exception level will be set to null
     */
    public String getLevelAccess()
    {
        String level = null;
        try{
            BufferedReader reader = new BufferedReader(new FileReader("SaveFile.txt"));
            level = reader.readLine();
            reader.close();
        }catch(FileNotFoundException e){
            level = null;
        }
        catch(IOException e){
            level = null;
        }
        return level;
    }
}
