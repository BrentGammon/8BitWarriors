package game;

/**
 * IFalling Actors should impliment the fall method which contains all the logic necessary for when
 * they need to fall due to gravity. This will be called by the world class to force them all down.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface IFalling  
{
    void fall(int gravity);
}
