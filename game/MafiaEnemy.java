 

import greenfoot.*;

/**
 * DumbEnemy will move left and right while in contact with the terrian.
 * @author Brent Gammon 
 * @version S3
 */
public class MafiaEnemy extends Entity implements IDamageable,IFalling
{
    private static final int DAMAGE = 1;
    private int health = 2;
    private int speed = 5;
    protected boolean goLeft = false;
    private boolean hit = false;
    private int frame;
    private int iframes=0;
    private GreenfootSound attackSound = new GreenfootSound("AttackHitSound.wav");
    
    private static  GreenfootImage SHEET = new GreenfootImage("bug.png");
    private static  GreenfootImage SHEET1 = new GreenfootImage("mafia.png");
    private static final int SHEET_H = 1;
    private static final int SHEET_W = 4;
    private static final int SHEET_H2 = 1;
    private static final int SHEET_W2 = 4;
    private static final int SPRITE_H = SHEET.getHeight()/SHEET_H;
    private static final int SPRITE_W = SHEET.getWidth()/SHEET_W;
    private static final int SPRITE_H2 = SHEET1.getHeight()/SHEET_H2;
    private static final int SPRITE_W2 = SHEET1.getWidth()/SHEET_W2;
    private Healthbar healthbar;
    /**
     * Act - do whatever the DumbEnemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pre ssed in the environment.
     */
    
    public MafiaEnemy(){
        setImage(new GreenfootImage(SPRITE_W2,SPRITE_H2));
    }



    
   public void addedToWorld(World w){
        healthbar = new Healthbar(2,this,40);
        w.addObject(healthbar,getX(),getY()-10);
    }
    public void act() 
    {
        if (getExtendedWorld().isPaused()) return;
        if (iframes>0) iframes--;
        else{
            moving(); 
            /*if player object has interacted with enemy, then remove its weapon, remove player, freeze the timer,
             * and display the gameover image by adding an object of it to the world
            */
            Actor a = getOneIntersectingObject(Player.class);
            if (a != null){
                ((Player)a).doDamage(this,DAMAGE);
            }
        }
        updateSprite();
        updateSprite2();
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
        //sharaz
        if(isTouching(PushObject.class)){
            changeDirection();
            direction();
        }
        
        
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
        if( iframes==0 ){
            health -= damage;
            healthbar.setHealth(health);
            iframes = 20;
            MuteControl.playSound(attackSound);
            if (health>0) return damage;
            die();
            return damage;
        }else return 0;
    }
     
    /**
     * When called this will increment the score counter and add DeadEntity to the world
     * @return a super call to die
     */
    public boolean die(){
        //scoreboard incremented by one
        Counter.add(10);
        healthbar.remove();
        getWorld().addObject(new ScoreIndicator(10), getX(),getY());
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
        if (iframes>0&&iframes%10<5) setImage(SpriteHelper.makeWhite( getImage()));
        else frame = frame + 1 % (SHEET_H* SHEET_W);
    }
    
      private void updateSprite2(){
        //facing front
        getImage().clear();
        getImage().drawImage(SHEET1,-(frame%SHEET_W2)*SPRITE_W2,0);
        if(!goLeft) getImage().mirrorHorizontally();
        if (iframes>0&&iframes%10<5) setImage(SpriteHelper.makeWhite( getImage()));
        else frame = frame + 1 % (SHEET_H2* SHEET_W2);
    }
}
