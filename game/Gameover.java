import greenfoot.*;

/**
 * Write a description of class Gameover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gameover extends UI
{
    /**
     * Act - do whatever the Gameover wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Gameover() {
        setImage("gameover.jpg");
    }
    
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new World1());
        }
    }    
}
