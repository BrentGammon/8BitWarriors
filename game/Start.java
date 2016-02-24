import greenfoot.*;

/**
 * Start button for the menu
 * 
 * @author Brent Gammon 
 * @version v0.1
 */
public class Start extends MenuItems
{
    private GreenfootImage start;
    private boolean isMouseON;
    /**
     * Act - do whatever the Start wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Start(){
        start = new GreenfootImage("images/Graphics/MENUV2/M2StartGame.png");
        setImage(start);
    }

    public void act() 
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null){
            Actor actor = mouse.getActor();
            if(actor!=null){
                if(actor.equals(this)){
                    start = new GreenfootImage("images/Graphics/MENUV2/M2StartGameON.png");
                    setImage(start);
                }else{
                    start = new GreenfootImage("images/Graphics/MENUV2/M2StartGame.png");
                    setImage(start);
                }
            }
        }
        if(Greenfoot.mouseClicked(this)){
            World world = getWorld();
            World1 world1 = new World1();
            Greenfoot.setWorld(world1);
        }
    }    
}
