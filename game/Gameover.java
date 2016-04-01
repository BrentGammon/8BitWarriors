import greenfoot.*;
import java.awt.Color;
import java.util.*;
/**
 * Game over screen will appear when character dies.
 * 
 * @authors Sharaz, Mati 
 * @version 1.0
 */
public class Gameover extends UI
{
    /**
     * Act - do whatever the Gameover wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static final Color transparent = new Color(0,0,0,0);
    private String levelLoad;
    private boolean genInfo = true;
    public Gameover() {
        //         //set image to file of choice
        //         //setImage("gameover.jpg");
        //         GreenfootImage image = new GreenfootImage("Counter.png");
        //         GreenfootImage text = new GreenfootImage("" + Counter.getFinalVal(), 22, Color.BLACK, transparent);
        // 
        //         if (text.getWidth() > image.getWidth() - 20)
        //         {
        //             image.scale(text.getWidth() + 20, image.getHeight());
        //         }
        // 
        //         //create new counter image using getfinal val from counter class
        //         image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
        //             (image.getHeight()-text.getHeight())/2);
        // 
        //         //concatenate gameover image and counter image                 
        //         GreenfootImage over = new GreenfootImage("gameover.jpg");
        //         over.drawImage(image, (over.getHeight()/2), 
        //             (over.getWidth()/2)-55);
        // 
        //         //concatenate previous image with timer image
        //         GreenfootImage timer = new GreenfootImage("Time: " + Timer.getFinalTime(), 25, Color.WHITE, transparent);
        //         over.drawImage(timer, (over.getHeight()/2 + 10), 
        //             (over.getWidth()/2)+40);
        // 
        //         setImage(over);

        setImage("gameover.png");
        //List <Timer> time = getWorld().getObjects(Timer.class);
        //List <Counter> count = getWorld().getObjects(Counter.class);
        //int deathScore = Counter.getFinalVal();
        //int deathTime = Timer.getFinalTime();
        //if(count.size()>0 && time.size()>0){
        //    deathScore = count.get(0).getValues();
        //    deathTime = time.get(0).getTimeValue();
        // }
        //getWorld().addObject(new CreditTextDisplay(-2,deathScore,0),227,178);
        //getWorld().addObject(new CreditTextDisplay(-1,0,deathTime),207,178);

    }

    public void getInfo(){
        //List <Timer> time = getWorld().getObjects(Timer.class);
        //List <Counter> count = getWorld().getObjects(Counter.class);
        int deathScore = Counter.getFinalVal();
        int deathTime = Timer.getFinalTime();
        //if(count.size()>0 && time.size()>0){
        //    deathScore = count.get(0).getValues();
        //    deathTime = time.get(0).getTimeValue();
        // }
        getWorld().addObject(new CreditTextDisplay(-2,deathScore,0),213,197);
        getWorld().addObject(new CreditTextDisplay(-1,0,deathTime),194,176);
    }

    public void act() 
    {
        //if image is clicked when gameover message appears, a new world is created
        if(genInfo){
            getInfo();
            genInfo = false;
        }
        ExtendedWorld world = (ExtendedWorld) getWorld();
        levelLoad = world.getLevel();
        if(Greenfoot.mouseClicked(this)){
            if(levelLoad.equals("1")){
                Greenfoot.setWorld(new World1()); 
            }
            if(levelLoad.equals("2")){
                World2 world2 = (World2) world;
                Greenfoot.setWorld(new World2(world2.getStartScore(),world2.getStartTime()));
            }
            if(levelLoad.equals("3")){
                World3 world3 = (World3) world;
                Greenfoot.setWorld(new World3(world3.getStartScore(),world3.getStartTime()));
            }
        }
    }    
}
