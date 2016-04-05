import greenfoot.*;

/**
 * Allows the player to restart the world from the pauseMenu
 * 
 * @author Brent Gammon
 * @version S3 5/4/16
 */
public class RestartButton extends MenuItems
{
    /**
     * Constructor for RestartButton - sets the image of the object
     */
    public RestartButton(){
        GreenfootImage image = new GreenfootImage("images/PAUSE/restartbutton.png");
        setImage(image);
    }
    
    /**
     * This will resrt the world which is the current level they are on
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            ExtendedWorld exWorld =(ExtendedWorld) getWorld();
            if(exWorld.getLevel().equals("1")){
                World1 world = (World1) exWorld;
                Greenfoot.setWorld(new World1());
            }
            if(exWorld.getLevel().equals("2")){
                World2 world = (World2) exWorld;
                Greenfoot.setWorld(new World2(world.getStartScore(),world.getStartTime()));
            }
            if(exWorld.getLevel().equals("3")){
                World3 world = (World3) exWorld;
                Greenfoot.setWorld(new World3(world.getStartScore(),world.getStartTime()));
            }
        }
    }    
}
