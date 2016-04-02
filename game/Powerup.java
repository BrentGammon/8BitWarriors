import greenfoot.*;
/**
 * Power ups. 
 * 
 * @author Viktor, Mati
 * @version 0.1
 */
public class Powerup extends Entity
{
    static int SPEED_PU = 0, JUMP_PU = 1, AMMO_PU = 2, BOMB_PU = 3; // add as needed giving unique number to each different type of powerup
    static final String[] images = { "speedPU.png", "jumpPU.png", "ammoPU.png" , "bomb Up.png"}; // add as needed; keep the same order as the static final int fields above
 
    int puType; // a value from the list of static final ints above
    int lifespan = 300; // about 5 to 6 seconds
    
    
    // a Powerup object can be created with 'new Powerup(Powerup.SPEED_PU)' or similar
    public Powerup(int type)
    {
        puType = type;
        setImage(images[puType]);
    }
    
    //gets the lifespan so it can remove the object when it expires
    public void act()
    {
        if (getExtendedWorld().isPaused()) return;
        lifespan--;
        if (lifespan == 0) getWorld().removeObject(this);
     
    }
    
    //gets the powerup type and returns it really useful
    public int getType()
    {
        return puType;
    }
}
