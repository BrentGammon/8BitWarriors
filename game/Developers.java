import greenfoot.*;

/**
 * Write a description of class Developers here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Developers extends ExtendedWorld
{
    public static final int GAME_WIDTH = 600;
    public static final int GAME_HEIGHT = 800;
    /**
     * Constructor for objects of class Developers.
     * 
     */
    public Developers()
    {
        super(GAME_HEIGHT,GAME_WIDTH,false); 
        layer1 = new GreenfootImage("images/Graphics/MainMenuelements/Menu_BG.png");
        setBackground("images/Graphics/MainMenuelements/Menu_BG.png");

        addObject(new CreditTextDisplay("Developers",60),420,49);
        addObject(new Home(),65,50);
        
        addObject(new CreditTextDisplay("Brent Gammon",50),420,150);
        addObject(new CreditTextDisplay("Mitchell Rebuck-Watson",50),420,250);
        addObject(new CreditTextDisplay("Viktor Kovachev",50),420,350);
        addObject(new CreditTextDisplay("Shahraz Khan",50),420,450);
        addObject(new CreditTextDisplay("Mati Saidzai",50),420,550);
    }
}
