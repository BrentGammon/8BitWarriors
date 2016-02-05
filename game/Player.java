import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Entity
{
    public static final int MOVE_SPEED = 3;
    public static final int MOVE_SPEED_CAP = 10;
    public static final int VERT_SPEED_CAP = 15;
    public static final int FRICTION = 1;
    public static final int JUMP_SPEED = -30;
    public static final int GRAVITY = 2;
    
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
        }else if(Greenfoot.isKeyDown("DOWN")){
            setRotation(90);
            moveLocation(0,MOVE_SPEED);
        }
        if(Greenfoot.isKeyDown("UP")){
            if(onPlatform()){
                System.out.println("Jump");
                moveLocation(0,-1);
                vertVelocity = JUMP_SPEED;
            }
        }
        horzVelocity = horzVelocity > MOVE_SPEED_CAP?MOVE_SPEED_CAP:horzVelocity<-MOVE_SPEED_CAP?-MOVE_SPEED_CAP:horzVelocity;
        move();
        fall();
    }
    public void move(){
        moveLocation(horzVelocity,0);
    }
    public void fall(){
        if (!onPlatform()){
            vertVelocity+=GRAVITY;
            if(vertVelocity>0){
                for(int i=0;i<vertVelocity;i++){
                    moveLocation(0,1);
                    if (!getIntersectingObjects(Terrain.class).isEmpty()){
                        //moveLocation(0,-1);
                        vertVelocity = 0;
                    }
                }
            } else if(vertVelocity<0){
                
                for(int i=0;i>vertVelocity;i--){
                    moveLocation(0,-1);
                    if (!getIntersectingObjects(Terrain.class).isEmpty()){
                        //moveLocation(0,1);
                        vertVelocity = 0;
                    }
                }
            }
        }else{
            vertVelocity = 0;
        }
    }
}
