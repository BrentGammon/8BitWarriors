import greenfoot.*;

/**
 * Write a description of class DeadEntity here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DeadEntity extends Entity implements IFalling
{
    private int rotSpeed;
    GreenfootImage img;
    DeadEntity(GreenfootImage img){
        this.img = new GreenfootImage(img);
        setImage(img);
        horzVelocity = Greenfoot.getRandomNumber(6)-3;
        vertVelocity = -Greenfoot.getRandomNumber(8)-2;
        rotSpeed = Greenfoot.getRandomNumber(10)+1;
    }
    public void addedToWorld(World w){
        System.out.println("new dead thing x"+getX()+" y"+getY());
    }
    public void act() 
    {
        moveLocation(horzVelocity,vertVelocity);
        turn(rotSpeed);
        System.out.print(this); System.out.print(" "+horzVelocity); System.out.println(" "+vertVelocity);
        if (getY() > ExtendedWorld.GAME_HEIGHT) die();
    }
    public void fall(int g){
        
        vertVelocity+=g;
    }
}
