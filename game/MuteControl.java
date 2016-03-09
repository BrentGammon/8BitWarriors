import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MuteControl here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MuteControl extends UI
{
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
    /* public void started(){
    backgroundMusic.playLoop();
    }*/
    MuteControl(){
        //stop();

        

        play();

    }

    public void act() 
    {
        // backgroundMusic.playLoop();
        //updateState();
        //if(Greenfoot.mouseClicked(this)){
        //   updateState(); 
        //}
        if(isMuted){

            setImage(img1);
        }else{
            setImage(img2);
        }
        if(isMuted==true){
            stop();
        }
        if(Greenfoot.mouseClicked(this))
        {

            updateState();
            //isMuted = !isMuted;
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

        if(!(isMuted))
        {
            setImage(img1);
            backgroundMusic.pause();
            isMuted=true;
        }
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
