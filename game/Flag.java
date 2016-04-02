import greenfoot.*;
import java.util.*;
/**
 * This object will allow the player to be able to move to another world based on the their current world
 * 
 * @author Brent Gammon   
 * @version SP3 31/3/16
 */
public class Flag extends ExtendedActor
{
    /**
     * Constructor for Flag this sets the image of the object 
     */
    public Flag(){
        setImage("flag.png");
    }
   
    /**
     * Act - do whatever the Flag wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        List <Player> player = getWorld().getObjects(Player.class);
        if(player.size()>0){
            Player play = player.get(0);
            if(this.intersects(play)){
                ExtendedWorld exWorld = (ExtendedWorld) getWorld();
                String value = exWorld.getLevel();
                List<Counter> counter = getWorld().getObjects(Counter.class);
                List<Timer> timer = getWorld().getObjects(Timer.class);
                Timer time = null;
                Counter count = null;
                if(counter.size()>0 && timer.size()>0){
                    time = timer.get(0);
                    count = counter.get(0);
                }
                int times = time.getTimeValue();
                int scores = count.getValues()+100;
                if(value.equals("1")){
                    World2 world = new World2(scores,times);
                    Greenfoot.setWorld(world);
                }
                if(value.equals("2")){
                    World3 world = new World3(scores,times);
                    Greenfoot.setWorld(world);
                }
                if(value.equals("3")){
                    EndCredits world = new EndCredits(times,scores);
                    world.highScoreSave();
                    Greenfoot.setWorld(world);
                }
            }
        }    
    }
}
