import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Entity here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Entity extends ExtendedActor
{
    //http://codereview.stackexchange.com/questions/26697/best-way-to-get-the-smallest-possible-integer-ratio-between-two-numbers
    protected int vertVelocity=0;
    protected int horzVelocity=0;
    
    int gcd(int p, int q) {
        if (q == 0) return p;
        else return gcd(q, p % q);
    }

    public int getHorzVelocity(){
        return horzVelocity;
    }
    public int getVertVelocity(){
        return vertVelocity;
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
                //getWorld().addObject(new Particle(2),x+getX(),i+getY());
                if (getOneObjectAtOffset(x,i,Terrain.class)!=null ){
                    return true;
                }
            }
        return false;
    }
    public boolean upBlocked(){
        final int ow = getWidth()/2;
        final int oh = getHeight()/2;
        int y = -oh-1;
        for (int i=-ow+1;i<ow;i++){
            Actor a = getOneObjectAtOffset(i,y,Terrain.class);
            Terrain t = (Terrain)a;
            if (a!=null && !(t instanceof IPlatform)){
                return true;
            }
        }
        return false;
    }
    public boolean onPlatform()
    {
        if (vertVelocity<0) return false;
        final int o = getWidth()/2;
        for (int i=-o;i<-o+getWidth();i++){
            //getWorld().addObject(new Particle(2),i+getX(),getHeight()/2+getY()+1);
            Actor a = getOneObjectAtOffset(i,getHeight()/2+1,Terrain.class);
            Terrain t = (Terrain)a;
            if (a!=null && t.canSupportEntity(this)){
                return true;
            }
        }
        return false;
    }  
    //http://gamedev.stackexchange.com/questions/18302/2d-platformer-collisions
    
    public boolean collideMoveLocation(int dx, int dy){
        moveLocation(dx,dy);
        List<Terrain> c = getIntersectingObjects(Terrain.class);
        if (c.size()>0&&(dx!=0||dy!=0)){
            for (Terrain t:c){
                if (t instanceof IPlatform && dy<=0) continue;
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
                if (dx!=0 && !(t instanceof IPlatform) ){
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
                    System.out.println("Collision! xpen"+xpen+" dx"+dx+" ypen"+ypen+" dy"+dy);
                    //set position to most shallow penetration
                    if ( xpen>Math.abs(dx) && (ypen<xpen) || ypen<=Math.abs(dy) ) setLocation(ypen_x,ypen_y);
                    else if ( xpen>Math.abs(dx)){
                        System.out.println("Could not resolve x");
                        setLocation(x,y);
                    }
                }else if ( ypen>Math.abs(dy) ){
                    setLocation(x,y);
                    System.out.println("Could not resolve y");
                }else System.out.println("Collision!  ypen"+ypen+" dy"+dy);
            }
            return true;
        }
        return false;
    }
    public void fall(int g){
        if (!onPlatform()){
            vertVelocity+=g;
        }else{
            vertVelocity = 0;
        }
    }
    public boolean die(){
        getWorld().removeObject(this);
        return true;
    }
}
