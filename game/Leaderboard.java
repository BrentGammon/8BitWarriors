import greenfoot.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import javax.swing.*;
/**
 * This world will display the leaderboard scores to the player
 * 
 * @author Brent Gammon 
 * @version S3 1/4/16
 */
public class Leaderboard extends ExtendedWorld
{
    public static final int GAME_WIDTH = 600;
    public static final int GAME_HEIGHT = 800;
    /**
     * Constructor for objects of class Leaderboard.
     */
    public Leaderboard()
    {
        super(GAME_HEIGHT,GAME_WIDTH,false); 
        
        layer1 = new GreenfootImage("images/Graphics/MainMenuelements/Menu_BG.png");
        setBackground("images/Graphics/MainMenuelements/Menu_BG.png");
        
        addObject(new CreditTextDisplay("Leaderboard",60),420,49);
        addObject(new Home(),65,50);
        generateTable();
    }
    
    /**
     * Generate the world with the scores from the text file
     * @exception FileNotFound displays message in the world that displays that no scores are reocrded 
     * @exception IO JOptionPane displays error message to the player
     */
    public void generateTable()
    {
        String[] loadData;
        loadData = new String[5];
        try{
            BufferedReader reader = new BufferedReader(new FileReader("highscores.txt"));
            int i = 0;
            String line = reader.readLine();
            while(line != null){
                loadData[i]=line;
                i++;
                line = reader.readLine();
            }
            reader.close();
            int yPost = 140;
            for(int x =0;x<loadData.length;x++){
                addObject(new CreditTextDisplay(x+1),375,yPost);
                showText(": ",415,yPost);
                addObject(new CreditTextDisplay(Integer.parseInt(loadData[x])),455,yPost);
                yPost+=40;
            }
        }catch(FileNotFoundException e){
            addObject(new CreditTextDisplay("No Scored Recorded",40),375,140);
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error Generating Leaderboard", "Load Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
}
