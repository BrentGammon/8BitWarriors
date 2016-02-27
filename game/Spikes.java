import greenfoot.*;

/**
 * Write a description of class Spikes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spikes extends Entity
{
    /**
     * Act - do whatever the Spikes wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    static int SPIKE_1 = 0, SPIKE_2 = 1, SPIKE_3 = 2; 
    static final String[] images = { "spike1.png", "spike2.png", "spike3.png" };
    
    int spiType;
    
    
     public Spikes(int type)
    {
        spiType = type;
        setImage(images[spiType]);
    }
    
    public void act() 
    {
        Actor a = getOneIntersectingObject(Player.class);
        if (a != null){
            //MuteControl.stop();
            Greenfoot.setWorld(new World1());
            return;
        }
        
        Actor b = getOneIntersectingObject(TrackEnemy.class);
        if (b != null){
            //MuteControl.stop();
            die();
            return;
        }
    }
        public boolean die(){
        getWorld().addObject(new DeadEntity(getImage()),getX(),getY());
        return super.die();
    }
    
    
    public int getType(){
    
        return spiType;
    
    }
}
