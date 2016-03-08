import greenfoot.*;

/**
 * This world will be the menu for the game, menuItems objects will populate this world to allow the player to navigate the menu
 * 
 * @author Brent Gammon 
 * @version v0.1
 */
public class Menu extends ExtendedWorld
{
    public static final int GAME_WIDTH = 600;
    public static final int GAME_HEIGHT = 800;
    /**
     * Constructor for objects of class Menu.
     */
    
<<<<<<< HEAD
        protected int GAME_HEIGHT = 600;
        protected int GAME_WIDTH = 800;
=======
>>>>>>> 77ec42fad0290e6de1412ab7596fd98e1d7392a2
    public Menu()
    {
        super(GAME_HEIGHT,GAME_WIDTH,false); 
        
        layer1 = new GreenfootImage("images/Graphics/MainMenuelements/Menu_BG.png");
        

        setBackground(layer1);

        addObject(new PlayerFace(),125,85);
        addObject(new RedFace(),700,85);
        addObject(new Title(),415,102);

        addObject(new Start(),419,209 );
        addObject(new Load(),409,279);
        addObject(new LevelSelect(),413,350);
        addObject(new Settings(),416,423);
    }
}
