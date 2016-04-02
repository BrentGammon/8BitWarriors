import greenfoot.*;
import java.awt.Color;

/**
 * Simple health Display
 * 
 * @author Mitchell Rebuck-Watson
 * @version S3 1
 */
public class Healthbar extends ExtendedActor
{
    /** State Variables */
    private ExtendedActor target;
    private Color back = new Color(0,0,0,128);
    private Color fore = new Color(50,200,50,255);
    private int max, health, off;
    private boolean visible;
    /**
     * Main Constructor
     * 
     * @param max The actors Max health
     * @param target The actor to glue the healthbar to
     * @param off The Y offset to place healthbar at. Positive is above.
     */
    public Healthbar(int max, ExtendedActor target,int off){
        this.target = target;
        this.max = max;
        this.off = off;
        health = max;
        visible = true;
        setImage(new GreenfootImage(max*5,5));
        updateDisplay();
    }
    
    /**
     * Act - do whatever the Healthbar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        updatePosition();
    }
    /**
     * Set the health to display
     */
    public void setHealth(int health){
        this.health = Math.min(max,health);
        updatePosition();
        updateDisplay();
    }
    /**
     * Is the healthbar visible
     */
    public boolean isVisible(){
        return visible;
    }
    /**
     * Private method to set the position of the healthbar
     */
    private void updatePosition(){
        if (visible) setLocation(target.getX(),target.getY()-off);
    }
    /**
     * Private method to update the image the healthbar displays
     */
    private void updateDisplay(){
         GreenfootImage bg = getImage();
         bg.clear();
         bg.setColor(back);
         bg.fill();
         bg.setColor(fore);
         bg.fillRect(0,0,health*5,5);
         bg.setColor(Color.BLACK);
         bg.drawRect(0,0,max*5-1,4);
    }
    /**
     * Remove the healthbar from the world
     */
    public void remove(){
        getWorld().addObject(new DeadEntity(getImage()),getX(),getY());
        if (visible)getWorld().removeObject(this);
    }
}
