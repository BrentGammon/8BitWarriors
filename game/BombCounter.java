import greenfoot.*;

/**
 * Displays Players current bombs also acts as the storage for bombs
 * 
 * @author Mitchell Rebuck-Watson
 * @version S3 1
 */
public class BombCounter extends UI
{
    //Default number of bombs
    private static final int BOMBS = 3;
    
    //State variables
    private static int bombs = 3;
    private int lastBombs = -1;
    
    //Counter base image
    private GreenfootImage img = new GreenfootImage("HUD/bombCounter.png");
    public BombCounter() {
        setImage(new GreenfootImage(img));
    }
    /**
     * Reset the amount of bombs to the default amount (3)
     */
    public static void reset(){
        bombs = BOMBS;
        
    }
    /**
     * Get the number of bombs available
     * 
     * @return number of bombs. always 0 or above
     */
    public static int getBombs(){
        return bombs;
    }
    /**
     * Decrements bombs down to 0 and no further
     */
    public static void useBomb(){
        bombs = Math.max(bombs-1,0);
    }
    /**
     * Increments the number of bombs
     */
    public static void addBomb(){
        bombs++;
    }
    /**
     * Act - do whatever the BombIndicator wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (getWorld().getObjects(Player.class).size()==0) getWorld().removeObject(this);
        if (lastBombs==bombs)return;
        
        lastBombs = bombs;
        setImage(new GreenfootImage(img));
        getImage().drawImage(SpriteHelper.getNumberImage(bombs),47,12);
    }    
}
