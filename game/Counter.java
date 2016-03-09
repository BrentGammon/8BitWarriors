import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * A Counter class that allows you to display a numerical value on screen.
 * 
 * The Counter is an actor, so you will need to create it, and then add it to
 * the world in Greenfoot.  If you keep a reference to the Counter then you
 * can adjust its value.  Here's an example of a world class that
 * displays a counter with the number of act cycles that have occurred:
 * 
 * <pre>
 * class CountingWorld
 * {
 *     private Counter actCounter;
 *     
 *     public CountingWorld()
 *     {
 *         super(600, 400, 1);
 *         actCounter = new Counter("Act Cycles: ");
 *         addObject(actCounter, 100, 100);
 *     }
 *     
 *     public void act()
 *     {
 *         actCounter.setValue(actCounter.getValue() + 1);
 *     }
 * }
 * </pre>
 * 
 * @author Neil Brown and Michael Kölling 
 * @version 1.0
 */
public class Counter extends UI
{
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    private int value;
    //counter value
    private static int target;
    private String prefix;
    //static field changed from dumbenemy's call to counter.add
    private static boolean increment;
    
    public Counter()
    {
        this(new String());
        //sets greenfoot image to counter, then uses the value 0 and overlaps these two images
        GreenfootImage image = new GreenfootImage("Counter.png");
        GreenfootImage text = new GreenfootImage(prefix + 0, 22, Color.BLACK, transparent);
        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
                        (image.getHeight()-text.getHeight())/2);
        setImage(image);
    }

    /**
     * Create a new counter, initialised to 0.
     */
    public Counter(String prefix)
    {
        background = getImage();  // get image from class
        value = 0;
        target = 0;
        this.prefix = prefix;
        updateImage();
    }
    
    /**
     * Animate the display to count up (or down) to the current target value.
     */
    public void act() 
    {
        /*if counter.add is called from enemy, increase the value by one and then update the image
        with new value*/
        if (increment) {
            value++;
            updateImage();
            increment = false;
        }
       
   }

    /**
     * Add a new score to the current counter value.  This will animate
     * the counter over consecutive frames until it reaches the new value.
     */
    //called from enemy class upon its death
    public static void add()
    {
       increment = true;
       
    }

    /**
     * Return the current counter value.
     */
    public int getValue()
    {
        return target;
    }

   
    
    /**
     * Sets a text prefix that should be displayed before
     * the counter value (e.g. "Score: ").
     */
    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
        updateImage();
    }

    /**
     * Update the image on screen to show the current value.
     */
    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage("Counter.png");
        GreenfootImage text = new GreenfootImage(prefix + value, 22, Color.BLACK, transparent);
        
        if (text.getWidth() > image.getWidth() - 20)
        {
            image.scale(text.getWidth() + 20, image.getHeight());
        }
        
        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
                        (image.getHeight()-text.getHeight())/2);
        setImage(image);
    }
}
