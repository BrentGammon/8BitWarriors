import greenfoot.*;

/**
 * Buttons that allow the user to be able to view the developers world
 * 
 * @author Brent Gammon 
 * @version S3 2/4/16
 */
public class DevelopersButton extends MenuItems
{
    private GreenfootImage start;
    private boolean selected = false;
    /**
     * Contructor for the class DevelopersButton
     */
    public DevelopersButton()
    {
        setImage("developersLogo.png");
    }
    /**
     * This will checking two states when the mouse is hover on and off the object to change the image 
     * When object is clicked it will load the developers world
     */
    public void act() 
    {
        if(isHovered()){
            if (!selected) getSound().play();
                start = new GreenfootImage("developersLogoON.png");
                selected = true;
                setImage(start);
        }else{
            start = new GreenfootImage("developersLogo.png");
            selected = false;
            setImage(start);
        }
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new Developers());
        }
    }    
}
