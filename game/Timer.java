import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Transparency;
 
public class Timer extends Actor
{
    /**
     * Act - do whatever the Timer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    private long time = 0;
    private int count = 0;
    private static final int FPS = 50;
    public void act() 
    {
        // Add your action code here.
        reset();
        count = (count + 1)%FPS;
        if (count == 0) time++;
        isTimeUp();
        display();
      
    }    
     
    private void display()
    {
        Color transparent = new Color(0, 0, 0, 0);
        setImage(new GreenfootImage("Time: " + time, 25, Color.BLACK, transparent));
    }
     
    public boolean isTimeUp()
    {
        return time == 999;
    }
    
    public void reset(){
        
        if(isTimeUp()){
            
           Greenfoot.setWorld(new World1());
           return;
            
        }
        
    }
     
}