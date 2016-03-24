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
      
        layer1 = new GreenfootImage("images/Graphics/MainMenuelements/Menu_BG.png");
        addObject(new Home(),40,87);
        addObject(new LevelSelectBanner(),486,33);
        addObject(new LevelSelectTitle(),412,98);
        
        int view;
        if(levels==null){
            view = 0;
        }else{
            view = Integer.parseInt(levels);
        }
        
        switch(view){
            case 1: 
            addLevel1();
            addLevel2Locked();
            addLevel3Locked();
            break;
            case 2: 
            addLevel1();
            addLevel2();
            addLevel3Locked();
            break;
            case 3: 
            addLevel1();
            addLevel2();
            addLevel3();
            break;
            default: 
            addLevel1();
            addLevel2Locked();
            addLevel3Locked();
            break;
        }
    }
    
    /**
     *When invoked it will add a Level1 instance into the world at a specifed location 
     */
    public void addLevel1(){
        addObject(new Level1(),140,367);
    }
    
    /**
     * When invoked it will add a Level2 instance into the world at a specifed location 
     */
    public void addLevel2(){
        addObject(new Level2(),409,367);
        //need assets
    }
    
    /**
     * When invoked it will add a Level3 instance into the world at a specifed location
     */ 
    public void addLevel3(){
        addObject(new Level3(),670,367);
        //need assets
    }
    
    /**
     * When invoked it will add a Level2Locked instance into the world at a specifed location
     */
    public void addLevel2Locked(){
        addObject(new Level2Locked(),409,367);
    }
    
    /**
     * When invoked it will add a Level3Locked instance into the world at a specifed location
     */
    public void addLevel3Locked(){
        addObject(new Level3Locked(),670,367);
    }
}
