import greenfoot.*;

/**
 * Write a description of class Ammo here.
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
            System.out.println("fu");
            setImage("ammoPU.png");
        }
        else{setImage("ammoUnactive.png");}
    }    
}
