 

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * This world will contain settings for the game, this will be repsented by different objects within the world
 * 
 * @author Brent Gammon, Mati Saidzai 
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
        addObject(new UPControl(),418,331);
        addObject(new LeftControl(),322,403);
        addObject(new RightControl(),511,403);
        addObject(new Home(),47,115);
        addObject(new AttackControl(),322,511);
        addObject(new BombControl(),511,511);

        addObject(new SettingBinding(),420,155);
        addObject(new SettingBelowHeading(),415,210);
        //addObject(new SettingsTitle(),414,97);
        addObject(new SettingsBanner(),410,40);
    }
}
