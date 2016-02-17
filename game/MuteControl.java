import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MuteControl here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MuteControl extends ExtendedActor
{
    private GreenfootSound backgroundMusic = new GreenfootSound("lilwayne.wav");
    private boolean isMuted;
    /**
     * Act - do whatever the MuteControl wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   /* public void started(){
        backgroundMusic.playLoop();
    }*/
    MuteControl(){
        updateState();
    }
    
    public void act() 
    {
      //backgroundMusic.playLoop();
       if(Greenfoot.mouseClicked(this))
       {
          isMuted = !isMuted;
          updateState();
          
       }
    }    
    
    private void updateState()
    {
        GreenfootImage img1 = new GreenfootImage("button-red.png");
        GreenfootImage img2 = new GreenfootImage("button-green.png");
        if(isMuted)
        {
            setImage(img1);
            backgroundMusic.stop();
        }
        else {
            setImage(img2);
            
            backgroundMusic.playLoop();
        }
    }
    
    public void stop(){
        backgroundMusic.stop();
    }
}
