import greenfoot.*;

/**
 * This world will contain names of all developers that created the game
 * 
 * @author Brent Gammon, Mati Saidzai
 * @version S3 3/4/16
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

        addObject(new DeveloperBanner(),427,40);
        addObject(new Brent(),420,150);
        addObject(new Mitch(),420,200 );
        addObject(new Viktor(),420,250 );
        addObject(new Sharaz(),420,300 );
        addObject(new Mati(),420,350);
        addObject(new Home(),47,115);
        
        //addObject(new CreditTextDisplay("Brent Gammon",50),420,150);
        //addObject(new CreditTextDisplay("Mitchell Rebuck-Watson",50),420,250);
        //addObject(new CreditTextDisplay("Viktor Kovachev",50),420,350);
        //addObject(new CreditTextDisplay("Sharaz Khan",50),420,450);
        //addObject(new CreditTextDisplay("Mati Saidzai",50),420,550);
    }
}
