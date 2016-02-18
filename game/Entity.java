import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Entity here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Entity extends ExtendedActor
{
    //http://codereview.stackexchange.com/questions/26697/best-way-to-get-the-smallest-possible-integer-ratio-between-two-numbers
    
    
    int gcd(int p, int q) {
        if (q == 0) return p;
        else return gcd(q, p % q);
    }

    public boolean endPlatform()
    {
        int xPost = getX()+5;
        Actor actor = getOneObjectAtOffset(0,getImage().getHeight()/2,Terrain.class);
        if(actor instanceof Terrain){
            return true;
        }else{
            return false;
        }
    }
    public boolean directionBlocked(String direction){
        final int ow = getWidth()/2;
        final int oh = getHeight()/2;
        int x = direction.equals("left")?-ow-1:ow+1;
        for (int i=-oh+1;i<oh;i++){
                getWorld().addObject(new Particle(2),x+getX(),i+getY());
                if (getOneObjectAtOffset(x,i,Terrain.class)!=null ){
                    return true;
                }
            }
        return false;
    }
    public boolean onPlatform()
    {
        final int o = getWidth()/2;
        for (int i=-o;i<-o+getWidth();i++){
            getWorld().addObject(new Particle(2),i+getX(),getHeight()/2+getY()+1);
            if (getOneObjectAtOffset(i,getHeight()/2+1,Terrain.class)!=null ){
                return true;
            }
        }
        return false;
        /*
        if(isTouching(Terrain.class)){
            return true;
        }
        return false;
        */
    }  
    //http://gamedev.stackexchange.com/questions/18302/2d-platformer-collisions
    public boolean collideMoveLocation(int dx, int dy){
        moveLocation(dx,dy);
        List<Terrain> c = getIntersectingObjects(Terrain.class);
        if (c.size()>0&&(dx!=0||dy!=0)){
            for (Terrain t:c){
                //need to not let pen be higher than dx or dy
                int cx = dx!=0?dx/Math.abs(dx):1;
                int cy = dy!=0?dy/Math.abs(dy):1;
                //if (Math.abs(t.getX()-getX())< Math.abs(t.getY()-getY()) ){
                
                //store curr pos
                int x = getX();
                int y = getY();
                //find y penetration
                int ypen = 0;
                while (intersects(t)){
                    ypen++;
                    //System.out.println("cx: "+cx+", cy: "+cy+", x: "+getX()+", y: "+getY());
                    moveLocation(0,-cy);
                }
                //if was actually moving sideways ( need to check horizontal pen )
                if (dx!=0){
                    //move back and store
                    int ypen_x = getX();
                    int ypen_y = getY();
                    setLocation(x,y);
                    
                    //find x penetration
                    int xpen = 0;
                    while (intersects(t)){
                        xpen++;
                        //System.out.println("cx: "+cx+", cy: "+cy+", x: "+getX()+", y: "+getY());
                        moveLocation(-cx,0);
                    }
                    System.out.println("Collision! xpen"+xpen+" dx"+dx+" ypen"+ypen);
                    //set position to most shallow penetration
                    if ( ypen<=Math.abs(dy)&&(ypen<xpen && xpen>Math.abs(dx)) )setLocation(ypen_x,ypen_y);
                }
            }
            return true;
        }
        return false;
    }
}
