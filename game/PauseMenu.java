import greenfoot.*;

/**
 * Display Pause Menu
 * 
 * @author Mitchell Rebuck-Watson
 * @version (a version number or a date)
 */
public class PauseMenu extends UI
{
    private boolean visible = false;
    private GreenfootImage img = new GreenfootImage("images/pause.png");
    private MuteControl mute;
    private SaveGame save;
    //private QuitGame = quit;
    public PauseMenu(){
        save = new SaveGame();
        mute = new MuteControl();
        setImage(new GreenfootImage(1,1));
        //quit = new QuitGame();
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
    private void hide(){
        setImage(new GreenfootImage(1,1));
        World w = getWorld();
        w.removeObject(save);
        w.removeObject(mute);
    }
    private void show(){
        setImage(img);
        World w = getWorld();
        w.addObject(save,getX()+70,getY()-40);
        w.addObject(mute,getX()-70,getY()-40);
    }
}
