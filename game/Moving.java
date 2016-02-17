import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Moving here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Moving extends ExtendedActor
{
    private int speed = 2;
    
    public Moving(){
        GreenfootImage image = getImage();
        //image.scale(image.getWidth() - 60, image.getHeight() - 60);
        image.scale(90,90);
        setImage(image);
    }
    
    /**
     * Act - do whatever the Moving wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation ( getX() + speed, getY() );
        
        Actor actor = getOneIntersectingObject(null);
        if(actor != null){
            actor.setLocation(actor.getX() + speed, actor.getY());
            
        }
        
        if(atTurningPoint()){
            speed = -speed;
        }
    }    
    
    public boolean atTurningPoint(){
        return (getX() <= 250 || getX() >= 600);
    }
}
