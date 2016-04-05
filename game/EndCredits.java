import greenfoot.*;
import java.awt.*;
import java.nio.file.Files;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Arrays;
/**
 * This world used when the player has completed the game, their stats will be presented to them 
 * the class will also contain the logic for sorting the leaderboard text file
 * 
 * @author Brent Gammon
 * @version SP3 31/3/16
 */
public class EndCredits extends ExtendedWorld
{
    public static final int GAME_WIDTH = 600;
    public static final int GAME_HEIGHT = 400;
    
    /** These int varibles will contain information about the players final time and socre for the game  */
    private int finalScore;
    private int finalTime;
    /**
     * Constructor for world of  EndCredits.
     * @param int time the overal time that will be used to displayed to player
     * @param int score the overal score that will be used to displayed to player
     */
    public EndCredits(int time,int score)
    {
        super(GAME_WIDTH,GAME_HEIGHT,false);
        finalScore = score;
        finalTime = time;
        MuteControl m = new MuteControl();
        m.stop();

        layer1 = new GreenfootImage("images/Graphics/MainMenuelements/Menu_BG.png");
        GreenfootImage back = new GreenfootImage("images/Graphics/MainMenuelements/Menu_BG.png");
        setBackground(back);
        addObject(new CreditTextDisplay(0,score,time),313,26);
        addObject(new CreditTextDisplay(1,score,time),319,71);
        addObject(new CreditTextDisplay(2,score,time),310,123);
        addObject(new CreditTextDisplay(3,score,time),311,174);
        addObject(new Home(),47,41);

    }
    
    /**
     * This method contains the logic for saving the leaderboard this will check if the leaderboard file exists, 
     * the result will afftect what methods will be called to save the file
     * @exception FileNotFound JOptionPane will display text inforamtion to the user about the error
     * @exception IO JOptionPane will display text inforamtion to the user about the error
     */
    public void highScoreSave(){
        File file = new File("highscores.txt");
        if(file.exists()){
            try{
                BufferedReader reader = new BufferedReader(new FileReader("highscores.txt"));
                int i = 0;
                int[] leaderboard;
                leaderboard = new int[6];
                String line = reader.readLine();
                while(line != null){
                    if(!(line.equals("")||line.equals(null))){
                        leaderboard[i]=Integer.parseInt(line);
                    } else{
                        leaderboard[i]=0;
                    }
                    i++;
                    line = reader.readLine();
                }
                reader.close();
                leaderboard[5] = finalScore;
                updateLeaderBoard(leaderboard);
                }catch(FileNotFoundException e){
                JOptionPane.showMessageDialog(null, "leaderboard error", "Load Error",
                    JOptionPane.ERROR_MESSAGE);
            }
            catch(IOException e){
                JOptionPane.showMessageDialog(null, "Corrputed Data", "Load Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            defaultSave();
        }
    }

    /**
     *This method creates the highsocres text file and inserts one value of the current player scores 
     */
    public void defaultSave(){
        try{
            FileWriter writer = new FileWriter("highscores.txt");
            writer.write(Integer.toString(finalScore));
            writer.close();
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error in saving leaderboard", e.toString(),
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * This will save the array containing scores to the text file highscores
     * @param int array[] the array of scores that will be updated
     * @exception IO JOptionPane will be displayed to the user saying that an error has occured
     */
    public void updateLeaderBoard(int array[]){
        int sortedArray[] = bubbleSort(array); 
        try{
            FileWriter writer = new FileWriter("highscores.txt");
            for(int i = 5;i>=1;i--){
                writer.write(Integer.toString(sortedArray[i])); 
                writer.write("\r\n");
            }
            writer.close();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error in saving leaderboard", e.toString(),
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * This method contains the bubbleSort algorithm that will be used to make sure that the array containing the scores are in order by value
     * @param int[]x the array that is going to be sorted
     * @return int[]x the array that has been passed into the method that has been sorted
     */
    public int[] bubbleSort(int[]x){
        int[] y;
        int[]p;
        for(int b= 0; b<10;b++){
            for(int i = 0; i<x.length-1;i++){
                if(x[i]>x[i+1]){
                    y = new int[1];
                    y[0]= x[i];
                    p = new int[1];
                    p[0] = x[i+1];
                    x[i+1] = y[0];
                    x[i] = p[0];
                }
            }
        }
        return x;
    }
}
