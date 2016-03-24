 

import greenfoot.*;

/**
 * Shell class used to define draw order and to provide shared functionality for UI Elements
 * 
 * @author Mitchell Rebuck-Watson
 * @version S2 1
 */
public abstract class UI extends Actor
{
    /**
     * Get the objects current world. If the world isnt extended returns null instead
     */
    public ExtendedWorld getExtendedWorld(){
        if (getWorld() instanceof ExtendedWorld){
            return (ExtendedWorld)getWorld();
        }
        return null;
    }
}
