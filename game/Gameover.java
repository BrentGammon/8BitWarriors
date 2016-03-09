import greenfoot.*;

/**
 * Write a description of class Gameover here.
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
    public Gameover() {
        //set image to file of choice
        setImage("gameover.jpg");
    }
    
    public void act() 
    {
        //if image is clicked when gameover message appears, a new world is created
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new World1());
        }
    }    
}
