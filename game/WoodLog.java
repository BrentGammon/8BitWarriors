 

import greenfoot.*;

/**
 * Basic one way platform that can be stood on but not collided with from the bottom or sides
 * @author Mitchell Rebuck Watson
 * @version S2 1
 */
public class WoodLog extends Terrain implements IPlatform
{
    public WoodLog(){
        setImage("Terrain/logbase.png");
    }
    private int getTop(){
        return getY()-(getHeight()/2);
    }
    @Override
    public boolean canSupportEntity(Entity e){
        System.out.println(e.getY()+(e.getHeight()/2) <= getTop());
        return e.getY()+(e.getHeight()/2) <= getTop();
    }
    public boolean bottomIsCollidable(){
        return false;
    }
}
 