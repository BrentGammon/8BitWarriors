
import greenfoot.*;
/**
 * This class will be used in the Level Select Menu, when actived through a click event it will load level 1
 * 
 * @author Brent Gammon
 * @version S3 4/4/16
 */
public class LevelIcon extends MenuItems
{
    private GreenfootImage start;
    private int type;
    private boolean locked;
    /**
     * When an instance is created it will contain the level 1 icon image
     */
    public LevelIcon(int type,boolean locked){
        this.type = type;
        this.locked = locked;
        if(type==1){
            start = new GreenfootImage("images/LevelSelect/lvl1buttonRESIZE.png");
        }
        if(type==2 && locked==false){
            start = new GreenfootImage("images/LevelSelect/lvl2unlockedRESIZE.png");
        }
        if(type==2 && locked==true){
            start = new GreenfootImage("images/LevelSelect/lvl2buttonlockedRESIZE.png");
        }
        if(type==3 && locked==false){
            start = new GreenfootImage("images/LevelSelect/lvl3unlockedRESIZE.png");
        }
        if(type==3 && locked==true){
            start = new GreenfootImage("images/LevelSelect/lvl3buttonlockedRESIZE.png");
        }

        setImage(start);
    }

    /**
     *When clicked it will set the world to level 1
     */
    public void act() 
    {

        if(Greenfoot.mouseClicked(this)){
            if(type==1){
                World1 world1 = new World1();
                Greenfoot.setWorld(world1);
            }
            if(type==2 && locked==false){
                World2 world2 = new World2(0,0);
                Greenfoot.setWorld(world2);
            }
            if(type==3 && locked==false){
                World3 world3 = new World3(0,0);
                Greenfoot.setWorld(world3);
            }
        }

    }    
}
