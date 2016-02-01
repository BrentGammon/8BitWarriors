import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    private int worldX;
    private int worldY;
    public void act() 
    {
    }
    public void setLocation(int x,int y){
        System.out.println("Location Set:"+x+y);
        super.setLocation(x,y);
    }
}
