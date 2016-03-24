package game;

import greenfoot.*;

/**
 * The menu for selecting the level for the player. The levels displayed will vary based on the 
 * value that is saved on the external file.
 * 
 * @author Brent Gammon 
 * @version v0.1
 */
public class LevelSelectMenu extends ExtendedWorld
{
    public static final int GAME_HEIGHT = 800;
    public static final int GAME_WIDTH = 600;
    /**
     * Will populate the world with objects such as a home buttons and level select buttons will vary on the paramter value.
     * @param String levels This will be the amount for level select buttons for example if value is "3" then buttons 1,2,3 will be shown
     * 
     */
    public LevelSelectMenu(String levels)
    {
        super(GAME_HEIGHT,GAME_WIDTH,false); 
       
        //setBackground("images/Graphics/MainMenuelements/Menu_BG.png");
        layer1 = new GreenfootImage("images/Graphics/MainMenuelements/Menu_BG.png");
        addObject(new Home(),76,73);
        
        
        
        int view;
        if(levels==null){
            view = 0;
        }else{
            view = Integer.parseInt(levels);
        }
        
        switch(view){
            case 1: 
            addLevel1();
            break;
            case 2: 
            addLevel1();
            addLevel2();
            break;
            case 3: 
            addLevel1();
            addLevel2();
            addLevel3();
            break;
            default: 
            addLevel1();
            break;
        }
    }
    
    /**
     *When invoked it will add a Level1 instance into the world at a specifed location 
     */
    public void addLevel1(){
        addObject(new Level1(),127,252);
    }
    
    /**
     * When invoked it will add a Level2 instance into the world at a specifed location 
     */
    public void addLevel2(){
        addObject(new Level2(),387,252);
    }
    
    /**
     * When invoked it will add a Level1 instance into the world at a specifed location
     */ 
    public void addLevel3(){
        addObject(new Level3(),632,252);
    }
}
