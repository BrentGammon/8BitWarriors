import greenfoot.*;

/**
 * Terrain
 * 
 * @author Mitchell
 * @version S1 1
 */
public abstract class Terrain extends ExtendedActor
{
    public boolean canSupportEntity(Entity a){
        return true;
    }
}
