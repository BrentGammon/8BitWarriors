import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class MenuSettings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuSettings extends ExtendedWorld
{
    public static final int GAME_HEIGHT = 800;
    public static final int GAME_WIDTH = 600;
    /**
     * Constructor for objects of class MenuSettings.
     * 
     */
    public MenuSettings()
    {
        //super(false);
        super(GAME_HEIGHT,GAME_WIDTH,false); 
        
        layer1 = new GreenfootImage("images/Graphics/MainMenuelements/Menu_BG.png");
       
        setBackground("images/Graphics/MainMenuelements/Menu_BG.png");
        
        
        //setImage(new GreenfootImage("KeyBindings",20,Color.white,Color.red,Color.blue));
        //getWorld().drawImage(key,20,20);
        showText("Key Bindings",100,100);
        addObject(new UPControl(),100,150);
        addObject(new LeftControl(),100,200);
        addObject(new RightControl(),100,250);
        addObject(new Home(),50,50);
    }
}
