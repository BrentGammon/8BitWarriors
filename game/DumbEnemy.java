import greenfoot.*;

/**
 * Write a description of class DumbEnemy here.
 * 
 * @author Brent Gammon 
 * @version 0.1
 */
public class DumbEnemy extends Entity
{
    private int health = 10;
    private int speed = 5;

    protected boolean goLeft = false;
    /**
     * Act - do whatever the DumbEnemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        moving();
    }   
    
    
    public void moving()
    {
        if(onPlatform()&&!isAtEdge()&&endPlatform()){
            //move(1);
            direction();
        }else if(onPlatform()&&!isAtEdge()&&!endPlatform()){
            changeDirection();
            direction();
        }else if(onPlatform()&&isAtEdge()&&endPlatform()){
            changeDirection();
            direction();
        }
    }

    public void changeDirection()
    {
        if(goLeft){
            goLeft = false;
        }else{
            goLeft = true;
        }
    }

    public void direction()
    {
        if(!goLeft){
            move(1);
        }else{
            move(-1); 
        }
    }
    
    

    

    public void getLength()
    {
        System.out.println(getImage().getWidth());
        System.out.println(getImage().getHeight());
    }   
}
