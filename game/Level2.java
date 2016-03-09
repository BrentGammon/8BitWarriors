import greenfoot.*;

/**
 * This class will be used in the Level Select Menu, when actived through a click event it will load level 2
 * 
 * @author Brent Gammon
 * @version v0.1
 */
public class Level2 extends MenuItems
{   
    /**
     * When an instance is created it will contain the level 2 icon image
     */
    public Level2(){
        GreenfootImage start = new GreenfootImage("images/LevelSelect/lvl2unlockedRESIZE.png");
        setImage(start);
    }
    
    /**
     *When clicked it will set the world to level 2
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            World2 world2 = new World2();
            Greenfoot.setWorld(world2);
        }
    }    
}
