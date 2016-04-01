
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Mutes the sound playing in BG.
 * 
 * @author Sharaz, Mati, Viktor 
 * @version 0.1
 */
public class MuteControl extends UI
{
    //set specified sountrack
    private static GreenfootSound backgroundMusic;
    public static boolean isMuted = false;
    protected int currentVolume;
    private int volume = 100;
    private boolean oDown;
    private boolean pDown;
    private GreenfootImage img1 = new GreenfootImage("button-red.png");
    private GreenfootImage img2 = new GreenfootImage("button-green.png");

    public void act() 
    {
        if(isMuted){
            //if is muted, have muted image appear
            setImage(img1);
        }else{
            //if is not muted, have selected image appear
            setImage(img2);
        }
        //detect if user has clicked on image
        if(Greenfoot.mouseClicked(this))
        {
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

    /**
     * this returns he interger value of the background music 
     * @return int currentVolume he level that the sound is currently on
     */
    public int getVolume(){
        return currentVolume;
    }

    /**
     * Changes the image of the mute object and plays/stops music denpding on the state
     */
    private void updateState()
    {
        //if user has clicked on image to mute, set field to true and paude music
        if(!(isMuted))
        {
            setImage(img1);
            if(backgroundMusic !=null) backgroundMusic.pause();
            isMuted=true;
        }
        //if user has not clicked on image to mute, continue playing music on a constant loop (never ending)
        else {
            setImage(img2);
            if(backgroundMusic !=null) backgroundMusic.playLoop();
            isMuted=false;
        }
    }

    /**
     * Returns the state of the background music 
     * @return boolean isMuted if the sound is currently muted
     */
    public static boolean getIsMuted()
    {
        return isMuted;
    }

    /**
     * stops the background music 
     */
    public static void stop(){
        if(backgroundMusic !=null)backgroundMusic.stop();
    }

    /**
     * Plays the backgound music
     */
    public static void play()
    {
        if(backgroundMusic !=null)backgroundMusic.play();
    }
    
    public static void playSound(GreenfootSound s){
        if(!isMuted)s.play();
    }
    
    public static void setBGM(GreenfootSound s){
        stop();
        backgroundMusic = s;
        if (!isMuted) s.playLoop();
    }
}
