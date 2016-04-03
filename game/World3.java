import greenfoot.*;

/**
 * Level 3 of the game, this consists of a boss and the end game scenario
 * 
 * @author Brent Gammon
 * @version S3 31/3/16
 */
public class World3 extends ExtendedWorld
{
    boolean begin;
    GreenfootSound bgm = new GreenfootSound("castle.mp3");
    protected int WORLD_WIDTH = 10000;
    protected int WORLD_HEIGHT = 900;
    /**
     * Constructor for objects of class World2.
     * 
     */
    public World3(int score, int time)
    {
        //call to superclass to use centreCameraOn function
        super(600,400,true);
        startScore = score;
        startTime = time;
        Timer timer = new Timer();
        timer.setTime(time);
        Counter counter = new Counter();
        counter.setValue(score);
        counter.updateImage();
        addObject(new BombCounter(),80,103);
        addObject(timer,52,35);
        addObject(counter,55,67);
        gameLevel = "3";
        layer1 = new GreenfootImage("images/Castle BackgroundBig.png");
        redrawBackground();
        Player p = new Player();
        addObject(new WorldEvents(),0,0);
        addObject(p,100,826);
        addObject(new Wall(30,3),15,779);
        addObject(new speed(p),320,67);
        addObject(new Ammo(p),400,67);
        addObject(new Jump(p),470,67);
        addObject(new Grass(20,3),301,885);
        addObject(new Grass(3,3),1679,590);
        addObject(new Grass(20,3),751,815);
        addObject(new WoodLog(),1300,790);
        addObject(new WoodLog(),1300,690);
        addObject(new WoodLog(),1300,590);
        addObject(new WoodLog(),1300,490);
        addObject(new RangeEnemy(false),1500,530);
        addObject(new Grass(5,3),1500,590);
        addObject(new Grass(5,3),1000,490);
        addObject(new WoodLog(),800,390);
        addObject(new WoodLog(),662,310);
        addObject(new Grass(10,3),260,360);
        addObject(new WoodLog(),300,221);
        addObject(new Grass(30,3),1072,152);
        addObject(new Wall(12,3),1885,324);
        addObject(new Wall(11,3),1769,502);
        addObject(new Grass(10,3),1972,896);
        addObject(new Grass(30,3),2981,896);
        addObject(new EnemyShield(),2453,837);
        addObject(new WoodLog(),3279,774);

        addObject(new Wall(15,3),3678,201);

        addObject(new Grass(10,3),2998,700);
        addObject(new Grass(5,3),3544,695);
        addObject(new EnemyShield(),3631,637);
        addObject(new WoodLog(),2608,621);
        addObject(new WoodLog(),2608,521);
        addObject(new WoodLog(),2608,421);
        addObject(new EnemyShield(),2232,337);
        addObject(new Grass(15,3),3057,361);
        addObject(new EnemyShield(),3087,304);
        addObject(new WoodLog(),2776,225);
        addObject(new WoodLog(),2875,168);
        addObject(new WoodLog(),3468,300);
        addObject(new WoodLog(),3603,250);
        addObject(new WoodLog(),3375,176);
        addObject(new WoodLog(),3463,156);
        addObject(new Grass(3,3),3611,108);
        addObject(new EnemyShield(),3617,50);
        addObject(new Grass(5,3),3088,167);
        addObject(new BossEnemy(3088,85),3088,85);
        addObject(new Grass(5,3),2316,622);
        addObject(new Grass(5,3),2319,396);
        //enemies
        addObject(new TrackEnemy(),636,753);
        addObject(new Spikes(1),826,769);
        addObject(new DumbEnemy(),950,757);
        addObject(new TrackEnemy(),112,299);
        addObject(new TrackEnemy(),648,87);
        addObject(new TrackEnemy(),882,88);
        addObject(new Spikes(2),1287,105);
        addObject(new DumbEnemy(),1776,96);
        addObject(new RangeEnemy(true),2403,566);
        addObject(new TrackEnemy(),2944,835);
        addObject(new TrackEnemy(),3058,642);
        addObject(new RangeEnemy(false),3567,640);
        addObject(new Spikes(0),2342,351);
        addObject(new TrackEnemy(),2891,296);
        addObject(new TrackEnemy(),3325,296);

        addObject(new Wall(3,3),3678,774);
        addObject(new Grass(5,3),3768,896);

        addObject(new Wall(4,3),3903,795);
        addObject(new Grass(4,3),3791,691);
        addObject(new Flag(),3795,830);
        MuteControl.setBGM(bgm);
    }

    /**
     * returns the level value
     * @return String gameLevel a string repentation of the level
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
        MuteControl.stop();
    }

    /**
     * When the application has started when this World is loaded it will play the music 
     */
    public void started()
    {
        MuteControl.setBGM(bgm);
    }
}
