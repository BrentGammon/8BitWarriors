import greenfoot.*;

/**
 * Generic Death animation entity
 * Takes an image that it should to then just falls off the world
 * 
 * @author Mitchell Rebuck-Watson
 * @version S2 1
 */
public class DeadEntity extends Entity implements IFalling
{
    //rotational speed
    private int rotSpeed;
    GreenfootImage img;
    DeadEntity(GreenfootImage img){
        //clone image and set self to this image
        this.img = new GreenfootImage(img);
        setImage(img);
        //set inital velocities to random values
        horzVelocity = Greenfoot.getRandomNumber(6)-3;
        vertVelocity = -Greenfoot.getRandomNumber(8)-2;
        rotSpeed = Greenfoot.getRandomNumber(10)+1;
    }
    public void act() 
    {
        if (getExtendedWorld().isPaused()) return;
        moveLocation(horzVelocity,vertVelocity);
        turn(rotSpeed);
        if (getY() > ExtendedWorld.GAME_HEIGHT) die();
    }
    public void fall(int g){
        vertVelocity+=g;
    }
}
