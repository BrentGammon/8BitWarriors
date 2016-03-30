 

import greenfoot.*;

/**
 * DumbEnemy will move left and right while in contact with the terrian.
 * @author Brent Gammon 
 * @version 0.1
 */
public class DumbEnemy extends Entity implements IDamageable,IFalling
{
    private static final int DAMAGE = 1;
    private int health = 2;
    private int speed = 5;
    protected boolean goLeft = false;
    private boolean hit = false;
    private int frame;
    private GreenfootSound attackSound = new GreenfootSound("AttackHitSound.wav");
    
    private static final GreenfootImage SHEET = new GreenfootImage("bug.png");
    private static final int SHEET_H = 1;
    private static final int SHEET_W = 4;
    private static final int SPRITE_H = SHEET.getHeight()/SHEET_H;
    private static final int SPRITE_W = SHEET.getWidth()/SHEET_W;
    
    /**
     * Act - do whatever the DumbEnemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pre ssed in the environment.
     */
    
    public DumbEnemy(){
        setImage(new GreenfootImage(SPRITE_W,SPRITE_H));
    }
    
    public void act() 
    {
        if (getExtendedWorld().isPaused()) return;
        moving(); 
        /*if player object has interacted with enemy, then remove its weapon, remove player, freeze the timer,
         * and display the gameover image by adding an object of it to the world
        */
        Actor a = getOneIntersectingObject(Player.class);
        if (a != null){
            ((Player)a).doDamage(this,DAMAGE);
        }
        updateSprite();
    }  
    
    
    /**
     * This will check the results of different logic methods to see what movment the object should do under certain scenario
     */
    public void moving()
    {
        if(onPlatform()&&endPlatform()){
            direction();
        }
        if(onPlatform()&&!endPlatform()){
            changeDirection();
            direction();
        }
        collideMoveLocation(horzVelocity,1);
    }
    
    /**
     * When invoked it will flip the boolean value for goLeft
     */
    public void changeDirection()
    {
        if(goLeft){
            goLeft = false;
        }else{
            goLeft = true;
        }
    }
    
    /**
     * Move the object 1 pixel direction will depend on the value of goLeft
     */
    public void direction()
    {
        if(!goLeft){
            horzVelocity = 1;
        }else{
            horzVelocity = -1;
        }
    }
    
    /**
     * Doe damage to the actor that has been passed into the paramter
     * @param Actor attacker the actor that is going to have damage done to them
     * @param int damage the strength of the damage
     * @return int damage the amount done to the actor
     */
    public int doDamage(Actor attacker, int damage){
        health -= damage;
         attackSound.play();
        if (health<=0){
            die();
        }
        return damage;
    }
     
    /**
     * When called this will increment the score counter and add DeadEntity to the world
     * @return a super call to die
     */
    public boolean die(){
        //scoreboard incremented by one
        Counter.add(100);
        getWorld().addObject(new ScoreIndicator(100), getX(),getY());
        getWorld().addObject(new DeadEntity(getImage()),getX(),getY());
        return super.die();
    }
    
    /**
     * Internal method to set player sprite to apropriate image
     */
    private void updateSprite(){
        //facing front
        getImage().clear();
        getImage().drawImage(SHEET,-(frame%SHEET_W)*SPRITE_W,0);
        if(!goLeft) getImage().mirrorHorizontally();
        frame = frame + 1 % (SHEET_H* SHEET_W);
    }
}
