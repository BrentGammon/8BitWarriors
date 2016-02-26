import greenfoot.*;

/**
 * The Level Select component on the menu
 * 
 * @author Brent Gammon 
 * @version v0.1
 */
public class LevelSelect extends MenuItems
{
    
    private GreenfootImage start;
    /**
     * Act - do whatever the Start wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public LevelSelect(){
        start = new GreenfootImage("images/Graphics/MENUV2/M2LevelSelect.png");
        setImage(start);
    }
    
    /**
     * Act - do whatever the LevelSelect wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null){
            Actor actor = mouse.getActor();
            if(actor!=null){
                if(actor.equals(this)){
                    start = new GreenfootImage("images/Graphics/MENUV2/M2LevelSelectON.png");
                    setImage(start);
                }else{
                    start = new GreenfootImage("images/Graphics/MENUV2/M2LevelSelect.png");
                    setImage(start);
                }
            }
        }
       if(Greenfoot.mouseClicked(this)){
          System.out.println("Level Select has been clicked");
       }
    }    
}
