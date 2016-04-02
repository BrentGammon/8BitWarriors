import greenfoot.*;
import java.util.*;
/**
 * Allows the game levels to have events occur understand some scenarios 
 * 
 * @author Brent Gammon
 * @version 1/4/16
 */
public class WorldEvents extends Actor
{
    private boolean bossWall;
    private GreenfootImage sprite = new GreenfootImage("worldEvents.png");
    /**
     * Constructor for WorldEvents
     */
    public WorldEvents(){
        setImage(sprite);
    }

    /**
     * Gets the world and checks what level it is.
     */
    public void act() 
    {
        ExtendedWorld world =(ExtendedWorld) getWorld();
        if(world.getLevel().equals("3")){
            levelThreeEvents(world);
        }
    }    

    /**
     * Perform events in level 3
     * @param Extended world the world what the events are going to occur
     */
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
        List <BossEnemy> bossList = world.getObjects(BossEnemy.class);
        if(bossList.size()==0){
            removeWall(world);
        }
    }

    /**
     * Places a wall into the world when the player enters the boss arena
     * @param ExtendedWorld world the world that this event will be call in
     * @param Player player the player in the world
     */
    public void bossBattleWall(ExtendedWorld world,Player player){
        bossWall=true;
        World3 world3 = (World3) world;
        Wall wall = new Wall(30,3);
        world3.addObject(wall,player.getX()-157,player.getY());
    }

    public void removeWall(ExtendedWorld world){
        World3 world3 = (World3) world;
        List<Flag> flagList = world3.getObjects(Flag.class);
        Flag flag = flagList.get(0);
        List<Wall> wallList = world3.getObjects(Wall.class);
        //List <Actor> wallList = world3.getObjectsAt(3795,830,null);
        if(wallList.size()>0){
            for(Wall a : wallList){
                System.out.println(a.getRealX() + "  " + a.getRealY());
                if(a.getRealX()==3678&&a.getRealY()==774){
                    
                    world3.removeObject(a);
                }
            }
            //Wall wall = (Wall) wallList.get(0);
            //world.removeObject(wall);
        }

    }

}
