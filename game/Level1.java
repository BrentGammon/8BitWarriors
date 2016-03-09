import greenfoot.*;

/**
 * This class will be used in the Level Select Menu, when actived through a click event it will load level 1
 * 
 * @author Brent Gammon
 * @version v0.1
 */
public class Level1 extends MenuItems
{
    /**
     * When an instance is created it will contain the level 1 icon image
     */
    public Level1(){
        GreenfootImage start = new GreenfootImage("images/LevelSelect/lvl1buttonRESIZE.png");
        setImage(start);
    }
    
    /**
     *When clicked it will set the world to level 1
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            World1 world1 = new World1();
            Greenfoot.setWorld(world1);
        }
    }    
}
