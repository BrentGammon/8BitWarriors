import greenfoot.*;

/**
 * Gives player more ammo, displays if powerup is active or not.
 * 
 * @author sharaz
 */
public class Ammo extends UI
{
    //stores current player in world
    Player player; 
    /**
     * Act - do whatever the Ammo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //called from world class
    Ammo(Player p){
        player = p;
       
    }
    
    public void act() 
    {
        //if player has attack booster then change image
        if(player.hasAttackBoost()){
            setImage("HUD/hudattack.png");
        }
        else{setImage("HUD/hudattackinactive.png");}
    }    
}
