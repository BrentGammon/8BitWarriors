package game;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MuteControl here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MuteControl extends UI
{
    //set specified sountrack
    private static GreenfootSound backgroundMusic = new GreenfootSound("01ANightOfDizzySpells.mp3");
    public static boolean isMuted = false;
    protected int currentVolume;
    private int volume = 100;
    private boolean oDown;
    private boolean pDown;
    private GreenfootImage img1 = new GreenfootImage("button-red.png");
    private GreenfootImage img2 = new GreenfootImage("button-green.png");
    /**
     * Act - do whatever the MuteControl wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    MuteControl(){
        //stop();
        play();

    }

    public void act() 
    {

        if(isMuted){
            //if is muted, have muted image appear
            setImage(img1);
        }else{
            //if is not muted, have selected image appear
            setImage(img2);
        }
        if(isMuted==true){
            //once user has clicked on mute icon, stop music
            stop();
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

    public int getVolume(){
        return currentVolume;
    }

    private void updateState()
    {
        //if user has clicked on image to mute, set field to true and paude music
        if(!(isMuted))
        {
            setImage(img1);
            backgroundMusic.pause();
            isMuted=true;
        }
        //if user has not clicked on image to mute, continue playing music on a constant loop (never ending)
        else {
            setImage(img2);
            backgroundMusic.playLoop();
            isMuted=false;
        }
    }

    public boolean getIsMuted()
    {
        return isMuted;
    }

    public void stop(){
        backgroundMusic.stop();
    }

    public void play()
    {
        backgroundMusic.play();
    }
}
