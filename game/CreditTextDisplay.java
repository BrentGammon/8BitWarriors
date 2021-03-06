import greenfoot.*;
import java.awt.*;
/**
 * This obejct is used to generate text to the world
 * 
 * @author Brent Gammon
 * @version SP3 31/3/16
 */
public class CreditTextDisplay extends MenuItems
{
    private Color white = Color.WHITE;
    private Color black = Color.BLACK;
    /**
     * Constructor CreditTextDisplay
     * @param int typeMessage this will be used to select different text to select
     * @param int score this is the score of the player that will be used to display
     * @param int time this is the overal time of the player has been playing the game
     */
    public CreditTextDisplay(int typeMessage,int score,int time){
        if(typeMessage==0){
            setImage(new GreenfootImage("Congratulations",40,white,black,black)); 
        }
        if(typeMessage==1){
            setImage(new GreenfootImage("You have completed the game",40,white,black,black));
        }
        if(typeMessage==2){
            setImage(new GreenfootImage("Score: " + score,40,white,black,black));
        }
        if(typeMessage==3){
            setImage(new GreenfootImage("Total Time: " + time,40,white,black,black));
        }
        if(typeMessage==-1){
            setImage(new GreenfootImage(""+time,30,white,black,black));
        }
        if(typeMessage==-2){
            setImage(new GreenfootImage(""+score,30,white,black,black));
        }
    }
    
    /**
     * Sets the image of the object 
     * @param String typeeMessage the texts that willbe displayed
     * @param int size the size of the text
     */
    public CreditTextDisplay(String typeMessage,int size){
        setImage(new GreenfootImage(typeMessage,size,white,black,black));
    }
    
    /**
     * set the image of the number paramter makes use of sprite helper to generate image
     * @param int number the number to be displayed
     */
    public CreditTextDisplay(int number){
        setImage(SpriteHelper.getNumberImage(number));
    }
}
