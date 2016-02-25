import greenfoot.*;
import java.awt.Color;
import java.awt.Transparency;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.*;
/**
 * Write a description of class Player here.
 * 
 * @author Mitchell
 * @version (a version number or a date)
 */
public class Player extends Entity implements IFalling
{

    public static final int MOVE_SPEED = 3;
    public static final int JUMP_SPEED = -30;
    public static final int MOVE_SPEED_CAP = 10;
    public static final int SPEED_BOOST_CAP = 15;
    
    public static final int VERT_SPEED_CAP = 15;
    public static final int FRICTION = 1;
    protected int realY;
    protected int realX;
    boolean isDead = false;
    

    private final int SPEED_BOOST_TIMER = 360;
    private final int JUMP_BOOST_TIMER = 520;
    
    private int jumpBoostTimer = 0;
    private int speedBoostTimer = 0;
    
    private final int SHOOT_COOL_DOWN = 60;
    private int currentCoolDown = 0;

    private GreenfootImage front = new GreenfootImage("Player/front.png");
    private GreenfootImage standingRight = new GreenfootImage("Player/standing.png");
    private GreenfootImage standingLeft;
    private GreenfootImage jump1Right = new GreenfootImage("Player/jump1.png");
    private GreenfootImage jump2Right = new GreenfootImage("Player/jump2.png");
    private GreenfootImage jump1Left;
    private GreenfootImage jump2Left;

    private GreenfootImage moveRight = new GreenfootImage("Player/move.png");
    private GreenfootImage moveLeft;

    private boolean facingLeft = false;

    private Attack weapon;
    //     private String keyLeft;
    //     private String keyRight;
    public static String keyJump;
    public static String keyLeft;
    public static String keyRight;

    Player(){
        ///keyLeft = JOptionPane.showInputDialog("Left Key");
        //keyRight = JOptionPane.showInputDialog("Right Key");
        //keyJump = JOptionPane.showInputDialog("Jump Key");

        standingLeft = new GreenfootImage(standingRight);
        standingLeft.mirrorHorizontally();
        jump1Left = new GreenfootImage(jump1Right);
        jump1Left.mirrorHorizontally();
        jump2Left = new GreenfootImage(jump2Right);
        jump2Left.mirrorHorizontally();
        moveLeft = new GreenfootImage(moveRight);
        moveLeft.mirrorHorizontally();

        hasFocus = true;

        setImage(front);
    }   

    @Override
    public void addedToWorld(World w){
        ((ExtendedWorld)w).setFocus(this);
        weapon = new BasicAttack(facingLeft,this);
        w.addObject(weapon,getX(),getY());
    }

    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        horzVelocity = horzVelocity>=FRICTION?horzVelocity-=FRICTION:horzVelocity<=-FRICTION?horzVelocity+=FRICTION:0;

        if (currentCoolDown>0) currentCoolDown--;
        boosts();
        if(!(Greenfoot.isKeyDown("RIGHT")||Greenfoot.isKeyDown("LEFT"))){
            setImage(front);
            facingLeft = false;

        }
        if (Greenfoot.isKeyDown("c"))((ExtendedWorld)getWorld()).centreCameraOn(this);
        if (hasSpeedBoost()){
            speedBoostTimer();
        }
        if (hasJumpBoost()){
            jumpBoostTimer();
        }

        
        if(Greenfoot.isKeyDown(keyJump!=null?keyJump:"SPACE")&&onPlatform()){
            moveLocation(0,-1);
            vertVelocity = (hasJumpBoost()?-5:0) +JUMP_SPEED;
        }
        

        if(keyLeft==null){
            if (Greenfoot.isKeyDown("LEFT")){
                horzVelocity -= MOVE_SPEED;
                facingLeft = true;
                setImage(onPlatform()?standingLeft:jump1Left);
            }
        }else{
            if (Greenfoot.isKeyDown(keyLeft)){
                horzVelocity -= MOVE_SPEED;
                facingLeft = true;
                setImage(onPlatform()?standingLeft:jump1Left);
            }
        }

        if(keyRight==null){
            if (Greenfoot.isKeyDown("RIGHT")){
                horzVelocity += MOVE_SPEED;
                setImage(onPlatform()?standingRight:jump1Right);
                facingLeft = false;
            }
        }else{
            if (Greenfoot.isKeyDown(keyRight)){
                horzVelocity += MOVE_SPEED;
                setImage(onPlatform()?standingRight:jump1Right);
                facingLeft = false;
            }
        }

        weapon.setDirection(facingLeft);
        if(Greenfoot.isKeyDown("V") && currentCoolDown==0){
            weapon.fire();
        }else if(Greenfoot.isKeyDown("X") && currentCoolDown==0){
            weapon.fire();
        }

        if(!(currentCoolDown==0)){
            currentCoolDown--;
        }
        
        //horzVelocity = horzVelocity > MOVE_SPEED_CAP?MOVE_SPEED_CAP:horzVelocity<-MOVE_SPEED_CAP?-MOVE_SPEED_CAP:horzVelocity;
        int cap = hasSpeedBoost()?MOVE_SPEED_CAP:SPEED_BOOST_CAP; 
        horzVelocity = Math.min(Math.max(-cap,horzVelocity),cap);
        move();
        checkOutOfBounds();

    }

    public void boosts(){
        Powerup pu = (Powerup)getOneIntersectingObject(Powerup.class);
        if (pu != null){
            int kind = pu.getType();
            pu.die();
            if (kind == Powerup.SPEED_PU) { 
                speedBoostTimer = SPEED_BOOST_TIMER;
            }

            if (kind == Powerup.JUMP_PU){
                jumpBoostTimer = JUMP_BOOST_TIMER;
            }

        }

    }

    public void speedBoostTimer(){
        if (speedBoostTimer-- <= 0){
            System.out.println("Speed boost is over");
        }
    }

    public void jumpBoostTimer(){
        
        if(jumpBoostTimer-- == 1){
            System.out.println("Jump boost is over");
        }
    }

    public void move(){
        boolean movingLeft = horzVelocity<0;
        if (collideMoveLocation(horzVelocity,vertVelocity)){
            if (directionBlocked(movingLeft?"left":"right")) horzVelocity = 0;
        }
    }

    public void fall(int g){
        if (!onPlatform()){
            vertVelocity+=g;
            /*
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
             */
        }else{
            vertVelocity = 0;
        }
    }

    public boolean die(){
        Greenfoot.setWorld(new World1());
        return true;
    }

    public boolean hasJumpBoost(){
        return jumpBoostTimer > 0;
    }
    public boolean hasSpeedBoost(){
        return speedBoostTimer > 0;
    }
  

    private void checkOutOfBounds(){
        int realX = getX() + ((ExtendedWorld)getWorld()).getCameraX();
        int realY = getY() + ((ExtendedWorld)getWorld()).getCameraY();
        if(realY > 2000 || realX < -400){
            die();
        }
    }

}

