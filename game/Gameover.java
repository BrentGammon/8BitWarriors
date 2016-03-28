 import greenfoot.*;

import greenfoot.*;
import java.awt.Color;
/**
 * Game over screen will appear when character dies.
 * 
 * @author Sharaz
 * @version 1.0
 */
public class Gameover extends UI
{
    /**
     * Act - do whatever the Gameover wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static final Color transparent = new Color(0,0,0,0);
    
    public Gameover() {
        //set image to file of choice
        //setImage("gameover.jpg");
        GreenfootImage image = new GreenfootImage("Counter.png");
        GreenfootImage text = new GreenfootImage("" + Counter.getFinalVal(), 22, Color.BLACK, transparent);
        
        if (text.getWidth() > image.getWidth() - 20)
        {
            image.scale(text.getWidth() + 20, image.getHeight());
        }
        
        //create new counter image using getfinal val from counter class
        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
                        (image.getHeight()-text.getHeight())/2);
        
       //concatenate gameover image and counter image                 
        GreenfootImage over = new GreenfootImage("gameover.jpg");
        over.drawImage(image, (over.getHeight()/2), 
                        (over.getWidth()/2)-55);
                        
        //concatenate previous image with timer image
        GreenfootImage timer = new GreenfootImage("Time: " + Timer.getFinalTime(), 25, Color.WHITE, transparent);
        over.drawImage(timer, (over.getHeight()/2 + 10), 
                        (over.getWidth()/2)+40);
        
        setImage(over);
        
        
        
        setImage("gameover.png");
    }
    
    public void act() 
    {
        //if image is clicked when gameover message appears, a new world is created
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new World1());
        }
    }    
}
