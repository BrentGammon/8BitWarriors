import greenfoot.*;

/**
 * Write a description of class UI here.
 * 
 * @author Mitchell Rebuck-Watson
 * @version (a version number or a date)
 */
public class UI extends Actor
{
    public ExtendedWorld getExtendedWorld(){
        if (getWorld() instanceof ExtendedWorld){
            return (ExtendedWorld)getWorld();
        }
        return null;
    }
}
