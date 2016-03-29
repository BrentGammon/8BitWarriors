import greenfoot.*;
/**
 * Simple image loader to help with managing sprites
 * 
 * @author Mitchell Rebuck-Watson
 * @version S3 1
 */
public class SpriteHelper  
{
    private static final GreenfootImage NUMBER_SPRITE = new GreenfootImage("images/numbers.png");
    private static final int WIDTH = NUMBER_SPRITE.getWidth()/10; 
    private static final int HEIGHT = NUMBER_SPRITE.getHeight();
    private static GreenfootImage[] numbers;
    public static void init(){
        
        numbers = new GreenfootImage[10];
        for (int i=0; i<10; i++){
            numbers[i] = new GreenfootImage(WIDTH,HEIGHT);
            numbers[i].drawImage(NUMBER_SPRITE,-i*WIDTH,0);
        }
    }
    
    public static GreenfootImage getNumberImage(int number){
        if (numbers == null) init();
        int length = Integer.toString(number).length();
        final GreenfootImage out = new GreenfootImage(length*WIDTH +((length-1)*1),HEIGHT);
        for (int i=length-1; i>=0; i--){
            out.drawImage(numbers[number%10],i*(WIDTH+1),0);
            number = number/10;
        }
        return out;
    }
}
