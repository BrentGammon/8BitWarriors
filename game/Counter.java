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
 * @authors Sharaz, Mati, Mitchell
 * @version 3.0
 */
public class Counter extends UI
{
    private static final Color transparent = new Color(0,0,0,0);
    private static int value;
    //counter value
    private static int target;
    //static field changed from dumbenemy's call to counter.add
    private static boolean increment;
    //called upon player death to remove counter object from world (see act)
    private static boolean end;
    
    public Counter()
    {
        value = 0;
        target = 0;
        increment = false;
        updateImage();
        end=false;
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
     * Update the image on screen to show the current value.
     */
    public void updateImage()
    {
        setImage(SpriteHelper.getNumberImage(value));
    }
    
    /**
     * Sets the of value
     * @param int value the value that will be used to update instance variable value
     */
    public void setValue(int value){
        this.value = value;
        this.target = value;
        updateImage();
    }
    
    /**
     * returns the value of value
     * @return int value
     */
    public int getValues(){
        return value;
    }
}
