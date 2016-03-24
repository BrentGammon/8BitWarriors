package game;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Moving here.
 * 
 * @author Sharaz
 * @version 2.0
 */
public class Moving extends ExtendedActor
{
    private int speed = 2;
    //counter to keep steady increase of directional change 
    private int speedTot = 0;
    
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
        if (getExtendedWorld().isPaused()) return;
        //once speed is added to horizontal direction, counter (speedTot) is incremented by 1
        setLocation ( getX() + speed, getY() );
        speedTot += 1;
        
        //if player iteracts wih object, plaer moves at same pace and direction as this objec
        Actor actor = getOneIntersectingObject(null);
        if(actor != null){
            actor.setLocation(actor.getX() + speed, actor.getY());
            
        }
        
        /*once counter has reached specified limit, the direction changes to the opposite of current,
         *and then counter is reset to 0
        */
        if(speedTot == 50){
            speed = -speed;
            speedTot = 0;
        }
    }    
    
    
}
