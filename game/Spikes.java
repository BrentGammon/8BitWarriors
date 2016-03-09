import greenfoot.*;

/**
 * Spikes will damage the player and kill them, however
 * the spikes are destroyed by the smart enemnies.
 * 
 * @author (Viktor) 
 * @version (1.22)
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
    
    //spikes method getting the image type corresponding to the spike
     public Spikes(int type)
    {
        spiType = type;
        setImage(images[spiType]);
    }
    
    //main method killing the player or getting killed by the smart enemy
    public void act() 
    {
        if (getExtendedWorld().isPaused()) return;
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
    
    //die method for the class so it can be killed
        public boolean die(){
        getWorld().addObject(new DeadEntity(getImage()),getX(),getY());
        return super.die();
    }
    
    //gets the spike type and returns it
    public int getType(){
    
        return spiType;
    
    }
}
