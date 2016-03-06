import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class particle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Particle extends ExtendedActor
{
    private int life;
    
    public Particle(int life){
        this.life = life;
        setImage(new GreenfootImage(1,1));
        getImage().setColor(Color.MAGENTA);
        getImage().fill();
    }
    /**
     * Act - do whatever the particle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (getExtendedWorld().isPaused()) return;
        if (--life<0) getWorld().removeObject(this);
    }    
}
