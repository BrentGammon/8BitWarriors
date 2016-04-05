import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Point;
/**
 * Any actor that needs to scroll inside a world should extend this class
 * 
 * @author Mitchell Rebuck-Watson
 * @version S2 2
 */
public class ExtendedActor extends Actor
{ 
    /**
     * State variables
     */
    private int worldX=0;
    private int worldY=0;
    private boolean locationSet=false;
    protected boolean hasFocus;

    /**
     * Does this Extended actor currenly have camera focus
     * 
     * @return Has focus
     */
    public boolean isFocus(){
        return hasFocus;
    }
    
    /**
     * Move this Extended actor relative to current position
     * 
     * @param x change in x position
     * @param y change in y position
     */
    public void moveLocation(int x,int y){
        setLocation(getX()+x,getY()+y);
    }
    /**
     * Pass through for base setLocation if the default is overwritten
     */
    public void setWindowLocation(int x, int y){
        super.setLocation(x,y);
    }
    /**
     * Get the height of this Extended Actor derived from its image
     * 
     * @return Actors height
     */
    public int getHeight(){
        return getImage().getHeight();
    }
    /**
     * Get the width of this Extended Actor derived from its image
     * 
     * @return Actors width
     */
    public int getWidth(){
        return getImage().getWidth();
    }
    public ExtendedWorld getExtendedWorld(){
        if (getWorld() instanceof ExtendedWorld){
            return (ExtendedWorld)getWorld();
        }
        return null;
    }
    /**
     * Compute this actors x position in world using the camera position
     * 
     * @return Actors X position
     * 
     */
    public int getRealX(){
        return getX() + getExtendedWorld().getCameraX();
    }
    /**
     * Compute this actors y position in world using the camera position
     * 
     * @return Actors Y position
     * 
     */
    public int getRealY(){
        return getY() + getExtendedWorld().getCameraY();
    }
    /**
     * Get the absolute distance between this and the target actor
     * 
     * @param target Actor to check distance for
     * @return distance to the target
     */
    public int getDistanceTo(ExtendedActor target){
        return (int)Math.sqrt(Math.pow(getX()-target.getX(),2) + Math.pow(getY()-target.getY(),2));
    }
}
