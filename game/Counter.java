 

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
 * @authors Sharaz, Mati
 * @version 2.0
 */
public class Counter extends UI
{
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    private static int value;
    //counter value
    private static int target;
    private String prefix;
    //static field changed from dumbenemy's call to counter.add
    private static boolean increment;
    
    //called upon player death to remove counter object from world (see act)
    private static boolean end;
    
    public Counter()
    {
        this("Score: ");
        //sets greenfoot image to counter, then uses the value 0 and overlaps these two images
        GreenfootImage image = new GreenfootImage("Counter.png");
        GreenfootImage text = new GreenfootImage(prefix + 0, 22, Color.BLACK, transparent);
        //concatenate text with counter image
        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
                        (image.getHeight()-text.getHeight())/2);
        setImage(image);
        end=false;
    }

    /**
     * Create a new counter, initialised to 0.
     */
    public Counter(String prefix)
    {
        background = getImage();  // get image from class
        value = 0;
        target = 0;
        increment = false;
        this.prefix = prefix;
        updateImage();
    }
    
   
    
    /**
     * Animate the display to count up (or down) to the current target value.
     */
    public void act() 
    {
        //ExtendedWorld world = getExtendedWorld();
        //setLocation(world.getWidth()/2, world.getHeight()/2);
        /*if counter.add is called from enemy, increase the value by one and then update the image
        with new value*/
        
        if (increment) {
            value++;
            updateImage();
            increment = value<target;
        }
       
        //remove object upon player death
        if(end){
            World world = getWorld();
            world.removeObject(this);
        }
    }
    
    //method called from player die method
    public static void end(){
        end = true;
    }
    
    /**
     * Add a new score to the current counter value.  This will animate
     * the counter over consecutive frames until it reaches the new value.
     */
    public static void add()
    {
       target++;
       increment = true;
       
    }
    /**
     * Add a new score to the current counter value.  This will animate
     * the counter over consecutive frames until it reaches the new value.
     */
    public static void add(int num){
        target += num;
        increment = true;
    }

    /**
     * Return the current counter value.
     */
    public int getValue()
    {
        return target;
    }
    
    //return final value (player dies, no longer increasing)
    public static int getFinalVal(){
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
    public void updateImage()
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
    
    public void setValue(int value){
        this.value = value;
        
    }
    
    public int getValues(){
        return value;
    }
}
