import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Transparency;
/**
 * Write a description of class PowerupDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PowerupDisplay extends Actor
{
    /**
     * Act - do whatever the PowerupDisplay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    String empty = "No powerup";
    String jump = "Jump PU";
    String speed = "Speed PU";
    String both = "Speed+Jump pu";

    public void act() 
    {
        display();
    }    
    Color transparent = new Color(0, 0, 0, 0);  
    public void display(){
    if (Player.gotSpeedBoost == true){
    
       setImage(new GreenfootImage("PowerUP: " + speed , 25, Color.BLACK, transparent));
       
   }else if (Player.gotJumpBoost == true){
       
       setImage(new GreenfootImage("PowerUP: " + jump , 25, Color.BLACK, transparent));
  
   }else{
       
       setImage(new GreenfootImage("PowerUP: " + empty , 25, Color.BLACK, transparent));
       
   }
}
}




