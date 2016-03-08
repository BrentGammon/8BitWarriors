import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Transparency;

public class Timer extends UI
{
    /**
     * Act - do whatever the Timer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int time = 0;
    private int count = 45;
    public void act() 
    {
        // Add your action code here.
        if (getExtendedWorld().isPaused()) return;
        reset();
        isTimeUp();
        if(counter())
        {
            time++;
            count = 45;
        }
        display();

    }    

    private boolean counter()
    {
        if(count > 0)
        {
            count--;
        }
        return count == 0;
    }

    private void display()
    {
        Color transparent = new Color(0, 0, 0, 0);
        setImage(new GreenfootImage("Time: " + time, 25, Color.WHITE, transparent));
    }

    public void setTime()
    {
        time = 0;
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