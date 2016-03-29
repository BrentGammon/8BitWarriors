import greenfoot.*;
import java.util.*;
/**
 * Write a description of class ShieldPower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShieldPower extends Entity
{

    private boolean findCoords = true;
    private int bossX;
    private int bossY;
    
    private int thisY;
    private int thisX;
    public ShieldPower(int x, int y){
        thisY = y;
        thisX = x;
    }

    /**
     * Act - do whatever the ShieldPower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

        //if(findCoords){
        //    findCoords = false;
            List <Actor> bossList = getWorld().getObjects(BossEnemy.class);
            if(bossList.size()>0){
                BossEnemy be = (BossEnemy)bossList.get(0);
                bossY = be.getY();
                //bossY=be.getBossY();
                bossX = be.getX();
                //bossX=be.getBossX();
                //setLocation(x,y);
            }    

       // }

        findBoss();
        List <Actor> remove = getWorld().getObjects(BossEnemy.class);
        if(remove.size()>0){
            BossEnemy bb = (BossEnemy)remove.get(0);
            if(intersects(bb)){
                getWorld().removeObject(this);
            }

        }
        
    }

    private void findBoss(){
        int xx = getX();
        int yy = getY();
        
        int tryX=0;
        int tryY=0;
        if(xx<bossX){
            //xx++;
            tryX= 5;
        }else{
            //xx--;
            tryX=-5;
        }
        if(yy<bossY){
            //yy++;
            tryY=5;
        }else{
            //yy--;
            tryY=-5;
        }

        
        //if(x==bossX&&y==bossY||x==bossX+10&&y==bossY+10||x==bossX+10&&y==bossY-10||x==bossX-10&&y==bossY+10||x==bossX-10&&y==bossY-10){

        // }

        //moveLocation(xx,yy);
        moveLocation(tryX,tryY);
    }
}
