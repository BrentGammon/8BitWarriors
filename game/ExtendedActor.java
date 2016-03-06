    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Point;
/**
 * Write a description of class ExtendedActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExtendedActor extends Actor
{
    /**
     * Act - do whatever the ExtendedActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //
    private int worldX=-10000;
    private int worldY=-10000;
    private boolean locationSet=false;
    protected boolean hasFocus;

    public void addedToWorld(World world){
        super.addedToWorld(world);
    }
    public boolean isFocus(){
        return hasFocus;
    }
    
    public void moveLocation(int x,int y){
        setLocation(getX()+x,getY()+y);
    }
    public void setWindowLocation(int x, int y){
        super.setLocation(x,y);
    }
    public void move(int x){
        super.move(x);
    }
    public int getHeight(){
        return getImage().getHeight();
    }
    public int getWidth(){
        return getImage().getWidth();
    }
    public ExtendedWorld getExtendedWorld(){
        if (getWorld() instanceof ExtendedWorld){
            return (ExtendedWorld)getWorld();
        }
        return null;
    }
    public int getRealX(){
        return getX() + getExtendedWorld().getCameraX();
    }
    public int getRealY(){
        return getY() + getExtendedWorld().getCameraY();
    }
        
    public int getDistanceTo(ExtendedActor target){
        //System.out.println("( ("+getX()+" - "+target.getX()+")^2 + ("+getY()+"
        return (int)Math.sqrt(Math.pow(getX()-target.getX(),2) + Math.pow(getY()-target.getY(),2));
    }
}
