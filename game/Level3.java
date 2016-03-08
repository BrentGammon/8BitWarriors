import greenfoot.*;

/**
 * This class will be used in the Level Select Menu, when actived through a click event it will load level 3
 * 
 * @author Brent Gammon
 * @version v0.1
 */
public class Level3 extends MenuItems
{
    /**
     * When an instance is created it will contain the level 2 icon image
     */
    public Level3()
    {
        GreenfootImage start = new GreenfootImage("images/Graphics/MENUV2/level3Icon.png");
        setImage(start);
    }
    
    
    /**
     *When clicked it will set the world to level 3 - at the moment print a message to the terminal
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            //Uncomment when level 3 is implemented
            //World3 world3 = new World3();
            //Greenfoot.setWorld(world3);
            System.out.println("Level 3 selected");
        }
    }    
}