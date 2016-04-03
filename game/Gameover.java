import greenfoot.*;
import java.awt.Color;
import java.util.*;
/**
 * Game over screen will appear when character dies.
 * 
 * @authors Sharaz, Mati, Brent Gammon
 * @version 1.0
 */
public class Gameover extends UI
{
    private static final Color transparent = new Color(0,0,0,0);
    private String levelLoad;
    private boolean genInfo = true;
    /**
     * Contructor for Gameover
     */
    public Gameover() {
        setImage("gameover.png");
    }
    
    /**
     * adds the scores to the world on the gameover image
     */
    public void getInfo(){
        int deathScore = Counter.getFinalVal();
        int deathTime = Timer.getFinalTime();
        getWorld().addObject(new CreditTextDisplay(-2,deathScore,0),238,201);
        getWorld().addObject(new CreditTextDisplay(-1,0,deathTime),221,174);
    }
    
    /**
     * Gets the socre and time of the player
     * and restess the world that the player is currently on with their start time and score for that level
     */
    public void act() 
    {
        //if image is clicked when gameover message appears, a new world is created
        if(genInfo){
            getInfo();
            genInfo = false;
        }
        ExtendedWorld world = (ExtendedWorld) getWorld();
        levelLoad = world.getLevel();
        if(Greenfoot.mouseClicked(this)){
            if(levelLoad.equals("1")){
                Greenfoot.setWorld(new World1()); 
            }
            if(levelLoad.equals("2")){
                World2 world2 = (World2) world;
                Greenfoot.setWorld(new World2(world2.getStartScore(),world2.getStartTime()));
            }
            if(levelLoad.equals("3")){
                World3 world3 = (World3) world;
                Greenfoot.setWorld(new World3(world3.getStartScore(),world3.getStartTime()));
            }
        }
    }    
}
