import greenfoot.*;

/**
 * Write a description of class Jump here.
 * 
 * @author sharaz
 *
 */
public class Jump extends UI
{
   //stores current player in world
   Player player; 
    
   //called from world class
    Jump(Player p){
        player = p;
        
    }
    
    /**
     * Act - do whatever the Jump wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //check players method to see if he has jump boost, if so change image
        if(player.hasJumpBoost()){
            System.out.println("fu");
            setImage("jumpPU.png");
        }
        else{setImage("jumpUnactive.png");}
    }    
}
