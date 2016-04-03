 

import greenfoot.*;

/**
 * This class will be used in the Level Select Menu, when actived through a click event it will load level 3
 * 
 * @author Brent Gammon
 * @version S3
 */
public class Level3 extends MenuItems
{
    /**
     * When an instance is created it will contain the level 2 icon image
     */
    public Level3()
    {
        GreenfootImage start = new GreenfootImage("images/LevelSelect/lvl3unlockedRESIZE.png");
        setImage(start);
    }

    /**
     *When clicked it will set the world to level 3
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){

            World3 world3 = new World3(0,0);
            Greenfoot.setWorld(world3);

        }
    }    
}
