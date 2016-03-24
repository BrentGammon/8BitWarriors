package game;

/**
 * IFalling Actors should impliment the fall method which contains all the logic necessary for when
 * they need to fall due to gravity. This will be called by the world class to force them all down.
 * 
 * @author Mitchell Rebuck-Watson
 * @version S2 1
 */
public interface IFalling  
{
    /**
     * Tell actor how much gravity is affecting it that tick/act
     * 
     * @param gravity gravity to apply. Positive is down.
     */
    void fall(int gravity);
}
