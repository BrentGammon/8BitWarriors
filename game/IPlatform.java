package game;

import greenfoot.*;
/**
 * Classes that support IStandable will be able to be stood on by any actor that it wants to.
 * The actual behavior that prevents the actor from falling should be contained within the actor.
 * 
 * @author Mitchell Rebuck-Watson
 * @version S2 01
 */
public interface IPlatform  
{
    /**
     * Main function of the interface. Returns the boolean representing if the given actor
     * can stand on it.
     * 
     * @param a The entity to query
     */
    boolean canSupportEntity(Entity a);
    
    boolean bottomIsCollidable();
}
