import greenfoot.*;

/**
 * Pause Menu Object. Automatically displays itself when the world it is within is paused.
 * 
 * @author Mitchell Rebuck-Watson
 * @version S3 1
 */
public class PauseMenu extends UI
{
    private boolean visible = false;
    //the pause menu image
    private GreenfootImage img = new GreenfootImage("images/pause.png");
    
    //pause menu buttons
    private MuteControl mute;
    private SaveGame save;

    /**
     * Main Constructor
     */
    public PauseMenu(){
        save = new SaveGame();
        mute = new MuteControl();
        setImage(new GreenfootImage(1,1));
    }
    /**
     * Act - do whatever the Paused wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (getWorld().getObjects(Player.class).size()==0) return;
        boolean paused = getExtendedWorld().isPaused();
        if(paused != visible){
            visible = paused;
            if (visible) show();
            else hide();
        }
    }
    /**
     * Private method to hide the pause menu
     */
    private void hide(){
        setImage(new GreenfootImage(1,1));
        World w = getWorld();
        w.removeObject(save);
        w.removeObject(mute);
    }
    /**
     * Private show to hide the pause menu
     */
    private void show(){
        setImage(img);
        World w = getWorld();
        w.addObject(save,getX()+70,getY()-40);
        w.addObject(mute,getX()-70,getY()-40);
    }
}
