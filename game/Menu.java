 

import greenfoot.*;
/**
 * This world will be the menu for the game, menuItems objects will populate this world to allow the player to navigate the menu
 * 
 * @author Brent Gammon 
 * @version S3 2/4/16
 */
public class Menu extends ExtendedWorld
{
    public static final int GAME_WIDTH = 600;
    public static final int GAME_HEIGHT = 800;
    /**
     * Constructor for objects of class Menu.
     * Populates the world with objects that the player can click to perform actions
     */
        
    public Menu()
    {
        super(GAME_HEIGHT,GAME_WIDTH,false); 
        
        layer1 = new GreenfootImage("images/Graphics/MainMenuelements/Menu_BG.png");
        setBackground("images/Graphics/MainMenuelements/Menu_BG.png");

        addObject(new Face(false),125,85);
        addObject(new Face(true),700,85);
        addObject(new Title(),415,102);
        addObject(new Start(),419,209 );
        addObject(new Load(),409,279);
        addObject(new LevelSelect(),413,350);
        addObject(new Settings(),416,423);
        addObject(new LeaderboardButton(),169,526);
        addObject(new DevelopersButton(),627,526);
    }
}
