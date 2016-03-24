package game;

import greenfoot.*;

/**
 * Write a description of class WoodLog here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
 