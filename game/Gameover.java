 import greenfoot.*;

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
    public Gameover() {
        //set image to file of choice
        setImage("gameover.png");
    }
    
    public void act() 
    {
        //if image is clicked when gameover message appears, a new world is created
        ExtendedWorld world = (ExtendedWorld) getWorld();
        String levelLoad = world.getLevel();
        
        if(Greenfoot.mouseClicked(this)){
            if(levelLoad.equals("1")){
               Greenfoot.setWorld(new World1()); 
            }
            if(levelLoad.equals("2")){
                Greenfoot.setWorld(new World2());
            }
            if(levelLoad.equals("3")){
                Greenfoot.setWorld(new World3());
            }
            
        }
    }    
}
