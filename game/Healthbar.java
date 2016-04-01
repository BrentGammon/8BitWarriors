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
    private ExtendedActor target;
    private Color back = new Color(0,0,0,128);
    private Color fore = new Color(50,200,50,255);
    private int max, health, off;
    private boolean visible;
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
    public void setHealth(int health){
        this.health = Math.min(max,health);
        updatePosition();
        updateDisplay();
    }
    public boolean isVisible(){
        return visible;
    }
    
    private void updatePosition(){
        if (visible) setLocation(target.getX(),target.getY()-off);
    }private void updateDisplay(){
         GreenfootImage bg = getImage();
         bg.clear();
         bg.setColor(back);
         bg.fill();
         bg.setColor(fore);
         bg.fillRect(0,0,health*5,5);
         bg.setColor(Color.BLACK);
         bg.drawRect(0,0,max*5-1,4);
    }
    public void remove(){
        getWorld().addObject(new DeadEntity(getImage()),getX(),getY());
        if (visible)getWorld().removeObject(this);
    }
}
