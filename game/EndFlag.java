import greenfoot.*;

/**
 * Sets the world to the next
 * 
 * @author Mitchell Rebuck-Watson
 * @version S3 1
 */
public class EndFlag extends ExtendedActor
{
    public void addedToWorld(World w){
        setImage("end.png");
    }
    /**
     * Act - do whatever the EndFlag wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (getOneIntersectingObject(Player.class)!=null){
            World oldWorld, newWorld;
            oldWorld = getWorld();
            if (oldWorld instanceof World1){
                Greenfoot.setWorld(new World2());
            }else if(oldWorld instanceof World2){
                Greenfoot.setWorld(new World3());
            }
        }
    }    
}
