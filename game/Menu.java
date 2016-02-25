import greenfoot.*;

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends ExtendedWorld
{

    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {
        super(false); 
        layer1 = new GreenfootImage("images/Graphics/MainMenuelements/Menu_BG.png");
         setBackground(layer1);
         //redrawBackground();
         
         
       addObject(new PlayerFace(),125,85);
       addObject(new RedFace(),700,85);
       addObject(new Title(),415,102);
       
       addObject(new Start(),419,209 );
       addObject(new Load(),409,279);
       addObject(new LevelSelect(),413,350);
       addObject(new Settings(),416,423);
    }
}
