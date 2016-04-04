 

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.TextField;
/**
 * Write a description of class World2 here.
 * 
 * @author (Viktor) 
 * @version (1.2v)
 */
public class World2 extends ExtendedWorld
{
 boolean begin;
   private MuteControl muteControl;
   GreenfootSound bgm = new GreenfootSound("crystal-kick.mp3");
   private boolean bossDefeated = false;
   //private int startScore;
   //private int startTime;
   //private final String gameLevel = "2";
    /**
     * Constructor for objects of class World2.
     * 
     */
    public World2(int score, int time)
    {
        //call to superclass to use centreCameraOn function
        super(3900,900,3900,900, true);
        MuteControl.setBGM(bgm);
        gameLevel = "1";
        Player p = new Player();
    
        //PowerupDisplay pd = new PowerupDisplay();
        //pd.setPlayer(p);
        //layer1_xoffset = -200;
        //layer1_yoffset = -100;
        layer1 = new GreenfootImage("images/city BG.png");
        
        redrawBackground();
        addObject(p,100,826);
        addObject(new Hud(0,0,p),113,62);
        addObject(new Wall(5,2),-22,675);
        addObject(new Spikes(1),1219,591);
        addObject(new Spikes(2),1319,590);
        addObject(new Spikes(0),1298,422);
        addObject(new Spikes(0),1357,422);
        addObject(new Spikes(2),2013,581);
        addObject(new Spikes(2),2508,300);
        addObject(new Spikes(2),2617,300);
        
        
        addObject(new TrackEnemy(2),1193,403);
        addObject(new TrackEnemy(2),2531,280);
        addObject(new TrackEnemy(2),2671,781);
        addObject(new TrackEnemy(2),2889,781);
  
        
        
        addObject(new Wall(1,2),1520,731);
        addObject(new Wall(1,2),1935,664);
        addObject(new Wall(1,2),1996,625);
        addObject(new Wall(1,2),2061,585);
        addObject(new Wall(1,2),2124,541);
        addObject(new Wall(1,2),2214,476);
        addObject(new Wall(1,2),2269,428);
        addObject(new Wall(3,2),2357,483);
        addObject(new Wall(3,2),2718,484);
        addObject(new Wall(1,2),2824,380);
        addObject(new Wall(1,2),2920,457);
        addObject(new Wall(1,2),2857,575);
        addObject(new Wall(1,2),2787,669);
        addObject(new Wall(4,2),3772,670);
        addObject(new Wall(1,2),2914,471);
        addObject(new Wall(1,2),2852,581);
        
        addObject(new Flag(),3862,782);
        
        
        
        addObject(new Powerup(2),1455,730);
        addObject(new Powerup(0),1252,408);
        addObject(new Powerup(1),2532,458);
        addObject(new Powerup(3),2634,414);
        addObject(new Powerup(2),2433,422);
        addObject(new Powerup(1),3614,558);
        
        
        
        //addObject(pd,122,40);
        addObject(new PushObject(),530,324);
        addObject(new PushObject(),2142,483);
        
        
        addObject(new WoodLog(),789,748);
        addObject(new WoodLog(),871,781);
        addObject(new WoodLog(),962,756);
        addObject(new WoodLog(),1049,722);
        addObject(new WoodLog(),1132,673);
        addObject(new WoodLog(),1431,585);
        addObject(new WoodLog(),1520,555);
        addObject(new WoodLog(),1598,582);
        addObject(new WoodLog(),1678,623);
        addObject(new WoodLog(),1759,686);
        addObject(new WoodLog(),1677,741);
        addObject(new WoodLog(),1860,714);
        addObject(new WoodLog(),1464,493);
        addObject(new WoodLog(),2620,579);
        addObject(new WoodLog(),2532,501);
        addObject(new WoodLog(),2634,458);
        addObject(new WoodLog(),2434,462);
        addObject(new WoodLog(),2324,769);
        addObject(new WoodLog(),3124,796);
        addObject(new WoodLog(),3241,756);
        addObject(new WoodLog(),3371,721);
        addObject(new WoodLog(),3497,754);
        addObject(new WoodLog(),3493,653);
        addObject(new WoodLog(),3612,605);
        addObject(new WoodLog(),3594,791);
        
        
        
        
        
        addObject(new Grass(20,2),300,885);
        addObject(new Grass(5,2),1279,635);
        addObject(new Grass(6,2),1279,468);
        addObject(new Grass(5,2),1521,799);
        addObject(new Grass(9,2),2539,344);
        addObject(new Grass(8,2),2560,684);
        addObject(new Grass(15,2),2714,845);
        addObject(new Grass(15,2),2714,845);
        addObject(new Grass(5,2),3764,845);
        addObject(new Grass(6,2),3034,445);
        
        
        addObject(new Tree(4),186,811);
        addObject(new Tree(5),412,650);
        addObject(new Tree(4),624,812);
        addObject(new Tree(4),2438,270);
        addObject(new Tree(4),2550,273);
        addObject(new Tree(4),2655,271);
        addObject(new Tree(4),2496,771);
        addObject(new Tree(4),2723,771);
        addObject(new Tree(5),2999,612);
        
        
        
        addObject(new DumbEnemy(2),2514,291);
        addObject(new DumbEnemy(2),2714,291);
        addObject(new DumbEnemy(2),292,832);
        addObject(new DumbEnemy(2),410,832);
        addObject(new DumbEnemy(2),1526,678);
        addObject(new DumbEnemy(2),2393,291);
        addObject(new DumbEnemy(2),2649,291);
        addObject(new DumbEnemy(2),2547,792);
        addObject(new DumbEnemy(2),2746,792);
        addObject(new DumbEnemy(2),3685,792);
        
        
        
       
        //addObject(new Moveable(), 500, 500);
    }
    
    //gets the game level and returns it
    public String getLevel()
    {
        return gameLevel;
    }
   
    
    /**
     *When the application has been paused when this World is loaded it will stop the music 
     */
    public void stopped()
    {
        super.stopped();
        muteControl.stop();
    }
    /**
     * When the application has started when this World is loaded it will play the music 
     */
    public void started()
    {
        if (!isPaused())    muteControl.play();
    }
    //     
    //     public int getStartScore(){
    //         return startScore;
    //     }
    //     
    //     public int getStartTime(){
    //         return startTime;
    //     }
    
   
}

