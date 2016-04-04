import greenfoot.*;

/**
 * Speed powerup to make the player quicker, displays if powerup is active or not.
 * 
 * @author Sharaz
 */
public class speed extends UI
{
    //stores current player in world
    Player player; 
    /**
     * Act - do whatever the speed wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    speed(Player p){
        player = p;
    }
    
    public void act() 
    {
        //if player has speed boost change image
        if(player.hasSpeedBoost()){
            System.out.println("fu");
            setImage("HUD/hudspeed.png");
        }
        else{setImage("HUD/hudspeedinactive.png");}
    }    
}
