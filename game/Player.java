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
    public static int JUMP_SPEED = -30;
    public static  int MOVE_SPEED_CAP = 10;
    public static  int VERT_SPEED_CAP = 15;
    public static final int FRICTION = 1;
    protected int realY;
    protected int realX;

    private final int SPEED_BOOST_TIMER = 360;
    private final int JUMP_BOOST_TIMER = 520;
    private int jumpBoostTimeLeft = JUMP_BOOST_TIMER;
    boolean gotJumpBoost = false;
    private int speedBoostTimeLeft = SPEED_BOOST_TIMER;
    boolean gotSpeedBoost = false;

    private int vertVelocity = 0;
    private int horzVelocity = 0;

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
    
    Player(){
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
            facingLeft = true;
            setImage(onPlatform()?standingLeft:jump1Left);
        }else if(Greenfoot.isKeyDown("RIGHT")){
            horzVelocity += MOVE_SPEED;
            setImage(onPlatform()?standingRight:jump1Right);
            facingLeft = false;
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

        if(Greenfoot.isKeyDown("V")){
            if(currentCoolDown==0){
                currentCoolDown = SHOOT_COOL_DOWN;
                int x = getX()+40;
                World world = getWorld();
                int y = getY();
                world.addObject(new Attack(true),x,y);

            }else{
                currentCoolDown--;   
            }
        }
        if(Greenfoot.isKeyDown("X")){
            if(currentCoolDown==0){
                currentCoolDown = SHOOT_COOL_DOWN;
                boolean shootDirection;
                int x = getX()-60;
                World world = getWorld();
                int y = getY();
                world.addObject(new Attack(false),x,y);
            }else{
                currentCoolDown--;
            }
        }
        horzVelocity = horzVelocity > MOVE_SPEED_CAP?MOVE_SPEED_CAP:horzVelocity<-MOVE_SPEED_CAP?-MOVE_SPEED_CAP:horzVelocity;
        move();

        Powerup pu = (Powerup)getOneObjectAtOffset(0, 0, Powerup.class);
        if (pu != null){
            int kind = pu.getType();
            getWorld().removeObject(pu);
            if (kind == Powerup.SPEED_PU) { 
                gotSpeedBoost = true;
                MOVE_SPEED_CAP += 3;
                VERT_SPEED_CAP += 3;

            }
            if (kind == Powerup.JUMP_PU) {
                gotJumpBoost = true;
                JUMP_SPEED -= 10;    
            }

        }
        checkOutOfBounds();

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
        boolean movingLeft = horzVelocity<0;
        if (collideMoveLocation(horzVelocity,vertVelocity)){
            if (directionBlocked(movingLeft?"left":"right")) horzVelocity = 0;
        }
        System.out.println("h:"+horzVelocity+" v:"+vertVelocity);
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
    
    public void die(){
        if(realY > 2000){
            
            Greenfoot.setWorld(new World1());
            
            
        }
    }
    
    private void checkOutOfBounds(){
        realX = getX() + ((ExtendedWorld)getWorld()).getCameraX();
        realY = getY() + ((ExtendedWorld)getWorld()).getCameraY();
        System.out.println("x:"+realX+" y:"+realY);
    }
}
