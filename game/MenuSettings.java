import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * This world will contain settings for the game, this will be repsented by different objects within the world
 * 
 * @author Brent Gammon
 * @version v0.1
 */
public class MenuSettings extends ExtendedWorld
{
    public static final int GAME_HEIGHT = 800;
    public static final int GAME_WIDTH = 600;
    /**
     * Constructor for objects of class MenuSettings.
     * This will populate the world with objects that the player can interact with by clicking
     */
    public MenuSettings()
    {
        super(GAME_HEIGHT,GAME_WIDTH,false); 
        
        layer1 = new GreenfootImage("images/Graphics/MainMenuelements/Menu_BG.png");
       
        setBackground("images/Graphics/MainMenuelements/Menu_BG.png");
        showText("Key Bindings",100,100);
        addObject(new UPControl(),100,150);
        addObject(new LeftControl(),100,200);
        addObject(new RightControl(),100,250);
        addObject(new Home(),50,50);
        addObject(new AttackControl(),100,302);
    }
}
