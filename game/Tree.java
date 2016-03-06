import greenfoot.*;

/**
 * Write a description of class Tree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tree extends Decoration
{
    public static final int JUNGLE = 1;
    public static final int MINI = 2;
    public static final int SMALL = 3;
    public static final int MED = 4;
    public static final int LARGE = 5;
    public Tree(int type){
        switch(type){
            case JUNGLE:
                setImage("Terrain/madtree.png");
                break;
            case MINI:
                setImage("Terrain/tree.png");
                break;
            case SMALL:
                setImage("Terrain/treex2.png");
                break;
            case MED:
                setImage("Terrain/treex3.png");
                break;
            case LARGE:
                setImage("Terrain/madtree.png");
                break;
            default:
                setImage("Terrain/tree.png");
                break;
            
        }
    }
}
