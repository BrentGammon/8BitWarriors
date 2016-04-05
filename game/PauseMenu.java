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
    private GreenfootImage img = new GreenfootImage("images/PAUSE/pauseBG.png");

    //pause menu buttons
    private MuteControl mute;
    private SaveGame save;
    private MenuButton home;
    private RestartButton restart;
    private PauseTitle title;
    /**
     * Main Constructor
     */
    public PauseMenu(){
        save = new SaveGame();
        mute = new MuteControl();
        home = new MenuButton();
        restart = new RestartButton();
        title = new PauseTitle();
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
        w.removeObject(home);
        w.removeObject(restart);
        w.removeObject(title);
    }

    /**
     * Private show to hide the pause menu
     */
    private void show(){
        setImage(img);
        World w = getWorld();
        w.addObject(save,242,236);
        w.addObject(mute,458,74);
        w.addObject(home,261,297);
        w.addObject(title,322,78);
        w.addObject(restart,190,169);
    }
}
