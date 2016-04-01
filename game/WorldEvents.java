import greenfoot.*;
import java.util.*;
/**
 * World Events
 * 
 * @author Brent, Mati
 * @version 0.1
 */
public class WorldEvents extends Actor
{
    private boolean bossWall;
    private GreenfootImage sprite = new GreenfootImage("worldEvents.png");
    public WorldEvents(){
        setImage(sprite);
    }

    /**
     * Act - do whatever the WorldEvents wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        ExtendedWorld world =(ExtendedWorld) getWorld();
        if(world.getLevel().equals("1")){

        }
        if(world.getLevel().equals("2")){

        }
        if(world.getLevel().equals("3")){
            levelThreeEvents(world);
        }
    }    

    public void levelThreeEvents(ExtendedWorld world){
        if(!bossWall){
            List <Player> playerList = world.getObjects(Player.class);//.get(0);
            if(playerList.size()>0){
                if(playerList.get(0)!=null && playerList.get(0)instanceof Player){
                    Player player = (Player) playerList.get(0);
                    if(player.getRealX()>=2343){
                        bossBattleWall(world,player);
                    }
                }
            }
        }
    }

    public void bossBattleWall(ExtendedWorld world,Player player){
        bossWall=true;
        World3 world3 = (World3) world;
        Wall wall = new Wall(30,3);
        world3.addObject(wall,player.getX()-157,player.getY());
    }
}
