import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Transparency;
/**
 * Write a description of class PowerupDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PowerupDisplay extends UI
{
    /**
     * Act - do whatever the PowerupDisplay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    String empty = "No powerup";
    String jump = "Jump PU";
    String speed = "Speed PU";
    String ammo = "Attack PU";
    String both = "Speed+Jump pu";
    String triple = "Speed + Jump + Attack pu";
    Player player;
    Color transparent = new Color(0, 0, 0, 0);  

    PowerupDisplay(Player player){
        this.player = player;
    }

    public void act() 
    {
        display();
    }    

    public void display(){
        //only speed
        if (player.hasSpeedBoost() && !player.hasJumpBoost() && !player.hasAttackBoost()){
            setImage(new GreenfootImage("PowerUP: " + speed , 25, Color.WHITE, transparent));
        }
        //only jump
        if (player.hasJumpBoost() && !player.hasSpeedBoost() && !player.hasAttackBoost()){
            setImage(new GreenfootImage("PowerUP: " + jump , 25, Color.WHITE, transparent));
        }
        //attack only
        if (!player.hasJumpBoost() && !player.hasSpeedBoost() && player.hasAttackBoost()){
            setImage(new GreenfootImage("PowerUP: " +  ammo , 25, Color.WHITE, transparent));
        }
        //all
        if (player.hasJumpBoost() && player.hasSpeedBoost() && player.hasAttackBoost()){
            setImage(new GreenfootImage("PowerUP: " +  jump + "  " + ammo + "  " + speed , 25, Color.WHITE, transparent));
        }
        //jump and speed
        if (player.hasJumpBoost() && player.hasSpeedBoost() && !player.hasAttackBoost()){
            setImage(new GreenfootImage("PowerUP: " +  jump + "  " + speed , 25, Color.WHITE, transparent));
        }
        //jump and attack
        if (player.hasJumpBoost() && !player.hasSpeedBoost() && player.hasAttackBoost()){
            setImage(new GreenfootImage("PowerUP: " +  jump + "  " + ammo, 25, Color.WHITE, transparent));
        }
        //attack and speed
        if (!player.hasJumpBoost() && player.hasSpeedBoost() && player.hasAttackBoost()){
            setImage(new GreenfootImage("PowerUP: " + ammo + "  " + speed , 25, Color.WHITE, transparent));
        }
        //no powerups
        if(!player.hasSpeedBoost() && !player.hasJumpBoost() && !player.hasAttackBoost()){
            setImage(new GreenfootImage("PowerUP: " + empty , 25, Color.WHITE, transparent));
        }
    }
}

