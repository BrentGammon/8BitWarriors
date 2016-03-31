import greenfoot.*;
import java.awt.*;
/**
 * This world used when the player has completed the game, their stats will be presented to them
 * 
 * @author Brent Gammon
 * @version SP3 31/3/16
 */
public class EndCredits extends ExtendedWorld
{
    public static final int GAME_WIDTH = 600;
    public static final int GAME_HEIGHT = 400;
    private Color white = Color.WHITE;
    private Color black = Color.BLACK;
    /**
     * Constructor for world of  EndCredits.
     * @param int time the overal time that will be used to displayed to player
     * @param int score the overal score that will be used to displayed to player
     */
    public EndCredits(int time,int score)
    {
        super(GAME_WIDTH,GAME_HEIGHT,false);
        MuteControl m = new MuteControl();
        m.stop();

        layer1 = new GreenfootImage("images/Graphics/MainMenuelements/Menu_BG.png");
        GreenfootImage back = new GreenfootImage("images/Graphics/MainMenuelements/Menu_BG.png");
        setBackground(back);
        addObject(new CreditTextDisplay(0,score,time),313,26);
        addObject(new CreditTextDisplay(1,score,time),319,71);
        addObject(new CreditTextDisplay(2,score,time),310,123);
        addObject(new CreditTextDisplay(3,score,time),311,174);

    }
}
