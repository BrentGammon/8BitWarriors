import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MuteControl here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MuteControl extends Actor
{
    private static GreenfootSound backgroundMusic = new GreenfootSound("01ANightOfDizzySpells.mp3");
    private boolean isMuted;
    protected int currentVolume;
    private int volume = 100;
    private boolean oDown;
    private boolean pDown;
    /**
     * Act - do whatever the MuteControl wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    /* public void started(){
    backgroundMusic.playLoop();
    }*/
    MuteControl(){
        stop();
        updateState();
    }

    public void act() 
    {
        // backgroundMusic.playLoop();
        if(Greenfoot.mouseClicked(this))
        {
            isMuted = !isMuted;
            updateState();
        }
        if(!oDown && Greenfoot.isKeyDown("o") && isMuted == false ){
            oDown = true;
            volume -= 10;
            backgroundMusic.setVolume(volume);
        }
        if (oDown && !Greenfoot.isKeyDown("o") && isMuted == false ){
            oDown = false;
        }
        if(!pDown && Greenfoot.isKeyDown("p") && isMuted == false && volume <= 99 ){
            pDown = true;
            volume += 10;
            backgroundMusic.setVolume(volume);
        }
        if(pDown && !Greenfoot.isKeyDown("p") && isMuted == false && volume <= 99 ){
            pDown = false;
        }
    }

    public int getVolume(){
        return currentVolume;
    }

    private void updateState()
    {
        GreenfootImage img1 = new GreenfootImage("button-red.png");
        GreenfootImage img2 = new GreenfootImage("button-green.png");
        if(isMuted)
        {
            setImage(img1);
            backgroundMusic.pause();
        }
        else {
            setImage(img2);
            backgroundMusic.playLoop();

        }
    }

    public void stop(){
        backgroundMusic.stop();
    }
    
    public void play()
    {
        backgroundMusic.play();
    }
}
