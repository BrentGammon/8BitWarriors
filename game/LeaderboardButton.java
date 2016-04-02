import greenfoot.*;

/**
 * This object will act as a button for the user to be abe to press and to load the leaderboard world
 * 
 * @author Brent Gammon 
 * @version S3 2/4/16
 */
public class LeaderboardButton extends MenuItems
{
    private GreenfootImage start;
    private boolean selected = false;
    /**
     * Constructor for LeaderboardButton
     */
    public LeaderboardButton(){
        setImage("leaderboardLogo.png");
    }
    
    /**
     This will checking two states when the mouse is hover on and off the object to change the image 
     * When object is clicked it will load the leaderboard world
     */
    public void act() 
    {
        if(isHovered()){
            if (!selected) getSound().play();
                start = new GreenfootImage("leaderboardLogoON.png");
                selected = true;
                setImage(start);
        }else{
            start = new GreenfootImage("leaderboardLogo.png");
            selected = false;
            setImage(start);
        }
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new Leaderboard());
        }
    }    
}
