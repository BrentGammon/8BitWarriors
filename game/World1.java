 

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.TextField;
/**
 * First world for the game and the jungle world. Features simple design and monkeys as a themed enemy
 * 
 * @author Mitchell Rebuck-Watson
 * @version S2 1
 */
public class World1 extends ExtendedWorld
{
   boolean begin;
   private MuteControl muteControl;
   GreenfootSound bgm = new GreenfootSound("forest.mp3");
   private boolean bossDefeated = false;
   //private final String gameLevel = "1";
    /**
     * Constructor for objects of class World1.
     * 
     */
    public World1()
    {
        //call to superclass to use centreCameraOn function
        super(3900,900,600,400, true);
        MuteControl.setBGM(bgm);
        gameLevel = "1";
        Player p = new Player();
        //PowerupDisplay pd = new PowerupDisplay();
        //pd.setPlayer(p);
        //layer1_xoffset = -200;
        //layer1_yoffset = -100;
        layer1 = new GreenfootImage("images/jungleBig.png");
        
        redrawBackground();
        addObject(p,100,826);
        addObject(new Hud(0,0,p),113,62);

        addObject(new Tree(Tree.LARGE),172,650);
        
        addObject(new Tree(Tree.LARGE),586,650);
        addObject(new Tree(Tree.MED),336,811);
        addObject(new Tree(Tree.MED),436,811);
        addObject(new Tree(Tree.MED),536,811);
        addObject(new Tree(Tree.MED),636,811);
        
        
        //addObject(new Spikes(1),982,300);
        //addObject(new Spikes(2),868,300);
        addObject(new TrackEnemy(1),2500,650);
        addObject(new Grass(20,1),300,885);
        addObject(new MonkeyEnemy(),700,830);
        addObject(new Grass(20,1),1350,885);
        addObject(new Grass(10,1),2375,735);
        addObject(new WoodLog(),1875,735);
        addObject(new WoodLog(),1975,735);
        addObject(new WoodLog(),2075,735);
        addObject(new PushObject(),1700,750);
        //addObject(new Spikes(0),1500,840);
        //addObject(new Spikes(1),1400,840);
        //addObject(new Spikes(2),1300,840);
        addObject(new DumbEnemy(1),1350,750);
        addObject(new DumbEnemy(1),1450,750);
        addObject(new DumbEnemy(1),1550,750);
        addObject(new DumbEnemy(1),2155,117);
        
        addObject(new Wall(5,1),-22,675);
        addObject(new WoodLog(),2752,582);
        addObject(new WoodLog(),2650,645);
        addObject(new Grass(10,1),3114,735);
        
        
        addObject(new Tree(Tree.LARGE),3114,500);
        addObject(new Tree(Tree.LARGE),3114,200);
        
        addObject(new Grass(),3361,700);
        addObject(new Grass(),3406,670);
        addObject(new Grass(),3451,640);
        addObject(new Grass(),3496,610);
        addObject(new Grass(),3541,580);
        addObject(new Wall(9,1),3945,307);
        addObject(new Grass(8,1),3744,550);
        
        addObject(new WoodLog(),2811,288);
        
        addObject(new Grass(20,1),2250,310);
        
        addObject(new WoodLog(),2216,213);
        addObject(new Spikes(0),2239,264);
        addObject(new Wall(2,1),2161,205);
        
        addObject(new Spikes(0),1888,264);
        addObject(new Spikes(0),1908,264);
        addObject(new Spikes(0),1928,264);
        
        addObject(new Spikes(0),2008,264);
        addObject(new Spikes(0),2028,264);
        addObject(new Spikes(0),2048,264);
        
        addObject(new Tree(Tree.LARGE),1500,650);
        addObject(new Tree(Tree.LARGE),1500,350);
        addObject(new Tree(Tree.LARGE),1500,50);
        
        addObject(new Tree(Tree.SMALL),1114,823);
        addObject(new Tree(Tree.SMALL),1264,823);
        addObject(new Tree(Tree.SMALL),1414,823);
        addObject(new Tree(Tree.MED),995,811);
        
        addObject(new WoodLog(),1208,214);
        addObject(new WoodLog(),1369,214);
        addObject(new WoodLog(),1533,214);
        addObject(new WoodLog(),1711,214);
        addObject(new Grass(5,1),1025,256);
        addObject(new Flag(),951,192);
        
        addObject(new SuperMonkeyEnemy(),3790,465);
    }
    
    public void act(){
        super.act();
        if (!bossDefeated && getObjects(SuperMonkeyEnemy.class).size()==0){
            bossDefeated = true;
            addExtendedActor(new WoodLog(),3214,615);
            addExtendedActor(new WoodLog(),3214,485);
        
            addExtendedActor(new WoodLog(),3014,550);
            addExtendedActor(new WoodLog(),3014,420);
        
            addExtendedActor(new WoodLog(),3014,290);
            addExtendedActor(new WoodLog(),3214,355);
        }
    }
    
    /**
    *Method returns the String value of gameLevel
    *@return String gameLevel
    */
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
        MuteControl.setBGM(bgm);
    }
}

