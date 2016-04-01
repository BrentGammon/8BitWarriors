import greenfoot.*;

/**
 * Graphical Representation of increased score.
 * 
 * @author Mitchell Rebuck-Watson
 * @version S3 1
 */
public class ScoreIndicator extends ExtendedActor
{
    private int life = 50;
    public ScoreIndicator(int score){
        GreenfootImage i = SpriteHelper.getNumberImage(score);
        setImage(i);
        //getImage().scale(i.getHeight()/2,i.getWidth()/2);
    }
    /**
     * Act - do whatever the ScoreIndicator wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (getExtendedWorld().isPaused()) return;
        if (life--==0) getWorld().removeObject(this);
        else{
            moveLocation(0,-1);
            getImage().setTransparency((life-50)*5+255);
        }
    }    
}
