import greenfoot.*;

/**
 * Write a description of class Terrain here.
 * 
 * @author Mitchell
 * @version S1 1
 */
public abstract class Terrain extends ExtendedActor
{
    public boolean canSupportEntity(Entity a){
        return true;
    }
    public boolean bottomIsCollidable(){
        return true;
    }
}
