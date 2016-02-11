import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author Mitchell
 * @version (a version number or a date)
 */
public class Player extends Entity implements IFalling
{
    public static int MOVE_SPEED = 3;
    public static int JUMP_SPEED = -20;
    public static int MOVE_SPEED_CAP = 10;
    public static int VERT_SPEED_CAP = 15;
    public static final int FRICTION = 1;
    
    private final int SPEED_BOOST_TIMER = 360;
    private final int JUMP_BOOST_TIMER = 520;
    private int jumpBoostTimeLeft = JUMP_BOOST_TIMER;
    boolean gotJumpBoost = false;
    private int speedBoostTimeLeft = SPEED_BOOST_TIMER;
    boolean gotSpeedBoost = false;

    private int vertVelocity = 0;
    private int horzVelocity = 0;

    Player(){
        hasFocus = true;
    }

    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

        horzVelocity = horzVelocity>=FRICTION?horzVelocity-=FRICTION:horzVelocity<=-FRICTION?horzVelocity+=FRICTION:0;
        if (Greenfoot.isKeyDown("LEFT")){
            horzVelocity -= MOVE_SPEED;
        }else if(Greenfoot.isKeyDown("RIGHT")){
            horzVelocity += MOVE_SPEED;
        }
        if (Greenfoot.isKeyDown("c"))((ExtendedWorld)getWorld()).centreCameraOn(this);
        if (gotSpeedBoost){
            speedBoostTimer();
        }
        if (gotJumpBoost){
            jumpBoostTimer();
        }
        if(Greenfoot.isKeyDown("UP")&&onPlatform()){
                moveLocation(0,-1);
                vertVelocity = JUMP_SPEED;
        }
        horzVelocity = horzVelocity > MOVE_SPEED_CAP?MOVE_SPEED_CAP:horzVelocity<-MOVE_SPEED_CAP?-MOVE_SPEED_CAP:horzVelocity;
        move();
        //fall();

        Powerup pu = (Powerup)getOneObjectAtOffset(0, 0, Powerup.class);
        if (pu != null){
            int kind = pu.getType();
            getWorld().removeObject(pu);
            if (kind == Powerup.SPEED_PU){ 
                gotSpeedBoost = true;
                MOVE_SPEED_CAP += 3;
                VERT_SPEED_CAP += 3;

            }
       
            if (kind == Powerup.JUMP_PU) {
                gotJumpBoost = true;
                JUMP_SPEED -= 10;    
            }

        }
    }

    public void speedBoostTimer(){
        speedBoostTimeLeft--;
        if (speedBoostTimeLeft <= 0){

            gotSpeedBoost = false;
            MOVE_SPEED_CAP -= 3;
            VERT_SPEED_CAP -= 3;
            speedBoostTimeLeft = SPEED_BOOST_TIMER;
            System.out.println("Speed boost is over");

        }
    }

    public void jumpBoostTimer(){
        jumpBoostTimeLeft--;
        if(jumpBoostTimeLeft <= 0){
            gotJumpBoost = false;
            JUMP_SPEED += 10;
            jumpBoostTimeLeft = SPEED_BOOST_TIMER;
            System.out.println("Jump boost is over");
        }
    }

    public void move(){
        moveLocation(horzVelocity,0);
    }

    public void fall(int g){
        if (!onPlatform()){
            vertVelocity+=g;
            if(vertVelocity>0){
                for(int i=0;i<vertVelocity;i++){
                    moveLocation(0,1);
                    if (!getIntersectingObjects(Terrain.class).isEmpty()){
                        vertVelocity = 0;
                    }
                }
            } else if(vertVelocity<0){

                for(int i=0;i>vertVelocity;i--){
                    moveLocation(0,-1);
                    if (!getIntersectingObjects(Terrain.class).isEmpty()){
                        vertVelocity = 0;
                    }
                }
            }
        }else{
            vertVelocity = 0;
        }
    }
}
