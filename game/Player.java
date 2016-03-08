import greenfoot.*;
import java.awt.Color;
import java.awt.Transparency;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.*;
/**
 * The main player entity. It stores the players key bindings in addition to being the entity in the world
 * 
 * @author Mitchell
 * @version S2 2
 */
public class Player extends Entity implements IFalling, IDamageable
{
    /** constants for the player*/
    public static final int MOVE_SPEED = 3;
    public static final int JUMP_SPEED = -20;
    public static final int MOVE_SPEED_CAP = 10;
    public static final int SPEED_BOOST_CAP = 15;
    
    public static final int VERT_SPEED_CAP = 15;
    public static final int FRICTION = 1;
    
    /** powerup constants */
    private final int SPEED_BOOST_TIMER = 360;
    private final int JUMP_BOOST_TIMER = 520;
    private final int ATTACK_BOOST_TIMER = 650;
    
    /** Time remaining for the powerups */
    private int jumpBoostTimer = 0;
    private int speedBoostTimer = 0;
    private int attackBoostTimer = 0;
    
    /** Images for the players animation*/
    private GreenfootImage front = new GreenfootImage("Player/front.png");
    private GreenfootImage standingRight = new GreenfootImage("Player/standing.png");
    private GreenfootImage standingLeft;
    private GreenfootImage jump1Right = new GreenfootImage("Player/jump1.png");
    private GreenfootImage jump2Right = new GreenfootImage("Player/jump2.png");
    private GreenfootImage jump1Left;
    private GreenfootImage jump2Left;
    private GreenfootImage moveRight = new GreenfootImage("Player/move.png");
    private GreenfootImage moveLeft;
    
    /** is the player facing left or not */
    private boolean facingLeft = false;

    /** the players current weapon object */
    private Attack weapon;

    /** keybinds for the player */
    public static String keyJump;
    public static String keyLeft;
    public static String keyRight;
    public static String keyAttack;
    
    
    /**
     * Constructor for Player
     */
    Player(){
        //initiate the facing left sprites
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
    
    /*
     * When the player is added to the world it sets the player as the focus and spawns in the players weapon 
     */
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
        if (getExtendedWorld().isPaused()) return;
        
        // if velocity is greater than how much friction reduces then reduce speed by friction (add if negative subtract if positive). Else set to 0
        horzVelocity = horzVelocity>=FRICTION?horzVelocity-=FRICTION:horzVelocity<=-FRICTION?horzVelocity+=FRICTION:0;
        
        // Check for powerups and apply them
        boosts();
        
        //if player has powerup decrement timer.
        if (hasSpeedBoost()){
            speedBoostTimer();
        }
        if (hasJumpBoost()){
            jumpBoostTimer();
        }
        if (hasAttackBoost()){
            attackBoostTimer();
        }

        //if the jump key is being held and player is on a platform. Jump
        if(Greenfoot.isKeyDown(keyJump!=null?keyJump:"SPACE")&&onPlatform()){
            moveLocation(0,-1);
            vertVelocity = (hasJumpBoost()?-5:0) +JUMP_SPEED;
        }
        
        //if player is moving in a direction
        if (Greenfoot.isKeyDown(keyLeft!=null?keyLeft:"LEFT")){
            //apply speed in direction
            horzVelocity -= MOVE_SPEED;
            //set direction (whether or not facing left or not)
            facingLeft = true;
            //set image to standing if on the ground. jumping if in the air
            setImage(onPlatform()?standingLeft:jump1Left);
        }else if (Greenfoot.isKeyDown(keyRight!=null?keyRight:"RIGHT")){
            horzVelocity += MOVE_SPEED;
            setImage(onPlatform()?standingRight:jump1Right);
            facingLeft = false;
        }else{
            //else set image to facing forward
            setImage(front);
            //facingLeft = false;
        }
        
        //tell weapon what direction we are facing
        weapon.setDirection(facingLeft);
        //if player is pressing an attack key; fire
        if(Greenfoot.isKeyDown(keyAttack!=null?keyAttack:"X")){
            weapon.fire();
        }
        
        //if player has speed boost cap speed at speed boost cap else do move speed cap
        int cap = hasSpeedBoost()?SPEED_BOOST_CAP:MOVE_SPEED_CAP; 
        horzVelocity = Math.min(Math.max(-cap,horzVelocity),cap);
        
        // do motion with calculated
        move();
        // check that the player is still within the world.
        checkOutOfBounds();

    }
    
    
    
    /**
     * This function checks whether or not the player is touching any powerup items and removes them. 
     */
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
            
            if (kind == Powerup.AMMO_PU){
                attackBoostTimer = ATTACK_BOOST_TIMER;
            }

        }

    }

    /**
     * Decrements the speed boost powerup timer
     */
    public void speedBoostTimer(){
        if (speedBoostTimer-- <= 0){
            System.out.println("Speed boost is over");
        }
    }
    /**
     * Decrements the jump boost powerup timer
     */
    public void jumpBoostTimer(){
        
        if(jumpBoostTimer-- == 1){
            System.out.println("Jump boost is over");
        }
    }
    /**
     * Decrements the attack boost powerup timer
     */
    public void attackBoostTimer(){
    
        if(attackBoostTimer-- <= 0){
            System.out.println("Attack boost is over");
        }
    
    }

    /**
     * Perform motion using velocity variables
     */
    public void move(){
        boolean movingLeft = horzVelocity<0;
        if (collideMoveLocation(horzVelocity,vertVelocity)){
            if (true) return;
            if (directionBlocked(movingLeft?"left":"right")) horzVelocity = 0;
            if (vertVelocity<0 && upBlocked()) vertVelocity = 0;
        }
    }
    /*
     * On Player death reset the world
     */
    public boolean die(){
        Greenfoot.setWorld(new World1());
        return true;
    }
    /**
     * Does the player currently have jump boost
     * 
     * @return jump boost on
     */
    public boolean hasJumpBoost(){
        return jumpBoostTimer > 0;
    }
    
    /**
     * Does the player currently have speed boost
     * 
     * @return speed boost on
     */
    public boolean hasSpeedBoost(){
        return speedBoostTimer > 0;
    }
    
    /**
     * Does the player currently have attack boost
     * 
     * @return attack boost on
     */
    public boolean hasAttackBoost(){
        return attackBoostTimer > 0;
    }
  
    /*
     * Perform out of bounds check
     */
    private void checkOutOfBounds(){
        int buffer = 200;
        int realX = getX() + ((ExtendedWorld)getWorld()).getCameraX();
        int realY = getY() + ((ExtendedWorld)getWorld()).getCameraY();
        int xBound = getExtendedWorld().getWorldWidth();
        int yBound = getExtendedWorld().getWorldHeight();
        if(realY > yBound+buffer || realX < 0-buffer || realX > xBound+buffer){
            die();
        }
    }
    
    /**
     * When player takes any damage - die
     * 
     * @return damage taken
     */
    public int doDamage(Actor a, int damage){
        if (damage>0)die();
        return damage;
    }

}

